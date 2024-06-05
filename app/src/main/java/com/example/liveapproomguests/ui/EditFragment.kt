package com.example.liveapproomguests.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.liveapproomguests.R
import com.example.liveapproomguests.databinding.FragmentAddBinding
import com.example.liveapproomguests.databinding.FragmentEditBinding


class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel: GuestViewModel by activityViewModels()
    private val args: EditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getGuestById(args.guestId).observe(viewLifecycleOwner) { guest ->
            Log.d("EditFragment", guest.toString())

            binding.editNameET.setText(guest.name)
            binding.editFoodET.setText(guest.food)

            binding.editCancelBTN.setOnClickListener {
                //Guest löschen
                viewModel.deleteGuest(guest)

                findNavController().navigateUp()
            }

            binding.editConfirmBTN.setOnClickListener {
                //Daten Updaten

                val updatedGuest = guest.copy(
                    name = binding.editNameET.text.toString(),
                    food = binding.editFoodET.text.toString()
                )
                viewModel.updateGuest(updatedGuest)

                findNavController().navigateUp()
            }

        }
    }


}