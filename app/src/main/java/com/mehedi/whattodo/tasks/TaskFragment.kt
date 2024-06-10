package com.mehedi.whattodo.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.whattodo.R
import com.mehedi.whattodo.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private val viewModel by viewModels<TaskViewmodel>()

    private lateinit var adapter: TaskAdapter

    private val isEditClicked = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task, container, false)

        binding.taskViewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setTaskAdapter()
        setUpNavigation()

        return binding.root
    }

    private fun setUpNavigation() {
        binding.btnAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_tasks_fragment_dest_to_addTaskFragment)
        }
    }

    private fun setTaskAdapter() {
        val viewmodel = binding.taskViewmodel
        if (viewmodel != null) {
            adapter = TaskAdapter(viewmodel) { task ->
                val action =
                    TaskFragmentDirections.actionTasksFragmentDestToAddTaskFragment(task.id)
                findNavController().navigate(action)

            }
            binding.taskList.adapter = adapter
        }


    }


}