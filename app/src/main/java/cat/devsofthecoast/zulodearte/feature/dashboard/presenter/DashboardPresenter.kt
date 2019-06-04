package cat.devsofthecoast.zulodearte.feature.dashboard.presenter

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.usecase.artwork.GetArtworkListUseCase

class DashboardPresenter(
    private val appConfig: BaseConfig,
    private val getArtworkListUseCase: GetArtworkListUseCase
) : DashboardContract.Presenter() {

    override fun getArtworkList() {
        view?.showLoading()
        GetArtworkListUseCase.Executor(appConfig) {
            useCase = getArtworkListUseCase
            onSuccess = {
                view?.hideLoading()
                view?.trendingDataSucess(it)
            }
            onError = {
                view?.hideLoading()
                view?.trendingDataError(it)
            }
        }.execute()
    }

}