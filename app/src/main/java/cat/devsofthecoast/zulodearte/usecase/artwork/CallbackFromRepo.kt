package cat.devsofthecoast.zulodearte.usecase.artwork

class CallbackFromRepo<R>(
    builder: CallbackFromRepo<R>.() -> Unit
) {
    var onSuccess: ((R) -> Unit)? = null
    var onError: ((Throwable) -> Unit)? = null

    init {
        builder.invoke(this)
    }


}