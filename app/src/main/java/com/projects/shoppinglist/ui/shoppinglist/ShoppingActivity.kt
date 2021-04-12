package com.projects.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.shoppinglist.R
import com.projects.shoppinglist.data.databaase.ShoppingDatabase
import com.projects.shoppinglist.data.databaase.entities.ShoppingItem
import com.projects.shoppinglist.data.repositories.ShoppingRepository
import com.projects.shoppinglist.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class ShoppingActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
        var adapter = ShoppingItemAdapter(listOf(), viewModel)

        rv_shopping_items.layoutManager = LinearLayoutManager(this)
        rv_shopping_items.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
            object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}