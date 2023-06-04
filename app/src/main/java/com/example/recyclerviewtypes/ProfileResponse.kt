package com.example.recyclerviewtypes

import androidx.annotation.DrawableRes
import com.example.recyclerviewtypes.ItemTypes.PROFILE_TYPE

data class ProfileResponse(
    override val name:String,
    @DrawableRes
    override val imageRes:Int,
    override var viewType: Int = PROFILE_TYPE,
    override val orderName: String = "",
):BaseItemType
