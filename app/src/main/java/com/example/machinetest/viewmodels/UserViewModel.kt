package com.example.machinetest.viewmodels
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.machinetest.datasources.UserDataSource
import com.example.machinetest.datasourcesfactories.UserDataSourceFactory
import com.example.machinetest.models.User

class UserViewModel(private val context: Context) : ViewModel() {

    private var listUsers : LiveData<PagedList<User>> = MutableLiveData<PagedList<User>>()
    private var mutableLiveData = MutableLiveData<UserDataSource>()

    init {
        val factory : UserDataSourceFactory by lazy {
            UserDataSourceFactory(context)
        }
        mutableLiveData = factory.mutableLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(6)
            .build()

        listUsers = LivePagedListBuilder(factory, config)
            .build()

    }

    fun getData() : LiveData<PagedList<User>>{
        return listUsers
    }


}