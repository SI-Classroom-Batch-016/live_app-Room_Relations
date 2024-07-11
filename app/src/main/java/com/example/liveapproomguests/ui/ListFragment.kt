package com.example.liveapproomguests.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.liveapproomguests.databinding.FragmentGuestListBinding
import com.example.liveapproomguests.ui.adapter.ItemAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentGuestListBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.leserMitBuchListen.observe(viewLifecycleOwner){
            Log.d("RoomListeLeser", it.toString())

            binding.itemRV.adapter = ItemAdapter(it)
        }

    }


}