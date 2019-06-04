package cat.devsofthecoast.zulodearte.repository

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "Hello Koin"
}