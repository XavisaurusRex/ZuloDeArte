package cat.devsofthecoast.zulodearte.feature.dashboardv2.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import cat.devsofthecoast.zulodearte.R
import com.google.android.material.navigation.NavigationView


class MyNavigation : NavigationView {
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
        LayoutInflater.from(context).inflate(R.layout.navigation_menu, this)
    }
}