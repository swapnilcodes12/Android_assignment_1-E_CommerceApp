package com.swapnil.e_commerce_app.View

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.swapnil.e_commerce_app.Adapter.ProductAdapter
import com.swapnil.e_commerce_app.Model.Product
import com.swapnil.e_commerce_app.R
import com.swapnil.e_commerce_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val products = ArrayList<Product>()
    private lateinit var productAdapter: ProductAdapter
    val cartImage = R.drawable.shopping_cart



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setIcon(cartImage)
        supportActionBar?.title = "Products"
        dataSource()
        initViews()

    }


    private fun initViews() {

        productAdapter = ProductAdapter(products)
        productAdapter.onProductClickListener = MyOnProductClickListener()
        binding.recyclerProducts.adapter = productAdapter
        binding.recyclerProducts.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)


    }

    inner class MyOnProductClickListener : ProductAdapter.OnProductClickListener {

        override fun onProductClick(position: Int) {
            val intent = Intent(
                this@MainActivity,
                ProductDetailsActivity::class.java
            )
            intent.putExtra("productInfo", products[position])
            startActivity(intent)
        }

    }


    private fun dataSource() {
        products.add(
            Product(
                1,
                "Laptop1",
                30000.0,
                "This is the laptop of hp",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                2,
                "Laptop2",
                30320.0,
                "This is the laptop of dell",
                "Ram : 4gb, Storage : 256ssd, os : windows",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                3,
                "Laptop3",
                40000.0,
                "This is the laptop of asus",
                "Ram : 8gb, Storage : 256ssd, os : Ios",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                4,
                "Laptop4",
                50000.0,
                "This is the laptop of lenevo",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                5,
                "Laptop5",
                60000.0,
                "This is the laptop of infinix",
                "Ram : 4gb, Storage : 256ssd, os : windows",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                6,
                "Laptop6",
                70000.0,
                "This is the laptop of hp1",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                7,
                "Laptop7",
                80000.0,
                "This is the laptop of dell",
                "Ram : 4gb, Storage : 256ssd, os : Ios",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                8,
                "Laptop8",
                90000.0,
                "This is the laptop of asus",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                9,
                "Laptop9",
                54000.0,
                "This is the laptop of hp",
                "Ram : 4gb, Storage : 256ssd, os : Ios",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                10,
                "Laptop10",
                36400.0,
                "This is the laptop of lenevo",
                "Ram : 4gb, Storage : 256ssd, os : ubantu",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                11,
                "Laptop11",
                34700.0,
                "This is the laptop of Infinix",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                12,
                "Laptop12",
                30065.0,
                "This is the laptop of dell",
                "Ram : 4gb, Storage : 256ssd, os : windows",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                13,
                "Laptop13",
                30002.0,
                "This is the laptop of asus",
                "Ram : 4gb, Storage : 256ssd, os : linux",
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                14,
                "Laptop14",
                30004.0,
                "This is the laptop of xiaomi",
                "Ram : 4gb, Storage : 256ssd, os : Ios",
                R.drawable.laptop
            )
        )
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)

        val cartItem = menu.findItem(R.id.add_to_cart)
        val cartImageView = ImageView(this)
        cartImageView.setImageResource(R.drawable.shopping_cart)
        cartImageView.setOnClickListener {
            val intent = Intent(this@MainActivity,AddToCartActivity::class.java)
            startActivity(intent)
        }
        cartItem.actionView = cartImageView

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.Settings -> {
                Toast.makeText(this,"Settings Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.about -> {
                Toast.makeText(this,"About Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.Share -> {
                Toast.makeText(this,"Share Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
}}