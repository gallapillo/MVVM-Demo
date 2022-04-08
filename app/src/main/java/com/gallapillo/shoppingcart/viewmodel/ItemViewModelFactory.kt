package com.gallapillo.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gallapillo.shoppingcart.repository.ItemRepository

@Suppress("UNCHECKED_CAST")
class ItemViewModelFactory(
    private val repository: ItemRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}