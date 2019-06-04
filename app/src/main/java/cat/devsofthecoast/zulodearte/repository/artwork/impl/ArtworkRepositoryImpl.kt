package cat.devsofthecoast.zulodearte.repository.artwork.impl

import cat.devsofthecoast.mvp_utils.cache.Cache
import cat.devsofthecoast.zulodearte.api.ArtworkServiceApi
import cat.devsofthecoast.zulodearte.base.logs.LogHelper
import cat.devsofthecoast.zulodearte.model.app.Artwork
import cat.devsofthecoast.zulodearte.repository.artwork.ArtworkRepository
import cat.devsofthecoast.zulodearte.service.artwork.ArtworkService
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo

class ArtworkRepositoryImpl(
    private val cache: Cache<String, List<Artwork>>,
    private val artworkService: ArtworkService
) : ArtworkRepository {

    private val CACHE_KEY_GET_ALL = "GET_ALL"

    override fun getArtworks(onFinish: (CallbackFromRepo<List<Artwork>>.() -> Unit)) {
        val callback = CallbackFromRepo(onFinish)
        if (cache.contains(CACHE_KEY_GET_ALL)) {
            LogHelper.logCache(ArtworkServiceApi.TAG_NAME)
            callback.onSuccess?.invoke(cache[CACHE_KEY_GET_ALL]!!)
        } else {
            artworkService.requestArtworkList(callback) {
                cache[CACHE_KEY_GET_ALL] = it
            }

        }

    }
}


