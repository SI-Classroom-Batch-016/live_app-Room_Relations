package com.example.liveapproomguests.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.liveapproomguests.R
import com.example.liveapproomguests.data.model.Guest
import com.example.liveapproomguests.databinding.FragmentAddBinding
import com.example.liveapproomguests.databinding.FragmentGuestListBinding


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private val viewModel : GuestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editConfirmBTN.setOnClickListener {

            val name = binding.editNameET.text.toString()
            val food = binding.editFoodET.text.toString()
            val newGuest = Guest(0, name, food)

            viewModel.insertGuest(newGuest)

            findNavController().navigateUp()
        }

        binding.editCancelBTN.setOnClickListener {
            findNavController().navigateUp()
        }

    }


}