package com.yakogdan.notey.presentation.note

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.yakogdan.notey.databinding.FragmentNoteBinding
import com.yakogdan.notey.domain.entities.NoteDomainEntity
import com.yakogdan.notey.presentation.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val mBinding get() = _binding!!
    private val navController by lazy { view?.findNavController() }

    private val bundleArgs: NoteFragmentArgs by navArgs()

    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteArg = bundleArgs.note
        noteArg?.let { note ->
            mBinding.etTitle.setText(note.title)
            mBinding.etSubtitle.setText(note.subtitle)
        }

        mBinding.ivBack.setOnClickListener {
            navController?.popBackStack()

        }
        mBinding.etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mBinding.fab.isVisible = true
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        mBinding.etSubtitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mBinding.fab.isVisible = true
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        mBinding.fab.setOnClickListener {
            if (noteArg == null) {
                viewModel.addNote(
                    noteDomain = NoteDomainEntity(
                        title = mBinding.etTitle.text.toString(),
                        subtitle = mBinding.etSubtitle.text.toString(),
                        date = Date().toString()
                    )
                )
                navController?.popBackStack()
            } else {
                viewModel.updateNote(
                    noteDomain = NoteDomainEntity(
                        id = noteArg.id,
                        title = mBinding.etTitle.text.toString(),
                        subtitle = mBinding.etSubtitle.text.toString(),
                        date = Date().toString()
                    )
                )
                navController?.popBackStack()
            }
        }
    }
}