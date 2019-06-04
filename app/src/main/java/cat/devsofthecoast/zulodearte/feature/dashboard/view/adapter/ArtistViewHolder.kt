package cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter

import android.view.View
import cat.devsofthecoast.zulodearte.base.adapter.BaseViewHolder
import cat.devsofthecoast.zulodearte.model.app.Artist

class ArtistViewHolder(itemView: View) : BaseViewHolder(itemView),
    ViewHolderItem<Artist> {
    override fun bind(element: Artist) {

    }

    override fun decorate(element: Artist) {
    }

    override fun getyItemViewHolderType(): Int {
        return ArtworkListAdapter.VIEWTYPE_ARTIST
    }
}