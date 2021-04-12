package com.projects.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.projects.shoppinglist.data.databaase.entities.ShoppingItem
import com.projects.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item: ShoppingItem) =
        CoroutineScope(Dispatchers.Main)
            .launch { repository.upsert(item) }

    fun delete(item: ShoppingItem) =
        CoroutineScope(Dispatchers.Main)
        .launch { repository.delete(item) }


    fun getAllShoppingItems() = repository.getAllShoppingItems()

}