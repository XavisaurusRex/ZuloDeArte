package cat.devsofthecoast.zulodearte.feature.dashboard.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import cat.devsofthecoast.zulodearte.R
import kotlinx.android.synthetic.main.component_artwork.view.*

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
        LayoutInflater.from(context).inflate(R.layout.component_artwork, this)
        readAttrs(attrs)
        configureListeners()
    }

    private fun readAttrs(attrs: AttributeSet?) {}

    private fun configureListeners() {
        this.setOnClickListener {
            Toast.makeText(context, tvArtWorkName.text, Toast.LENGTH_SHORT).show()
        }
    }
}