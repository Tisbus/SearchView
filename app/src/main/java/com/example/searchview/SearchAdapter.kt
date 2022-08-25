package com.example.searchview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.searchview.databinding.ItemPrepBinding

class SearchAdapter(private val prepList: MutableList<Preparation>) :
    RecyclerView.Adapter<SearchViewHolder>(), Filterable {

    var displayList : MutableList<Preparation> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = DataBindingUtil.inflate<ItemPrepBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_prep,
            parent,
            false
        )
        return SearchViewHolder(view)
    }
    init {
        displayList.addAll(prepList)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val bind = holder.bind
        val itemPrep = displayList[position]
        bind.prep = itemPrep
    }

    override fun getItemCount(): Int {
        return displayList.size
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val listFilter : MutableList<Preparation> = mutableListOf()
                if(p0==null||p0.isEmpty())
                {
                    listFilter.addAll(prepList)
                }else
                {
                    val filterPattern: String = p0.toString().lowercase().trim()
                    for (item in prepList) {
                        if (item.name.lowercase().contains(filterPattern)) {
                            listFilter.add(item)
                        }
                    }
                }
                val results = Filter.FilterResults()
                results.values = listFilter
                return  results
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                displayList.clear()
                displayList.addAll(p1?.values as MutableList<Preparation>)
                notifyDataSetChanged()
            }
        }
    }
}