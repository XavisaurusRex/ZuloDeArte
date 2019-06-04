package cat.devsofthecoast.mvp_utils.core.presenter

interface ViewProvider<V : BaseView?> {
    var view: V?
}