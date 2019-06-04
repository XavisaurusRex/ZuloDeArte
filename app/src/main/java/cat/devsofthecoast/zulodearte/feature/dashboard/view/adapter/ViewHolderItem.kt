package cat.devsofthecoast.zulodearte.feature.dashboard.view.adapter

interface ViewHolderItem<T> {
    fun bind(element: T)
    fun decorate(element: T)
}