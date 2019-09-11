package cat.devsofthecoast.zulodearte.feature.dashboard.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cat.devsofthecoast.mvp_utils.core.ui.PresenterActivity
import cat.devsofthecoast.zulodearte.R
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter.ArtworkListAdapter
import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import kotlinx.android.synthetic.main.activity_dash_board.*
import org.koin.android.ext.android.inject


class DashBoardActivity : PresenterActivity<DashboardContract.Presenter, DashboardContract.View>(),
    DashboardContract.View {

    override val presenter: DashboardContract.Presenter by inject()

    private lateinit var adapter: ArtworkListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        configureRecycler()
        configureButtonRetry()
        presenter.getArtworkList()
    }

    private fun configureButtonRetry() {
        btnGetAgaindata.setOnClickListener {
            presenter.getArtworkList()
        }
    }

    private fun configureRecycler() {
        layoutManager = LinearLayoutManager(this)
        adapter = ArtworkListAdapter()
        rcyMain.layoutManager = layoutManager
        rcyMain.adapter = adapter
    }

    override fun trendingDataSucess(artworks: ArtworkListApi) {
        title = artworks.content!![0].artistName!!
        adapter.dataSet = artworks.content
    }

    override fun trendingDataError(error: Throwable) {
        Toast.makeText(this, "ERROR DE WS -> ${error.message}", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        llLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        llLoading.visibility = View.GONE
    }
}
