package co.talesbruno.pickimagefromgallery.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import co.talesbruno.pickimagefromgallery.domain.usecase.SelectImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectImageViewModel @Inject constructor(private val selectImageUseCase: SelectImageUseCase) : ViewModel() {
    private val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    fun selectImage() {
        viewModelScope.launch {
            val uri = selectImageUseCase()
            _selectedImageUri.value = uri
        }
    }
}