package com.example.recyclerviewtypes

import com.example.recyclerviewtypes.ItemTypes.ORDER_TYPE

data class OrderResponse(
    override var orderName:String,
    override var viewType: Int = ORDER_TYPE,
    override val name: String = "",
    override val imageRes: Int = 0,
):BaseItemType
