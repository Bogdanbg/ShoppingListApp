package com.projects.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.projects.shoppinglist.R
import com.projects.shoppinglist.data.databaase.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_add_item)

        tv_add.setOnClickListener {
            val name = et_name.text.toString()
            val amount = et_amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Fill all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener{
            cancel()
        }
    }

}