package cat.devsofthecoast.zulodearte.base.appconfig


import android.app.Application
import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class ZDAApplication : Application() {

    private val config by lazy { ZDAAppConfig() }
    private val appModules by lazy {  AppModules(config) }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ZDAApplication)
            modules(appModules.getList())
        }
    }

    fun getConfig(): BaseConfig {
        return config
    }
}