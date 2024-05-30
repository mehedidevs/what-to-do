package com.mehedi.whattodo.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehedi.whattodo.R
import com.mehedi.whattodo.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {
    
    private lateinit var binding: FragmentAddTaskBinding
    
    private val viewModel by viewModels<AddTaskViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_task, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        
        return binding.root
    }
    
    
}