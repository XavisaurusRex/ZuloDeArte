package cat.devsofthecoast.zulodearte.feature.dashboard.presenter

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract

class DashboardPresenter(
    private val appConfig: BaseConfig
) : DashboardContract.Presenter() {

    override fun getTrendingData() {
    }

}