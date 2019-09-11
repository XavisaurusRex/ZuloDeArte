package cat.devsofthecoast.zulodearte.feature.testanimations.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.RotateAnimation
import java.util.concurrent.TimeUnit
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class FavButtonAnim : View {

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var starPoints: FloatArray

    var outCircle = DEFAULT_WIDTH_HEIGHT / 2f
        set(value) {
            inCircle = value - circleWidth
            field = value
            recalculateStar()
        }

    var circleWidth = outCircle / 3f
        set(value) {
            inCircle = outCircle - value
            field = value
            recalculateStar()
            invalidate()
        }
    private var inCircle = outCircle - circleWidth
    var peakNumber = DEFAULT_PEAK_NUMBER

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    init {
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 1f
        paint.color = Color.BLACK //ContextCompat.getColor(context, R.color.fillYellowStar)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawLines(
                starPoints, 0,
                starPoints.size, paint
            )

        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidthHeight = DEFAULT_WIDTH_HEIGHT

        var widthHeight = min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec))
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        widthHeight = when (widthMode) {
            MeasureSpec.EXACTLY -> widthHeight
            MeasureSpec.AT_MOST -> min(desiredWidthHeight, widthHeight)
            else -> desiredWidthHeight
        }

        setMeasuredDimension(widthHeight, widthHeight)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        outCircle = w / 2f
        circleWidth = outCircle / 3f
    }

    private fun recalculateStar() {
        val centerXY = width / 2f

        val everyAngleSum = 360f / (peakNumber * 2)
        val points = arrayListOf<Float>()

        points.add(centerXY + outCircle * cos(Math.toRadians((everyAngleSum * 0).toDouble()).toFloat()))
        points.add(centerXY + outCircle * sin(Math.toRadians((everyAngleSum * 0).toDouble()).toFloat()))

        for (i in 1 until (peakNumber * 2)) {
            val x: Float
            val y: Float

            if (i % 2 != 0) {
                x = centerXY + inCircle * cos(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
                y = centerXY + inCircle * sin(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
            } else {
                x = centerXY + outCircle * cos(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
                y = centerXY + outCircle * sin(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
            }

            points.add(x)
            points.add(y)
            points.add(x)
            points.add(y)
        }
        points.add(points[0])
        points.add(points[1])
        starPoints = points.toFloatArray()
    }

    companion object {
        private const val DEFAULT_WIDTH_HEIGHT = 100
        private const val DEFAULT_PEAK_NUMBER = 10
    }
}