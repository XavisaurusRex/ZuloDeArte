package cat.devsofthecoast.zulodearte.repository.trendinglist

import android.util.Log
import cat.devsofthecoast.zulodearte.BuildConfig.API_BASE_URL
import cat.devsofthecoast.zulodearte.model.Artwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TrendingService {

    @GET("artworks.json")
    fun getTrendingListData(): Call<List<Artwork>>

    companion object {
        fun getTrendingList() {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(TrendingService::class.java)
            val call = service.getTrendingListData()
            call.enqueue(object : Callback<List<Artwork>> {
                override fun onResponse(call: Call<List<Artwork>>, response: Response<List<Artwork>>) {
                    Log.d("TrendingService", "SIZE -> " + response.body()?.size)
                }

                override fun onFailure(call: Call<List<Artwork>>, t: Throwable) {
                    Log.d("TrendingService", t.message)
                }
            })
        }
    }
}