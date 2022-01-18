package com.example.machinetest.adapters

import androidx.paging.PagedListAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.machinetest.R
import com.example.machinetest.databinding.UserRowBinding
import com.example.machinetest.models.User
import androidx.annotation.IdRes

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


class UsersAdapter(private val context: Context) : PagedListAdapter<User, UsersAdapter.MyViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: UserRowBinding = DataBindingUtil.inflate(inflater, R.layout.user_row,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.user = getItem(position)
        Glide
            .with(context)
            .load(holder.itemBinding.user?.avatar)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemBinding.ivUser)
    }

    class MyViewHolder(val itemBinding: UserRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : UserRowBinding? = null

        init {
            this.binding = itemBinding
        }

    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                newItem == oldItem
        }
    }

}