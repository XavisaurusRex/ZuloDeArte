package cat.devsofthecoast.zulodearte.feature.dashboard

import cat.devsofthecoast.mvp_utils.core.presenter.BasePresenter
import cat.devsofthecoast.mvp_utils.core.presenter.BaseView

interface DashboardContract {
    interface View : BaseView {
        fun trendingDataSucess()
        fun trendingDataError()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun getTrendingData()
        abstract fun sayHello(): String
    }
}