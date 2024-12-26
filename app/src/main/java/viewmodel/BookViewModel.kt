package com.example.lastof2024.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastof2024.data.Book

class BookViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    private val _selectedBook = MutableLiveData<Book?>()
    val selectedBook: LiveData<Book?> get() = _selectedBook

    init {
        _books.value = listOf(
            Book(1, "Book One", "Author One", "Description One"),
            Book(2, "Book Two", "Author Two", "Description Two"),
            Book(3, "Book Three", "Author Three", "Description Three")
        )
    }

    fun selectBook(book: Book) {
        _selectedBook.value = book
    }

    fun updateBook(updatedBook: Book) {
        _books.value = _books.value?.map { if (it.id == updatedBook.id) updatedBook else it }
    }
}

