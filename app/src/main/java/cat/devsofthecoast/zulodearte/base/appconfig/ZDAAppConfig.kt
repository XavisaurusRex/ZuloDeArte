package cat.devsofthecoast.zulodearte.base.appconfig

import cat.devsofthecoast.mvp_utils.core.async.thread.AsyncThreadExecutor
import cat.devsofthecoast.mvp_utils.core.async.ui.BAsyncPostExecutor
import cat.devsofthecoast.mvp_utils.core.config.BaseConfig

class ZDAAppConfig : BaseConfig {
    override fun getPostExecutor() = BAsyncPostExecutor()
    override fun getThreadExecutor() = AsyncThreadExecutor()

    var demoMode = false
}
