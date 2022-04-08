package com.gallapillo.shoppingcart.repository

import com.gallapillo.shoppingcart.data.local.entity.Item
import com.gallapillo.shoppingcart.data.local.ItemDatabase

class ItemRepository(
    private val db: ItemDatabase
) {
    suspend fun upsert(item: Item) = db.getItemDao().upsert(item)

    suspend fun delete(item: Item) = db.getItemDao().delete(item)

    fun getAllItems() = db.getItemDao().getAllItems()
}