package com.projects.shoppinglist.ui.shoppinglist

import com.projects.shoppinglist.data.databaase.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}