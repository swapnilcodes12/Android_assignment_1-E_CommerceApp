package com.swapnil.e_commerce_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.e_commerce_app.Model.Product
import com.swapnil.e_commerce_app.R
import com.swapnil.e_commerce_app.databinding.ProductsViewBinding

class ProductAdapter(
    private val products : ArrayList<Product>
)  :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    interface OnProductClickListener{
        fun onProductClick(position: Int)
    }
     var onProductClickListener : OnProductClickListener? = null

    inner class ProductViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding : ProductsViewBinding
        init {
            binding = ProductsViewBinding.bind(view)
            binding.root.setOnClickListener{
                onProductClickListener?.onProductClick(

                    adapterPosition,

                )
            }

        }
    }

    override fun getItemCount() = products.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.products_view,null)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.binding.reyclerViewProductName.text= product.name.toString()
        holder.binding.recylcerViewProductImage.setImageResource(product.productImage)
        holder.binding.recylcerViewProductPrice.text = product.price.toString()
    }
}