package cat.devsofthecoast.mvp_utils.core.useCase

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig

abstract class UseCase<I, R>(private val config: BaseConfig) {
    abstract fun run(input: I?, callback: Callback<R>?)

    operator fun invoke(
        params: I? = null,
        onSuccess: ((R) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        threadExecutor: ThreadExecutor = config.getThreadExecutor(),
        postExecutor: PostExecutor = config.getPostExecutor(),
        errorHandler: ErrorHandler? = config.getErrorHandler()
    ) {
        UseCaseExecutor<I, R>(config) {
            this.useCase = this@UseCase
            this.onSuccess = onSuccess
            this.onError = onError
            this.threadExecutor = threadExecutor
            this.postExecutor = postExecutor
            this.errorHandler = errorHandler
        }.execute(params)
    }
}