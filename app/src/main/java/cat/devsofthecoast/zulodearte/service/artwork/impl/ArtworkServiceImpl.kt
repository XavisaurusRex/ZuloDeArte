package cat.devsofthecoast.zulodearte.service.artwork.impl

import cat.devsofthecoast.zulodearte.BuildConfig
import cat.devsofthecoast.zulodearte.api.ArtworkServiceApi
import cat.devsofthecoast.zulodearte.base.exceptions.NotValidApiResponse
import cat.devsofthecoast.zulodearte.base.logs.LogHelper
import cat.devsofthecoast.zulodearte.model.app.Artwork
import cat.devsofthecoast.zulodearte.service.artwork.ArtworkService
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtworkServiceImpl : ArtworkService {
    override fun requestArtworkList(callback: CallbackFromRepo<List<Artwork>>, onRecive: ((List<Artwork>) -> Unit)) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ArtworkServiceApi::class.java)
        val call = service.requestArtworkListData()

        call.enqueue(object : Callback<List<Artwork>> {
            override fun onResponse(call: Call<List<Artwork>>, response: Response<List<Artwork>>) {
                if (response.isSuccessful && response.body() != null && response.body()!!.isNotEmpty()) {
                    onRecive.invoke(response.body()!!)
                    callback.onSuccess?.invoke(response.body()!!)
                    LogHelper.logWs(ArtworkServiceApi.TAG_NAME, response.code().toString())
                } else {
                    throw NotValidApiResponse(ArtworkServiceApi.TAG_NAME)
                }
            }

            override fun onFailure(call: Call<List<Artwork>>, t: Throwable) {
                callback.onError?.invoke(t)
            }
        })
    }
}