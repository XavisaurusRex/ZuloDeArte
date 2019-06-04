package cat.devsofthecoast.zulodearte.service.artwork

import cat.devsofthecoast.zulodearte.model.app.Artwork
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo

interface ArtworkService {
    fun requestArtworkList(callback: CallbackFromRepo<List<Artwork>>, onRecive: ((List<Artwork>) -> Unit))
}