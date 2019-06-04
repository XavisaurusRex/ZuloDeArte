package cat.devsofthecoast.mvp_utils.core.async.ui

import android.os.Handler
import android.os.Looper
import cat.devsofthecoast.mvp_utils.core.useCase.PostExecutor

class CNAAsyncPostExecutor : PostExecutor {
    private val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun execute(runnable: Runnable?) {
        handler.post(runnable)
    }
}