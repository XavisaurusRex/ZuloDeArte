package cat.devsofthecoast.mvp_utils.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import cat.devsofthecoast.mvp_utils.core.presenter.BasePresenter
import cat.devsofthecoast.mvp_utils.core.presenter.BaseView

abstract class PresenterFragment<P : BasePresenter<V>, V : BaseView> :
    Fragment(), BaseView {
    protected abstract val presenter: P


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.view = this as V
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.view = null
    }
}