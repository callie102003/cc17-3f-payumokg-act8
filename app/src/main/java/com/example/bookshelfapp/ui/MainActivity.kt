package com.example.bookshelfapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.lifecycle.ViewModelProvider
import com.example.bookshelfapp.R
import com.example.bookshelfapp.data.BookItem
import com.example.bookshelfapp.viewmodel.BookViewModel
import com.example.bookshelfapp.databinding.ActivityMainBinding
import com.example.bookshelfapp.ui.adapter.BookAdapter
import com.example.bookshelfapp.viewmodel.BookViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up ViewModel
        bookViewModel = ViewModelProvider(this, BookViewModelFactory()).get(BookViewModel::class.java)

        // Set up RecyclerView and Adapter
        bookAdapter = BookAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = bookAdapter

        // Observe live data for books
        bookViewModel.booksLiveData.observe(this, { books ->
            bookAdapter.submitList(books)
        })

        // Search for books when activity starts
        bookViewModel.fetchBooks("android")
    }
}
