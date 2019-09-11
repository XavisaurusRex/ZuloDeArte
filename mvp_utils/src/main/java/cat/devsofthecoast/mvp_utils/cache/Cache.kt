package cat.devsofthecoast.mvp_utils.cache

import java.util.*
import java.util.concurrent.TimeUnit

class Cache<K, V> {
    private val cache: HashMap<K, Data<V>> = hashMapOf()

    operator fun get(key: K): V? {
        return cache[key]?.value
    }

    operator fun set(key: K, value: V) {
        cache[key] = Data(value)
    }

    operator fun contains(key: K): Boolean {
        return isValid(key)
    }

    private fun isValid(key: K): Boolean {
        return cache[key] != null && cache[key]!!.value != null && cache[key]!!.isValid()
    }

    inner class Data<V> {
        private val DEFAULT_VALUE_TIMEOUT = TimeUnit.SECONDS.toMillis(60)
        private var receivedTime: Long = 0

        var timeout: Long = DEFAULT_VALUE_TIMEOUT

        fun isValid(): Boolean = System.currentTimeMillis() - receivedTime <= timeout

        var value: V? = null
            set(value) {
                field = value
                receivedTime = System.currentTimeMillis()
            }

        private constructor()

        constructor(value: V) : this() {
            this.value = value
        }

    }
}
