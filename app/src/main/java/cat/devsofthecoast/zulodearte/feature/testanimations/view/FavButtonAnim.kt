package cat.devsofthecoast.zulodearte.feature.testanimations.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class FavButtonAnim : View {

    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val paint_aux: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val shadowPaint = Paint(0).apply {
        color = 0x101010
        maskFilter = BlurMaskFilter(8f, BlurMaskFilter.Blur.NORMAL)
    }
    lateinit var starPoints: FloatArray
    var outCircle = -1f
    var inCircle = -1f
    var circleWidth = 50f
    var peakNumber = 5

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
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 1f
        paint.color = Color.BLACK //ContextCompat.getColor(context, R.color.fillYellowStar)

        paint_aux.style = Paint.Style.STROKE
        paint_aux.strokeWidth = 1f
        paint_aux.color = Color.BLUE //ContextCompat.getColor(context, R.color.fillYellowStar)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            // Draw the shadow
//            drawOval(RectF(clipBounds), shadowPaint)

            drawLines(
                starPoints, 0,
                starPoints.size, paint
            )
//            val nose= floatArrayOf(
//                550.0f, 300.0f,
//                502.25427f, 446.9463f,
//                502.25427f, 446.9463f,
//                377.25424f, 537.76416f,
//                377.25424f, 537.76416f,
//                222.74574f, 537.7641f,
//                222.74574f, 537.7641f,
//                97.74573f, 446.9463f,
//                97.74573f, 446.9463f,
//                50.0f, 299.99997f,
//                50.0f, 299.99997f,
//                97.74576f, 153.05367f,
//                97.74576f, 153.05367f,
//                222.74573f, 62.235886f,
//                222.74573f, 62.235886f,
//                377.25427f, 62.235886f,
//                377.25427f, 62.235886f,
//                502.25424f, 153.05368f,
//                502.25424f, 153.05368f,
//                550.0f, 300.0f
//                )
//            drawLines(nose, 0, nose.size,
//            paint_aux)
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val desiredWidthHeight = 100

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
        recalculateStar(w, h)
    }

    private fun recalculateStar(width: Int, height: Int) {
//        outCircle = (min(width, height) - max(marginStart, marginEnd)).toFloat()
//        circleWidth = outCircle / 2f
//        inCircle = outCircle - circleWidth
//        val centerXY = width/2f
//
//        val everyAngleSum = 360f / (peakNumber * 2).toFloat()
//        val points = arrayListOf<Float>()
//
//        for (i in 0 until peakNumber * 2) {
//            val base = if (i % 2 == 0) {
//                centerXY/ 2f + outCircle
//            } else {
//                centerXY/ 2f + inCircle
//            }
//            points.add(base * cos(Math.toRadians((everyAngleSum * i).toDouble()).toFloat()))
//            points.add(base * sin(Math.toRadians((everyAngleSum * i).toDouble()).toFloat()))
//        }
//
//        starPoints = points.toFloatArray()

        outCircle = ((min(width, height)).toFloat() - 100f) / 2f
        val centerXY = width / 2f

        val everyAngleSum = 360f / 10f
        val points = arrayListOf<Float>()
        points.add(centerXY + outCircle * cos(Math.toRadians((everyAngleSum * 0).toDouble()).toFloat()))
        points.add(centerXY + outCircle * sin(Math.toRadians((everyAngleSum * 0).toDouble()).toFloat()))
        for (i in 1 until 10) {


            val x = centerXY + outCircle * cos(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
            val y = centerXY + outCircle * sin(Math.toRadians((everyAngleSum * i).toDouble()).toFloat())
            points.add(x)
            points.add(y)
            points.add(x)
            points.add(y)
        }
        points.add(points[0])
        points.add(points[1])
        starPoints = points.toFloatArray()
    }
}