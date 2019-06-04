package cat.devsofthecoast.zulodearte.base.appconfig


import android.app.Application
import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.feature.dashboard.presenter.DashboardPresenter
import cat.devsofthecoast.zulodearte.repository.HelloRepository
import cat.devsofthecoast.zulodearte.repository.HelloRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ZDAApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ZDAApplication)
            // modules
            modules(appModule)
        }
    }

    val appModule = module {

        // single instance of HelloRepository
        single<HelloRepository> { HelloRepositoryImpl() }
        single<DashboardContract.Presenter>{ DashboardPresenter(config, get()) }
        // Simple Presenter Factory
        factory {

        }
    }

    private val config by lazy { ZDAAppConfig() }

    fun getConfig(): BaseConfig {
        return config
    }
}