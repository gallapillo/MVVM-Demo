package com.gallapillo.shoppingcart.model.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gallapillo.shoppingcart.model.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItem() : LiveData<List<Item>>
}