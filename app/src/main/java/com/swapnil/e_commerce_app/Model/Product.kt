package com.swapnil.e_commerce_app.Model

import java.io.Serializable

data class Product(
    val productId : Int,
    val name : String,
    val price : Double,
    val description: String,
    val productDetails : String,
    val productImage : Int

) : Serializable
