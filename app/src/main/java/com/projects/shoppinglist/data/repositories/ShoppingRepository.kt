package com.projects.shoppinglist.data.repositories

import com.projects.shoppinglist.data.databaase.ShoppingDatabase
import com.projects.shoppinglist.data.databaase.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
 }