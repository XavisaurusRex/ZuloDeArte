package cat.devsofthecoast.mvp_utils.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cat.devsofthecoast.mvp_utils.core.presenter.BasePresenter
import cat.devsofthecoast.mvp_utils.core.presenter.BaseView


abstract class PresenterActivity<P : BasePresenter<V>, V : BaseView> :
    AppCompatActivity(), BaseView {

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