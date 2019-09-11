package cat.devsofthecoast.zulodearte.api

import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import retrofit2.Call
import retrofit2.http.GET

interface ArtworkServiceApi {
    @GET(ENDPOINT)
    fun requestArtworkListData(): Call<ArtworkListApi>

    companion object {
        const val ENDPOINT = "artworks"
        const val TAG_NAME = "ArtworkServiceApi"
    }
}