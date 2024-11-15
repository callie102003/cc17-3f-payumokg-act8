package com.example.bookshelfapp.network

import com.example.bookshelfapp.data.BookSearchResponse
import com.example.bookshelfapp.data.BookItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface ApiService {

    // Search for books based on query
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<BookSearchResponse>

    // Get details for a specific book
    @GET("volumes/{id}")
    suspend fun getBookDetails(
        @Path("id") volumeId: String
    ): Response<BookItem>
}
