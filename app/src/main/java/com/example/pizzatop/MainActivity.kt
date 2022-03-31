package com.example.pizzatop

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzatop.ViewModels.BaseViewModel
import com.example.pizzatop.adapters.ImageBannerAdapter
import com.example.pizzatop.adapters.MenuAdapter
import com.example.pizzatop.databinding.ActivityMainBinding
import com.example.pizzatop.repositoryimages.DataMenu



class MainActivity : AppCompatActivity() {

    lateinit var baseViewModel: BaseViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var recyclerView1: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var layoutManager1: LinearLayoutManager
    lateinit var imageBannerAdapter: ImageBannerAdapter
    lateinit var menuAdapter: MenuAdapter
    lateinit var toolbar: Toolbar
    lateinit var binding: ActivityMainBinding
    lateinit var menuImage:ArrayList<String>

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        settings()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.qr_code, menu);
        return true;
    }

    override fun onStart() {
        super.onStart()
        baseViewModel.liveData.observe(this, Observer {
            imageBannerAdapter= ImageBannerAdapter(it)
            recyclerView.adapter=imageBannerAdapter

        })
        baseViewModel.liveData1.observe(this, Observer {
            menuAdapter = MenuAdapter(it,menuImage)
            recyclerView1.adapter = menuAdapter
        })
    }

    private fun init(){
        BaseViewModel().also { baseViewModel = it }
        recyclerView=binding.bannerView
        layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager=layoutManager
        recyclerView1 = binding.menuList
        layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        toolbar=binding.toolbar
        menuImage=DataMenu().returnList()

    }

    private fun settings(){
        baseViewModel=ViewModelProvider(this).get(BaseViewModel::class.java)
        recyclerView.layoutManager=layoutManager
        recyclerView1.layoutManager=layoutManager1
        setSupportActionBar(toolbar)
        val cities=resources.getStringArray(R.array.city)
        val array_adapter=ArrayAdapter(this,R.layout.item_city,cities)
        binding.autoText.setAdapter(array_adapter)
    }
}