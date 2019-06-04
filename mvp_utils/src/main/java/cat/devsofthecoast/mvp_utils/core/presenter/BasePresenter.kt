package cat.devsofthecoast.mvp_utils.core.presenter

abstract class BasePresenter<V : BaseView> {
    var view: V? = null
}