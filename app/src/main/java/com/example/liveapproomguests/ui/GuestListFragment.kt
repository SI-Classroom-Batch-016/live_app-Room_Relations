package com.example.liveapproomguests.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liveapproomguests.R
import com.example.liveapproomguests.databinding.FragmentGuestListBinding

class GuestListFragment : Fragment() {

    private lateinit var binding: FragmentGuestListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestListBinding.inflate(inflater, container, false)
        return binding.root
    }


}