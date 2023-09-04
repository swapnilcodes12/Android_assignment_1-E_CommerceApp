package com.swapnil.e_commerce_app.Model

object Cart {
    val cartItems = ArrayList<Product>()


    fun addItem(product: Product) {
        cartItems.add(product)
    }

    fun removeItem(product: Product) {
        cartItems.remove(product)
    }

    fun getCartItems(filter: String? = null): ArrayList<Product> {

        if (filter != null) {

        }
        return cartItems
    }
}
