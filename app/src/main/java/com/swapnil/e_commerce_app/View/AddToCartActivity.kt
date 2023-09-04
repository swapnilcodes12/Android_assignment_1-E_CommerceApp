package com.swapnil.e_commerce_app.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.swapnil.e_commerce_app.Adapter.CartAdapter
import com.swapnil.e_commerce_app.Model.Cart
import com.swapnil.e_commerce_app.databinding.AddToCartBinding

class AddToCartActivity : AppCompatActivity() {

   private lateinit var binding: AddToCartBinding
   private lateinit var cartAdapter : CartAdapter
   private  var carts = ArrayList<Cart>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddToCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Cart"

        cartAdapter = CartAdapter(carts)
        binding.recyclerCartProducts.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerCartProducts.adapter = cartAdapter



    }}
