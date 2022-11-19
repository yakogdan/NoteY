package com.yakogdan.notey.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.yakogdan.notey.R
import com.yakogdan.notey.databinding.FragmentMainBinding
import com.yakogdan.notey.presentation.adapters.NotesAdapter
import com.yakogdan.notey.presentation.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    private val navController by lazy { view?.findNavController() }

    private val viewModel by viewModels<NotesViewModel>()
    lateinit var notesAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        viewModel.viewStateLiveData.observe(viewLifecycleOwner) { notes ->
            notesAdapter.setData(notes)
        }

        mBinding.fab.setOnClickListener {
            navController?.navigate(
                R.id.action_mainFragment_to_noteFragment
            )
        }
        viewModel.getAllNotes()
    }

    private fun initAdapter() {
        notesAdapter = NotesAdapter(
            onItemClickListener = {
                navController?.navigate(
                    R.id.action_mainFragment_to_noteFragment,
                    bundleOf("note" to it)
                )
            },
            onItemLongClickListener = {
                viewModel.deleteNote(it)
            }
        )
        mBinding.rvMain.apply {
            adapter = notesAdapter
        }
    }
}