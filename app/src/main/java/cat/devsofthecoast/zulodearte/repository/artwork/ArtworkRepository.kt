package cat.devsofthecoast.zulodearte.repository.artwork

import cat.devsofthecoast.zulodearte.model.api.ArtworkApi
import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo

interface ArtworkRepository {
    fun getArtworks(onFinish: (CallbackFromRepo<ArtworkListApi>.() -> Unit))
}