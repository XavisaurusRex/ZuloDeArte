package cat.devsofthecoast.zulodearte.feature.dashboard.presenter

import cat.devsofthecoast.mvp_utils.core.config.BaseConfig
import cat.devsofthecoast.zulodearte.feature.dashboard.DashboardContract
import cat.devsofthecoast.zulodearte.repository.HelloRepository

class DashboardPresenter(
    private val appConfig: BaseConfig,
    private val helloRepository: HelloRepository
) : DashboardContract.Presenter() {

    override fun getTrendingData() {
    }

    override fun sayHello() = "${helloRepository.giveHello()} from $this"

}