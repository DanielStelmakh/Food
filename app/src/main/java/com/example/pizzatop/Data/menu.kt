package com.example.pizzatop.Data

import com.google.gson.annotations.SerializedName
class Menu():ArrayList<Info>()
data class Info(
    @SerializedName("id"       ) var id       : Int?,
    @SerializedName("category" ) var category : String?,
    @SerializedName("name"     ) var name     : String?,
    @SerializedName("topping"  ) var topping  : ArrayList<String>,
    @SerializedName("price"    ) var price    : Int? ,
    @SerializedName("rank"     ) var rank     : Int? ,
)
