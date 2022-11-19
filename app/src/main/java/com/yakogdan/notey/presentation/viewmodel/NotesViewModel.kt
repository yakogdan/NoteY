package com.yakogdan.notey.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yakogdan.notey.domain.entities.NoteDomainEntity
import com.yakogdan.notey.domain.interactors.NoteInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteInteractor: NoteInteractor
) : ViewModel() {

    private val _viewStateLiveData = MutableLiveData<List<NoteDomainEntity>>()

    val viewStateLiveData: LiveData<List<NoteDomainEntity>> get() = _viewStateLiveData

    fun addNote(noteDomain: NoteDomainEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            noteInteractor.addNote(noteDomain)
        }
    }

    fun updateNote(noteDomain: NoteDomainEntity) {
        Log.d("myTag", "updateNote: ")
        viewModelScope.launch(Dispatchers.IO) {
            noteInteractor.updateNote(noteDomain)
        }
    }

    fun deleteNote(noteDomain: NoteDomainEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            noteInteractor.deleteNote(noteDomain)
        }
    }

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            noteInteractor.getAllNotes().collect {
                withContext(Dispatchers.Main) {
                    _viewStateLiveData.value = it
                }
            }
        }
    }
}


