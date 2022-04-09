package com.gallapillo.shoppingcart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gallapillo.shoppingcart.R
import com.gallapillo.shoppingcart.data.local.ItemDatabase
import com.gallapillo.shoppingcart.data.local.entity.Item
import com.gallapillo.shoppingcart.repository.ItemRepository
import com.gallapillo.shoppingcart.view.adpaters.ItemAdapter
import com.gallapillo.shoppingcart.view.dialog.AddDialogListener
import com.gallapillo.shoppingcart.view.dialog.AddItemDialog
import com.gallapillo.shoppingcart.viewmodel.ItemViewModel
import com.gallapillo.shoppingcart.viewmodel.ItemViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ItemDatabase(this)
        val repository = ItemRepository(database)
        val factory = ItemViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ItemViewModel::class.java)

        val adapter = ItemAdapter(emptyList(), viewModel)

        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: Item) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}