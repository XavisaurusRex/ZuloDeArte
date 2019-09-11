package cat.devsofthecoast.zulodearte.base.service

import cat.devsofthecoast.zulodearte.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseService {

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .client(
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SEC_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SEC_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SEC_WRITE, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        private val TIMEOUT_SEC_CONNECT: Long = 60
        private val TIMEOUT_SEC_READ: Long = 30
        private val TIMEOUT_SEC_WRITE: Long = 30
    }
}
