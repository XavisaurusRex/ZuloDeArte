package cat.devsofthecoast.zulodearte.service.artwork

import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo

interface ArtworkService {
    fun requestArtworkList(callback: CallbackFromRepo<ArtworkListApi>, onRecive: ((ArtworkListApi) -> Unit))
}