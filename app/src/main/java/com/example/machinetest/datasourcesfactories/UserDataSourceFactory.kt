package com.example.machinetest.datasourcesfactories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.machinetest.datasources.UserDataSource
import com.example.machinetest.models.User
import androidx.paging.DataSource
class UserDataSourceFactory(private val context: Context) : DataSource.Factory<Int, User>() {

    val mutableLiveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, User> {
        val userDataSource = UserDataSource(context)
        mutableLiveData.postValue(userDataSource)
        return userDataSource
    }

}