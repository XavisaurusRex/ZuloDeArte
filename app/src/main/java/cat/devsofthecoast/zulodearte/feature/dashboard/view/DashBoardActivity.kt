package cat.devsofthecoast.zulodearte.feature.dashboard.view

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cat.devsofthecoast.mvp_utils.core.ui.PresenterActivity
import cat.devsofthecoast.zulodearte.R
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter.TrendingListAdapter
import cat.devsofthecoast.zulodearte.model.Artwork
import kotlinx.android.synthetic.main.activity_dash_board.*
import org.koin.android.ext.android.inject
import java.util.*


class DashBoardActivity : PresenterActivity<DashboardContract.Presenter, DashboardContract.View>(),
    DashboardContract.View {

    override val presenter: DashboardContract.Presenter by inject()

//    @Inject
//    lateinit var artworkRepository: ArtworkRepository

    private lateinit var adapter: TrendingListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        configureRecycler()
//        Timer().schedule(1000) {
//            artworkRepository.getArtworks()
//        }
        Toast.makeText(this, presenter.sayHello(), Toast.LENGTH_SHORT).show()
    }

    private fun configureRecycler() {
        layoutManager = LinearLayoutManager(this)
        adapter = TrendingListAdapter(generateRandomData())
        rcyMain.layoutManager = layoutManager
        rcyMain.adapter = adapter
    }

    private fun generateRandomData(): ArrayList<Artwork> {
        val arrayList: ArrayList<Artwork> = arrayListOf()
        arrayList.add(
            Artwork(
                "",
                "Zebra, common",
                "Vogel's Tephrosia",
                ""
            )
        )
        arrayList.add(Artwork("", "Meerkat", "Lathberry", ""))
        arrayList.add(
            Artwork(
                "",
                "Eagle, white-bellied sea",
                "Purple Milkvetch",
                ""
            )
        )
        arrayList.add(
            Artwork(
                "",
                "South American meadowlark (unidentified)",
                "Haupu Range Yellow Loosestrife",
                ""
            )
        )
        arrayList.add(
            Artwork(
                "",
                "Malabar squirrel",
                "Wonderful Cryptantha",
                ""
            )
        )
        arrayList.add(
            Artwork(
                "",
                "Giant girdled lizard",
                "Hybrid Violet",
                ""
            )
        )
        return arrayList
    }

    override fun trendingDataSucess() {

    }

    override fun trendingDataError() {

    }
}
