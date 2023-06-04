package com.example.recyclerviewtypes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtypes.ItemTypes.ORDER_TYPE
import com.example.recyclerviewtypes.ItemTypes.PROFILE_TYPE
import com.example.recyclerviewtypes.databinding.ItemOrderBinding
import com.example.recyclerviewtypes.databinding.ItemProfileBinding

class MixAdapter() : ListAdapter<BaseItemType, RecyclerView.ViewHolder>(BaseDiffCallBack<BaseItemType>()) {

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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).onBind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
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
