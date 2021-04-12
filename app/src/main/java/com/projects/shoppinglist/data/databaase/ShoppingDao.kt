package com.projects.shoppinglist.data.databaase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.projects.shoppinglist.data.databaase.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}