package cat.devsofthecoast.mvp_utils.core.useCase

interface Callback<R> {
    fun onSuccess(result: R)

    fun onError(t: Throwable)
}