package com.example.bookshelfapp.repository

import com.example.bookshelfapp.data.BookItem
import com.example.bookshelfapp.network.RetrofitInstance
import retrofit2.Response

class BookRepository {

    suspend fun searchBooks(query: String): Response<List<BookItem>> {
        val response = RetrofitInstance.api.searchBooks(query)
        if (response.isSuccessful) {
            val bookItems = response.body()?.items ?: emptyList()
            return Response.success(bookItems)
        }
        return Response.error(404, response.errorBody()!!)
    }

    suspend fun getBookDetails(volumeId: String): Response<BookItem> {
        return RetrofitInstance.api.getBookDetails(volumeId)
    }
}
