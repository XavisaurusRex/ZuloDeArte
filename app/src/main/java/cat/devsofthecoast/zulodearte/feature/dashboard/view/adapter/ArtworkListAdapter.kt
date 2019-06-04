package cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter

import android.view.ViewGroup
import cat.devsofthecoast.zulodearte.base.adapter.BaseAdapter
import cat.devsofthecoast.zulodearte.base.adapter.BaseViewHolder
import cat.devsofthecoast.zulodearte.base.exceptions.InvalidViewTypeException
import cat.devsofthecoast.zulodearte.feature.dashboard.components.ArtworkComponent
import cat.devsofthecoast.zulodearte.model.app.Artwork

class ArtworkListAdapter(dataSet: List<Artwork>) : BaseAdapter<BaseViewHolder>() {

    var dataSet: List<Artwork> = dataSet
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEWTYPE_ARTIST -> ArtworkViewHolder(
                    ArtworkComponent(parent.context)
            )
            VIEWTYPE_ARTWORK -> ArtworkViewHolder(
                    ArtworkComponent(parent.context)
            ) //ArtworkViewHolder()
            else -> throw InvalidViewTypeException()
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder.getyItemViewHolderType()) {
            VIEWTYPE_ARTIST -> {

            }
            VIEWTYPE_ARTWORK -> {
                (holder as ArtworkViewHolder).bind(dataSet[position])
                (holder as ArtworkViewHolder).decorate(dataSet[position])
            }
            else -> throw InvalidViewTypeException()
        }
    }

    override fun getItemCount(): Int = dataSet.size

    companion object {
        val VIEWTYPE_ARTIST = 0
        val VIEWTYPE_ARTWORK = 1
    }


}