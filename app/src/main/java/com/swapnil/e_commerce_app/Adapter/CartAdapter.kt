package com.swapnil.e_commerce_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.e_commerce_app.Model.Cart
import com.swapnil.e_commerce_app.R
import com.swapnil.e_commerce_app.databinding.CartViewBinding

class CartAdapter(
    private val carts: ArrayList<Cart>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: CartViewBinding

        init {
            binding = CartViewBinding.bind(view)
        }
    }

    override fun getItemCount() = carts.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cart_view, null)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = carts[position]


        val cartItem = Cart.getCartItems();

        for (product in cartItem) {

            holder.binding.productImage.setImageResource(product.productImage)
            holder.binding.productPrice.text = "${product.price}"
            holder.binding.productName.text = "${product.name}"

        }
    }

}