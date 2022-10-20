package com.yakogdan.notey.app.presentation.main
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.yakogdan.notey.domain.interactors.NoteInteractor
//import com.yakogdan.notey.domain.models.NoteDomain
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class MainViewModel : ViewModel() {
//
//    private val _viewStateLiveData = MutableLiveData<List<NoteDomain>>()
//
//    val viewStateLiveData: LiveData<List<NoteDomain>> get() = _viewStateLiveData
//
//    private val noteInteractor: NoteInteractor = NoteInteractor()
//
//    fun addNote(noteDomain: NoteDomain) {
//        viewModelScope.launch(Dispatchers.IO) {
//            noteInteractor.addNote(noteDomain)
//        }
//    }
//
//    fun updateNote(noteDomain: NoteDomain) {
//        viewModelScope.launch(Dispatchers.IO) {
//            noteInteractor.updateNote(noteDomain)
//        }
//    }
//
//    fun deleteNote(noteDomain: NoteDomain) {
//        viewModelScope.launch(Dispatchers.IO) {
//            noteInteractor.deleteNote(noteDomain)
//        }
//    }
//
//    fun getAllNotes() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val notes = noteInteractor.getAllNotes()
//            withContext(Dispatchers.Main) {
//                _viewStateLiveData.value = notes
//            }
//        }
//    }
//
//}
//
//
