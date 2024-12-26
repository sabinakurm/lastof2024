package com.example.lastof2024.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lastof2024.R
import com.example.lastof2024.viewmodel.BookViewModel

class DetailsFragment : Fragment() {
    private val viewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val authorTextView = view.findViewById<TextView>(R.id.authorTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val editButton = view.findViewById<Button>(R.id.editButton)

        viewModel.selectedBook.observe(viewLifecycleOwner) { book ->
            book?.let {
                titleTextView.text = it.title
                authorTextView.text = it.author
                descriptionTextView.text = it.description
            }
        }

        editButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_editFragment)
        }
    }
}
