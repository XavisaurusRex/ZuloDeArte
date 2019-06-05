package cat.devsofthecoast.zulodearte.feature.testanimations.view

import android.os.Bundle
import android.widget.Toast
import cat.devsofthecoast.mvp_utils.core.ui.PresenterActivity
import cat.devsofthecoast.zulodearte.R
import cat.devsofthecoast.zulodearte.feature.testanimations.TestAnimationsContract
import org.koin.android.ext.android.inject

class TestAnimationsActivity : PresenterActivity<TestAnimationsContract.Presenter, TestAnimationsContract.View>(),
    TestAnimationsContract.View {

    override val presenter: TestAnimationsContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_animations)
        configAnimations()
    }

    private fun configAnimations() {
    }

    override fun animateView() {
        Toast.makeText(this, "Should animate some shit of this view", Toast.LENGTH_LONG).show()
    }
}