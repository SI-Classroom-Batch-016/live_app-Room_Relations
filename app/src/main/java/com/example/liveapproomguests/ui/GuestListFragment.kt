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
import com.example.liveapproomguests.R
import com.example.liveapproomguests.data.model.Guest
import com.example.liveapproomguests.databinding.FragmentGuestListBinding
import com.example.liveapproomguests.ui.adapter.GuestAdapter

class GuestListFragment : Fragment() {

    private lateinit var binding: FragmentGuestListBinding

    private val viewModel: GuestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var adapter: GuestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = GuestAdapter() { clickedGuest ->
            findNavController().navigate(
                GuestListFragmentDirections.actionGuestListFragmentToEditFragment(
                    guestId = clickedGuest.id
                )
            )
        }
        binding.guestRV.adapter = adapter

        viewModel.guestList.observe(viewLifecycleOwner) {
            Log.d("guestListObserver", it.toString())

            //submitList funktion gibt neue Daten in den ListAdapter und aktualisiert das UI effizient
            adapter.submitList(it)

        }

        binding.sortFAB.setOnClickListener {
             adapter.sortItems()
        }

        binding.addFAB.setOnClickListener {

            findNavController().navigate(GuestListFragmentDirections.actionGuestListFragmentToAddFragment())

        }

    }


}