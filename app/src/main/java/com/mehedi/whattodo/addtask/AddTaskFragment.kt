package com.mehedi.whattodo.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mehedi.whattodo.R
import com.mehedi.whattodo.databinding.FragmentAddTaskBinding
import com.mehedi.whattodo.utils.showChar
import com.mehedi.whattodo.utils.showSnackbar


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
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        bindSnackBar(view)
        bindUiMessage()
        
    }
    
    private fun bindUiMessage() {
        binding.warningTextTaskTitle.showChar(lifecycleOwner = viewLifecycleOwner, viewModel.title)
        
    }
    
    private fun bindSnackBar(view: View) {
        
        
        view.showSnackbar(
            lifecycleOwner = viewLifecycleOwner,
            viewModel.snackbarMsg,
            Snackbar.LENGTH_LONG
        )
    }
    
    
}