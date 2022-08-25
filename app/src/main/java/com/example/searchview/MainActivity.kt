package com.example.searchview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.searchview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _bind : ActivityMainBinding? = null
    private val bind: ActivityMainBinding
    get() = _bind ?: throw RuntimeException("ActivityMainBinding == null")

/*

    private lateinit var adapterSearch : SearchAdapter

    private var listPrep : MutableList<Preparation> = mutableListOf()
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
/*        addList()
        adapterSearch = SearchAdapter(listPrep)
        with(bind){
            val recycler = rvSearch
            with(recycler){
                adapter = adapterSearch
            }
        }*/
    }
/*
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val itemMenu = menu?.findItem(R.id.action_search)
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

        return true
    }*/

}