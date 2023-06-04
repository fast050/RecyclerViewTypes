package com.example.recyclerviewtypes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtypes.ItemTypes.ORDER_TYPE
import com.example.recyclerviewtypes.ItemTypes.PROFILE_TYPE
import com.example.recyclerviewtypes.databinding.ItemOrderBinding
import com.example.recyclerviewtypes.databinding.ItemProfileBinding

class MixAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var itemList : List<BaseItemType> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return when (viewType) {

            PROFILE_TYPE -> {
                val binding =
                    ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ProfileViewHolder(binding)
            }

            ORDER_TYPE -> {
                val binding =
                    ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    OrderViewHolder(binding)
            }

            else -> {
                throw java.lang.IllegalStateException("This Type is not supported")
            }
        }
    }

    fun submitItems(items:List<BaseItemType>){
        itemList = items
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("MixAdapter", "onBindViewHolder: ${position % itemList.size}")
        (holder as BaseViewHolder).onBind(itemList[position % itemList.size])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position % itemList.size].viewType
    }


    override fun getItemCount(): Int {
        return itemList.size * 2
    }

    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root), BaseViewHolder {
        override fun onBind(item: BaseItemType) {
           binding.apply {
               title.text = item.orderName
           }
        }
    }

    inner class ProfileViewHolder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root), BaseViewHolder {
        override fun onBind(item: BaseItemType) {
            binding.apply {
                title.text = item.name
                image.setImageResource(item.imageRes)
            }
        }
    }
}
