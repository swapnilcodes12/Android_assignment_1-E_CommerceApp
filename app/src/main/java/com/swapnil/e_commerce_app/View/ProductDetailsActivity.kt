package com.swapnil.e_commerce_app.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.swapnil.e_commerce_app.Adapter.CartAdapter
import com.swapnil.e_commerce_app.Model.Cart
import com.swapnil.e_commerce_app.Model.Product
import com.swapnil.e_commerce_app.databinding.ProductDetailsViewBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ProductDetailsViewBinding
    private lateinit var product: Product


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Product_Details"


        product = (intent.getSerializableExtra("productInfo") as? Product)!!

        if (product != null) {
            binding.productImage.setImageResource(product.productImage)
            binding.txtProductName.text = product.name
            binding.txtProductId.text = "Product ID: ${product.productId}"
            binding.txtProductDescription.text = product.description
            binding.txtProductDetails.text = product.productDetails
            binding.productPrice.text = "Price - ${product.price}"
        }

        binding.buttonAddToCart.setOnClickListener {
            Cart.addItem(product)



            Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show()

        }
    }
}