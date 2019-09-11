package cat.devsofthecoast.zulodearte.base.models.list

import com.google.gson.annotations.SerializedName

data class Pageable(
    @SerializedName("sort")
    val sort: Sort,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("pageNumber")
    val pageNumber: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("paged")
    val paged: Boolean,
    @SerializedName("unpaged")
    val unpaged: Boolean
)
