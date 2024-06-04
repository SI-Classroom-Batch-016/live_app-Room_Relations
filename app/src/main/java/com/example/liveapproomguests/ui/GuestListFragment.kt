package com.example.liveapproomguests.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.liveapproomguests.R
import com.example.liveapproomguests.data.model.Guest
import com.example.liveapproomguests.databinding.FragmentGuestListBinding
import com.example.liveapproomguests.ui.adapter.GuestAdapter

class GuestListFragment : Fragment() {

    private lateinit var binding: FragmentGuestListBinding

    private val viewModel : GuestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.guestList.observe(viewLifecycleOwner){
            Log.d("guestListObserver", it.toString())

            val adapter = GuestAdapter(it)
            binding.guestRV.adapter = adapter
        }

        binding.addFAB.setOnClickListener {

            val testGuest = Guest(0, "Test Guest", "0 und 1")
            viewModel.insertGuest(testGuest)
        }

    }


}