package cat.devsofthecoast.zulodearte.usecase.artwork

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.mvp_utils.core.useCase.Callback
import cat.devsofthecoast.mvp_utils.core.useCase.UseCase
import cat.devsofthecoast.mvp_utils.core.useCase.UseCaseExecutor
import cat.devsofthecoast.zulodearte.base.logs.LogHelper
import cat.devsofthecoast.zulodearte.model.app.Artwork
import cat.devsofthecoast.zulodearte.repository.artwork.ArtworkRepository
import retrofit2.Call
import retrofit2.Response

class GetArtworkListUseCase(
    private val appConfig: BaseConfig,
    private val artworkRepository: ArtworkRepository
) : UseCase<Void?, List<Artwork>>(appConfig) {
    override fun run(input: Void?, callback: Callback<List<Artwork>>?) {
        try {
            artworkRepository.getArtworks {
                onSuccess = {
                    callback?.onSuccess(it)
                }
                onError = {
                    callback?.onError(it)
                }
            }

        } catch (ex: Throwable) {
            callback?.onError(ex)
        }
    }

    class Executor(config: BaseConfig, builder: (UseCaseExecutor<Void?, List<Artwork>>.() -> Unit)?) :
        UseCaseExecutor<Void?, List<Artwork>>(config, builder)
}