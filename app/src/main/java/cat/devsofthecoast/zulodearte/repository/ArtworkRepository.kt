package cat.devsofthecoast.zulodearte.repository

import cat.devsofthecoast.zulodearte.repository.trendinglist.TrendingService

class ArtworkRepository(private val trendingService: TrendingService) {

    fun getArtworks() {
        //if(!isInCache)
        trendingService.getTrendingListData()
    }
}