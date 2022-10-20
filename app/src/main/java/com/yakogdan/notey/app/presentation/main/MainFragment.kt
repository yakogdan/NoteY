package com.yakogdan.notey.app.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.yakogdan.notey.R
import com.yakogdan.notey.app.adapters.NotesAdapter
import com.yakogdan.notey.databinding.FragmentMainBinding
//import kotlinx.android.synthetic.main.fragment_main.*

//import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    private val navController by lazy { view?.findNavController() }

//    private val viewModel by viewModels<MainViewModel>()
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
//        initAdapter()
//
//        notesAdapter.setOnItemClickListener {
//            val bundle = bundleOf("note" to it)
//            navController?.navigate(
//                R.id.action_mainFragment_to_noteFragment,
//                bundle
//            )
//        }
//
//        notesAdapter.setOnItemLongClickListener {
//            viewModel.deleteNote(it) { }
//        }
//
//        viewModel.viewStateLiveData.observe(viewLifecycleOwner) { notes ->
//                notesAdapter.differ.submitList(notes)
//        }
//
        mBinding.fab.setOnClickListener {
            navController?.navigate(
                R.id.action_mainFragment_to_noteFragment
            )
        }

    }

//    private fun initAdapter() {
//        notesAdapter = NotesAdapter()
//        rv_main.apply {
//            adapter = notesAdapter
//        }
//    }
}