package cat.devsofthecoast.zulodearte.feature.dashboard.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AlphaAnimation
import androidx.constraintlayout.widget.ConstraintLayout
import cat.devsofthecoast.zulodearte.R
import kotlinx.android.synthetic.main.item_card_artwork_preview.view.*

class ArtworkComponent : ConstraintLayout {
    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    fun init(context: Context?, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.recycleritem_cardview, this)
        readAttrs(attrs)
        configureListeners()
    }

    private fun readAttrs(attrs: AttributeSet?) {}

    private fun configureListeners() {
        var alphaAnimationShowIcon = AlphaAnimation(0.2f, 1.0f)
        alphaAnimationShowIcon.duration = 500
        img_main_card2_favorite.tag = false
        img_main_card2_favorite.setOnClickListener {
            if (!((img_main_card2_favorite.tag as Boolean?)!!)) {
                img_main_card2_favorite.setImageResource(R.drawable.ic_favorite_black_24dp)
                img_main_card2_favorite.startAnimation(alphaAnimationShowIcon)
                img_main_card2_favorite.tag = true
            } else {
                img_main_card2_favorite.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                img_main_card2_favorite.startAnimation(alphaAnimationShowIcon)
                img_main_card2_favorite.tag = false
            }
        }
    }
}