package com.gallapillo.shoppingcart.view.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.gallapillo.shoppingcart.R
import com.gallapillo.shoppingcart.data.local.entity.Item
import kotlinx.android.synthetic.main.add_item_dialog.*

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter name and amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Item(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}