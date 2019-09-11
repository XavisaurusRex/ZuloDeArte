package cat.devsofthecoast.zulodearte.usecase.artwork

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.mvp_utils.core.useCase.Callback
import cat.devsofthecoast.mvp_utils.core.useCase.UseCase
import cat.devsofthecoast.mvp_utils.core.useCase.UseCaseExecutor
import cat.devsofthecoast.zulodearte.model.api.ArtworkApi
import cat.devsofthecoast.zulodearte.model.api.ArtworkListApi
import cat.devsofthecoast.zulodearte.repository.artwork.ArtworkRepository

class GetArtworkListUseCase(
    private val appConfig: BaseConfig,
    private val artworkRepository: ArtworkRepository
) : UseCase<Void?, ArtworkListApi>(appConfig) {
    override fun run(input: Void?, callback: Callback<ArtworkListApi>?) {
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

    class Executor(config: BaseConfig, builder: (UseCaseExecutor<Void?, ArtworkListApi>.() -> Unit)?) :
        UseCaseExecutor<Void?, ArtworkListApi>(config, builder)
}