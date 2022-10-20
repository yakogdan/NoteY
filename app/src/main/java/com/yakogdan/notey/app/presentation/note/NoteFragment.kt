package com.yakogdan.notey.app.presentation.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.yakogdan.notey.data.repository.NoteyRepositoryImpl
import com.yakogdan.notey.databinding.FragmentNoteBinding
import com.yakogdan.notey.domain.models.NoteDomain
import com.yakogdan.notey.domain.usecase.GetDataUseCase
import com.yakogdan.notey.domain.usecase.SaveDataUseCase

//import kotlinx.android.synthetic.main.fragment_note.*

class NoteFragment : Fragment() {

    private val noteyRepositoryImpl by lazy { NoteyRepositoryImpl(context = requireActivity().applicationContext) }
    private val getDataUseCase by lazy { GetDataUseCase(noteyRepositoryImpl) }
    private val saveDataUseCase by lazy { SaveDataUseCase(noteyRepositoryImpl) }

    private var _binding: FragmentNoteBinding? = null
    private val mBinding get() = _binding!!
    private val navController by lazy { view?.findNavController() }

//    private val bundleArgs: com.yakogdan.notey.app.note.NoteFragmentArgs by navArgs()

//    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val noteArg = bundleArgs.note
//        noteArg?.let { note ->
//            et_title.setText(note.title)
//            et_subtitle.setText(note.subtitle)
//        }
//
        mBinding.ivBack.setOnClickListener {
            navController?.popBackStack()

        }

        mBinding.buttonGet.setOnClickListener {

            val note = getDataUseCase.execute()
            mBinding.etSubtitle.setText(note.title)
        }

        mBinding.fab.setOnClickListener {


            val data = NoteDomain(title = mBinding.etTitle.text.toString())
            val result: Boolean = saveDataUseCase.execute(data)
            mBinding.etSubtitle.setText("Save result = $result")
//            if (noteArg == null) {
//                viewModel.addNote(
//                    dbNoteEntity = DbNoteEntity(
//                        title = et_title.text.toString(),
//                        subtitle = et_subtitle.text.toString()
//                    )
//                ) { navController?.popBackStack() }
//            } else {
//                viewModel.updateNote(
//                    dbNoteEntity = DbNoteEntity(
//                        id = noteArg.id,
//                        title = et_title.text.toString(),
//                        subtitle = et_subtitle.text.toString()
//                    )
//                ) { navController?.popBackStack() }
//            }
        }

//        mBinding.etTitle.addTextChangedListener(object : TextWatcher
//        {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                mBinding.fab.isVisible = true
//            }
//            override fun afterTextChanged(p0: Editable?) { }
//        })
//
//        mBinding.etSubtitle.addTextChangedListener(object : TextWatcher
//        {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                mBinding.fab.isVisible = true
//            }
//            override fun afterTextChanged(p0: Editable?) { }
//        })


    }
}