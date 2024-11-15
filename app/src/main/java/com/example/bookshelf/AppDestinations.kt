package com.example.bookshelf

enum class AppDestinations(val title: String) {
    MenuScreen(title = "Welcome"),
    QueryScreen(title = "Bookshelf"),
    FavoriteScreen(title = "My Favorite"),
    DetailScreen(title = "Book: ")
}