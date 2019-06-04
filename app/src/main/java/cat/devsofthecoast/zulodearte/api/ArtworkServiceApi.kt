package cat.devsofthecoast.zulodearte.api

import cat.devsofthecoast.zulodearte.model.app.Artwork
import retrofit2.Call
import retrofit2.http.GET

interface ArtworkServiceApi {
    @GET(ENDPOINT)
    fun requestArtworkListData(): Call<List<Artwork>>

    companion object {
        const val ENDPOINT = "artworks.json"
        const val TAG_NAME = "ArtworkServiceApi"
    }
}