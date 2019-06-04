package cat.devsofthecoast.zulodearte.base.logs

import android.util.Log

class LogHelper {
    companion object {
        private const val WS_LOG_LEVEL = Log.DEBUG
        private const val WS_TAG_PREFIX = "FIREBASE_WS: "

        private const val CACHE_LOG_LEVEL = Log.DEBUG
        private const val CACHE_TAG_PREFIX = "CACHE: "
        private const val CACHE_MESSAGE = "Cached"

        fun logWs(serviceApiName: String, response: String) {
            Log.println(WS_LOG_LEVEL, WS_TAG_PREFIX + serviceApiName, response)
        }

        fun logCache(serviceApiName: String) {
            Log.println(CACHE_LOG_LEVEL, CACHE_TAG_PREFIX + serviceApiName, CACHE_MESSAGE)
        }
    }
}
