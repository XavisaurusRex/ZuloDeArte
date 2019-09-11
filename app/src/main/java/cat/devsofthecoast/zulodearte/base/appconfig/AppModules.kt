package cat.devsofthecoast.zulodearte.base.appconfig

import cat.devsofthecoast.mvp_utils.cache.Cache
import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.feature.dashboard.presenter.DashboardPresenter
import cat.devsofthecoast.zulodearte.feature.testanimations.TestAnimationsContract
import cat.devsofthecoast.zulodearte.feature.testanimations.presenter.TestAnimationsPresenter
import cat.devsofthecoast.zulodearte.model.api.ArtworkApi
import cat.devsofthecoast.zulodearte.repository.artwork.ArtworkRepository
import cat.devsofthecoast.zulodearte.repository.artwork.impl.ArtworkRepositoryImpl
import cat.devsofthecoast.zulodearte.service.artwork.ArtworkService
import cat.devsofthecoast.zulodearte.service.artwork.impl.ArtworkServiceImpl
import cat.devsofthecoast.zulodearte.usecase.artwork.GetArtworkListUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

class AppModules(config: ZDAAppConfig) {
    fun getList(): List<Module> {
        return listOf(baseModules, serviceModule, repositoryModule, useCaseModule, presenterModule)
    }

    val baseModules = module {
        single<BaseConfig> { config }
        single { config }
        single { Cache<String, List<ArtworkApi>>() }
    }

    val serviceModule = module {
        factory { ArtworkServiceImpl(get(), get()) as ArtworkService }
    }

    val repositoryModule = module {
        factory { ArtworkRepositoryImpl(get(), get()) as ArtworkRepository }
    }

    val useCaseModule = module {
        factory { GetArtworkListUseCase(get(), get()) }
    }
    val presenterModule = module {
        factory { DashboardPresenter(get(), get()) as DashboardContract.Presenter }
        factory { TestAnimationsPresenter() as TestAnimationsContract.Presenter }
    }
}

