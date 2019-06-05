package cat.devsofthecoast.zulodearte.feature.testanimations

import cat.devsofthecoast.mvp_utils.core.presenter.BasePresenter
import cat.devsofthecoast.mvp_utils.core.presenter.BaseView

interface TestAnimationsContract {
    interface View : BaseView {
        fun animateView()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun prepareAnimation()
    }
}