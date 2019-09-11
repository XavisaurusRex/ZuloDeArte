package cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter

import android.view.View
import cat.devsofthecoast.zulodearte.base.adapter.BaseViewHolder
import cat.devsofthecoast.zulodearte.feature.dashboard.components.ArtworkComponent
import cat.devsofthecoast.zulodearte.model.api.ArtworkApi
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_artwork_preview.view.*

class ArtworkViewHolder(itemView: View) : BaseViewHolder(itemView),
    ViewHolderItem<ArtworkApi> {
    lateinit var item: ArtworkComponent

    override fun bind(element: ArtworkApi) {
        item = itemView as ArtworkComponent
    }

    override fun decorate(element: ArtworkApi) {
        Glide.with(item.context)
            .load(element.imageUrl)
            .into(item.ivPicture)

        item.tvTitle.text = element.artWorkName
        item.tvSubtitle.text = element.description
    }

    override fun getyItemViewHolderType(): Int {
        return ArtworkListAdapter.VIEWTYPE_ARTWORK
    }
}