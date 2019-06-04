package cat.devsofthecoast.zulodearte.base.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<T>() where T : RecyclerView.ViewHolder