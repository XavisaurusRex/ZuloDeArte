package cat.devsofthecoast.zulodearte.feature.testanimations.view

import android.R.attr.pivotX
import android.R.attr.pivotY
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import cat.devsofthecoast.mvp_utils.core.ui.PresenterActivity
import cat.devsofthecoast.zulodearte.R
import cat.devsofthecoast.zulodearte.feature.testanimations.TestAnimationsContract
import kotlinx.android.synthetic.main.activity_test_animations.*
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit


class TestAnimationsActivity : PresenterActivity<TestAnimationsContract.Presenter, TestAnimationsContract.View>(),
    TestAnimationsContract.View {

    override val presenter: TestAnimationsContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_animations)
        configAnimations()
    }

    private fun configAnimations() {
        val objectAnimator: ObjectAnimator =
            ObjectAnimator.ofFloat(star, "circleWidth", 0f, 240f)
        objectAnimator.repeatMode = ValueAnimator.REVERSE
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.interpolator = AccelerateInterpolator()
        objectAnimator.duration = TimeUnit.SECONDS.toMillis(3)-10
        objectAnimator.start()

        val an = RotateAnimation(0.0f, 360.0f, 300f, 300f)
        an.duration = TimeUnit.SECONDS.toMillis(3)
        an.repeatCount = ValueAnimator.INFINITE
        an.repeatMode = ValueAnimator.REVERSE
        an.interpolator = AccelerateInterpolator()
        star.animation = an
        star.animation.start()
    }

    override fun animateView() {
        Toast.makeText(this, "Should animate some shit of this view", Toast.LENGTH_LONG).show()
    }
}