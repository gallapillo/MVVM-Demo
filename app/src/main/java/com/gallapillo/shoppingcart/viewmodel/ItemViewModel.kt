package com.gallapillo.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import com.gallapillo.shoppingcart.repository.ItemRepository
import com.gallapillo.shoppingcart.data.local.entity.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(
    private val repository: ItemRepository
): ViewModel() {

    fun upsert(item: Item) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: Item) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()

}