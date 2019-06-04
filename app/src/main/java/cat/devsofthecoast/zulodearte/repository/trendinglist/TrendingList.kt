package cat.devsofthecoast.zulodearte.repository.trendinglist

import retrofit2.Call
import retrofit2.http.GET

interface TrendingListService {


    @GET(API_ROUTE)
    fun getPost(): Call<List<TrendingApi>>

    companion object {
        const val API_ROUTE: String = "/trending_list.json"
    }
}