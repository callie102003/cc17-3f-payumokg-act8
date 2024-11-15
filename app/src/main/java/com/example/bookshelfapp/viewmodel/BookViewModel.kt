package com.example.bookshelfapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookshelfapp.data.BookItem
import com.example.bookshelfapp.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel : ViewModel() {

    private val bookRepository = BookRepository()
    private val _booksLiveData = MutableLiveData<List<BookItem>>()
    val booksLiveData: LiveData<List<BookItem>> get() = _booksLiveData

    fun fetchBooks(query: String) {
        launch {
            val books = bookRepository.searchBooks(query)
            if (books.isSuccessful) {
                val bookItems = books.body() ?: emptyList()
                _booksLiveData.value = bookItems
            }
        }
    }
}
