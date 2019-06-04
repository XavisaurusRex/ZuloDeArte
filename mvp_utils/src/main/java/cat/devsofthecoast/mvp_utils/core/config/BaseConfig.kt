package cat.devsofthecoast.mvp_utils.core.config

import cat.devsofthecoast.mvp_utils.core.useCase.ErrorHandler
import cat.devsofthecoast.mvp_utils.core.useCase.PostExecutor
import cat.devsofthecoast.mvp_utils.core.useCase.ThreadExecutor

interface BaseConfig {
    fun getThreadExecutor(): ThreadExecutor
    fun getPostExecutor(): PostExecutor
    fun getErrorHandler(): ErrorHandler? = null
}