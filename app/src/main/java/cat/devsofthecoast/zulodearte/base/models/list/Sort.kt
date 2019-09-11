package cat.devsofthecoast.zulodearte.base.models.list

import com.google.gson.annotations.SerializedName

data class Sort(
    @SerializedName("sorted")
    val sorted: Boolean,
    @SerializedName("unsorted")
    val unsorted: Boolean,
    @SerializedName("empty")
    val empty: Boolean
)
