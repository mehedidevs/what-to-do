package com.mehedi.whattodo.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.mehedi.whattodo.R
import com.mehedi.whattodo.databinding.FragmentAddTaskBinding
import com.mehedi.whattodo.utils.showChar
import com.mehedi.whattodo.utils.showSnackbar


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

    private val viewModel by viewModels<AddTaskViewModel>()

    private val args: AddTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_task, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.getTaskById(args.taskId)?.let { taskObserver ->
            taskObserver.observe(viewLifecycleOwner) {
                it?.let { task ->
                    viewModel.title.postValue(task.title.toString())
                    viewModel.description.postValue(task.description.toString())
                }

            }

        }



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindSnackBar(view)
        bindUiMessage()

    }

    private fun bindUiMessage() {
        binding.warningTextTaskTitle.showChar(viewLifecycleOwner, viewModel.title)
    }

    private fun bindSnackBar(view: View) {

        view.showSnackbar(
            viewLifecycleOwner,
            viewModel.snackbarMsg,
            Snackbar.LENGTH_LONG
        )
    }


}