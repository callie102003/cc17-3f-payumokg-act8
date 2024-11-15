package com.example.bookshelfapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookshelfapp.data.BookItem
import com.example.bookshelfapp.databinding.ItemBookBinding

class BookAdapter : ListAdapter<BookItem, BookAdapter.BookViewHolder>(BookItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookItem = getItem(position)
        holder.bind(bookItem)
    }

    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookItem) {
            binding.title.text = book.volumeInfo.title
            Glide.with(binding.imageView.context)
                .load(book.volumeInfo.imageLinks?.smallThumbnail)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(binding.imageView)
        }
    }
}
