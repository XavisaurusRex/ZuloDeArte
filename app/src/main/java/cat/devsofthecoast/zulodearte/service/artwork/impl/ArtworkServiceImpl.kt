package cat.devsofthecoast.zulodearte.service.artwork.impl

import android.content.Context
import cat.devsofthecoast.zulodearte.R
import cat.devsofthecoast.zulodearte.api.ArtworkServiceApi
import cat.devsofthecoast.zulodearte.base.appconfig.ZDAAppConfig
import cat.devsofthecoast.zulodearte.base.exceptions.NotValidApiResponse
import cat.devsofthecoast.zulodearte.base.logs.LogHelper
import cat.devsofthecoast.zulodearte.base.service.BaseService
import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import cat.devsofthecoast.zulodearte.service.artwork.ArtworkService
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader

class ArtworkServiceImpl(var appConfig: ZDAAppConfig, var context: Context) : BaseService(), ArtworkService {

    override fun requestArtworkList(callback: CallbackFromRepo<ArtworkListApi>, onRecive: ((ArtworkListApi) -> Unit)) {
        if (appConfig.demoMode) {
            val reader = BufferedReader(context.resources.openRawResource(R.raw.artworkservice).bufferedReader())
            val artList: ArtworkListApi = GsonBuilder().create().fromJson(reader, ArtworkListApi::class.java)
            callback.onSuccess?.invoke(artList)
        } else {
            val service = retrofit.create(ArtworkServiceApi::class.java)
            val call = service.requestArtworkListData()

            call.enqueue(object : Callback<ArtworkListApi> {
                override fun onResponse(call: Call<ArtworkListApi>, response: Response<ArtworkListApi>) {
                    if (response.isSuccessful && response.body() != null && !(response.body()!!.empty!!)) {
                        onRecive.invoke(response.body()!!)
                        callback.onSuccess?.invoke(response.body()!!)
                        LogHelper.logWs(ArtworkServiceApi.TAG_NAME, response.code().toString())
                    } else {
                        throw NotValidApiResponse(ArtworkServiceApi.TAG_NAME)
                    }
                }

                override fun onFailure(call: Call<ArtworkListApi>, t: Throwable) {
                    callback.onError?.invoke(t)
                }
            })
        }
    }
}