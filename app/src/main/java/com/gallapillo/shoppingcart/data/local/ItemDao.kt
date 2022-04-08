package com.gallapillo.shoppingcart.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gallapillo.shoppingcart.data.local.entity.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems() : LiveData<List<Item>>
}