package com.gallapillo.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.gallapillo.shoppingcart.data.local.ItemDatabase
import com.gallapillo.shoppingcart.repository.ItemRepository
import com.gallapillo.shoppingcart.viewmodel.ItemViewModel
import com.gallapillo.shoppingcart.viewmodel.ItemViewModelFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ItemDatabase(this)
        val repository = ItemRepository(database)
        val factory = ItemViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ItemViewModel::class.java)

    }
}