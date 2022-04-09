package com.gallapillo.shoppingcart.view.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gallapillo.shoppingcart.R
import com.gallapillo.shoppingcart.data.local.entity.Item
import com.gallapillo.shoppingcart.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.item.view.*

class ItemAdapter(
    var items: List<Item>,
    private val viewModel: ItemViewModel
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        holder.itemView.tvName.text = currentItem.name
        holder.itemView.tvAmount.text = currentItem.amount.toString()

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }
        holder.itemView.ivPlus.setOnClickListener {
            currentItem.amount++
            viewModel.upsert(currentItem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            currentItem.amount++
            viewModel.delete(currentItem)
        }
    }

    override fun getItemCount(): Int = items.size
}