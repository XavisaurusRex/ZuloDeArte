package cat.devsofthecoast.zulodearte.base.models.list

import com.google.gson.annotations.SerializedName

open class BaseListApi<T> {
    @SerializedName("content")
    val content: List<T>? = null
    @SerializedName("pageable")
    val pageable: Pageable? = null
    @SerializedName("totalPages")
    val totalPages: Int? = null
    @SerializedName("totalElements")
    val totalElements: Int? = null
    @SerializedName("last")
    val last: Boolean? = null
    @SerializedName("first")
    val first: Boolean? = null
    @SerializedName("sort")
    val sort: Sort? = null
    @SerializedName("numberOfElements")
    val numberOfElements: Int? = null
    @SerializedName("size")
    val size: Int? = null
    @SerializedName("number")
    val number: Int? = null
    @SerializedName("empty")
    val empty: Boolean? = null
}

