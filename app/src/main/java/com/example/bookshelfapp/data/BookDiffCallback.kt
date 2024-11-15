package com.example.bookshelfapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.bookshelfapp.data.BookItem

class BookItemDiffCallback : DiffUtil.ItemCallback<BookItem>() {
    override fun areItemsTheSame(oldItem: BookItem, newItem: BookItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BookItem, newItem: BookItem): Boolean {
        return oldItem == newItem
    }
}
