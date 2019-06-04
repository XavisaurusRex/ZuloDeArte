package cat.devsofthecoast.mvp_utils.core.useCase

interface ErrorHandler {
    fun onError(t: Throwable)
}