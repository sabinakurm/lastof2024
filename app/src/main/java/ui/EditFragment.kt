package com.example.lastof2024.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lastof2024.R
import com.example.lastof2024.viewmodel.BookViewModel

class EditFragment : Fragment() {
    private val viewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTitle = view.findViewById<EditText>(R.id.editTitle)
        val editAuthor = view.findViewById<EditText>(R.id.editAuthor)
        val editDescription = view.findViewById<EditText>(R.id.editDescription)
        val saveButton = view.findViewById<Button>(R.id.saveButton)

        viewModel.selectedBook.observe(viewLifecycleOwner) { book ->
            book?.let {
                editTitle.setText(it.title)
                editAuthor.setText(it.author)
                editDescription.setText(it.description)
            }
        }

        saveButton.setOnClickListener {
            val updatedBook = viewModel.selectedBook.value?.apply {
                title = editTitle.text.toString()
                author = editAuthor.text.toString()
                description = editDescription.text.toString()
            }
            updatedBook?.let { viewModel.updateBook(it) }
            findNavController().popBackStack()
        }
    }
}
