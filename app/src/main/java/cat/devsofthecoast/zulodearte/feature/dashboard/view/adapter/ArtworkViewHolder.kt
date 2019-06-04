package cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter

import android.view.View
import cat.devsofthecoast.zulodearte.base.adapter.BaseViewHolder
import cat.devsofthecoast.zulodearte.feature.dashboard.components.ArtworkComponent
import cat.devsofthecoast.zulodearte.model.app.Artwork
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.component_artwork.view.*

class ArtworkViewHolder(itemView: View) : BaseViewHolder(itemView),
        ViewHolderItem<Artwork> {
    lateinit var item: ArtworkComponent

    override fun bind(element: Artwork) {
        item = itemView as ArtworkComponent
    }

    override fun decorate(element: Artwork) {
        item.tvArtWorkName.text = element.artName
        item.tvArtistName.text = element.autor
        Glide.with(item.context)
                .load(element.pictureUrl)
                .into(item.ivArtWorkPreview)

    }

    override fun getyItemViewHolderType(): Int {
        return ArtworkListAdapter.VIEWTYPE_ARTWORK
    }
}