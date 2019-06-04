package cat.devsofthecoast.zulodearte.feature.dashboard

import cat.devsofthecoast.mvp_utils.core.presenter.BasePresenter
import cat.devsofthecoast.mvp_utils.core.presenter.BaseView
import cat.devsofthecoast.zulodearte.model.app.Artwork

interface DashboardContract {
    interface View : BaseView {
        fun trendingDataSucess(artworks: List<Artwork>)
        fun trendingDataError(error: Throwable)

        fun showLoading()
        fun hideLoading()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun getArtworkList()
    }
}