package cat.devsofthecoast.zulodearte.repository.artwork

import cat.devsofthecoast.zulodearte.model.app.Artwork
import cat.devsofthecoast.zulodearte.usecase.artwork.CallbackFromRepo
import retrofit2.Callback

interface ArtworkRepository {
    fun getArtworks(onFinish: (CallbackFromRepo<List<Artwork>>.() -> Unit))
}