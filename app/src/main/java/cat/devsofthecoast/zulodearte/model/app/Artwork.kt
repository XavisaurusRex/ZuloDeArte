package cat.devsofthecoast.zulodearte.model.app

import com.google.gson.annotations.SerializedName

data class Artwork(
    @SerializedName("artwork_name")
    val artName: String,

    @SerializedName("picture_url")
    val pictureUrl: String,

    @SerializedName("creator")
    val autor: String,

    @SerializedName("date")
    val publishDate: String
)
