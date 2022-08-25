package com.example.searchview

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.searchview.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _bind : FragmentMainBinding? = null
    private val bind: FragmentMainBinding
        get() = _bind ?: throw RuntimeException("FragmentMainBinding == null")

    private lateinit var adapterSearch : SearchAdapter

    private var listPrep : MutableList<Preparation> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _bind = FragmentMainBinding.inflate(layoutInflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addList()
        adapterSearch = SearchAdapter(listPrep)
        with(bind){
            val recycler = rvSearch
            with(recycler){
                adapter = adapterSearch
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val itemMenu = menu.findItem(R.id.action_search)
        val searchView = itemMenu?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterSearch.filter.filter(newText)
                return false
            }
        })
    }


    private fun addList() {
        listPrep.add(Preparation("Dennn"))
        listPrep.add(Preparation("fdsfsdf"))
        listPrep.add(Preparation("Dedfdfvcnnn"))
        listPrep.add(Preparation("Dendfdsfnn"))
        listPrep.add(Preparation("sdf3fdfs"))
        listPrep.add(Preparation("33fdsfdsf"))
        listPrep.add(Preparation("fdsf33"))
        listPrep.add(Preparation("fsfhhjh"))
        listPrep.add(Preparation("rtrte"))
        listPrep.add(Preparation("vcbcraa"))
    }

    companion object {

    }
}