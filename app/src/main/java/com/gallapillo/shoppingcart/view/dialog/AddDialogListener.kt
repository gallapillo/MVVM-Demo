package com.gallapillo.shoppingcart.view.dialog

import com.gallapillo.shoppingcart.data.local.entity.Item

interface AddDialogListener {
    fun onAddButtonClicked(item: Item)
}