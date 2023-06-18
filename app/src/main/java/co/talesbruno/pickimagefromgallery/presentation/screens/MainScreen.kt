package co.talesbruno.pickimagefromgallery.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.talesbruno.pickimagefromgallery.presentation.viewmodel.SelectImageViewModel
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(selectImageViewModel: SelectImageViewModel){
    val imageUri by selectImageViewModel.selectedImageUri.collectAsStateWithLifecycle()
    Scaffold() {
        Column() {
            AsyncImage(model = imageUri, contentDescription = null)
            Button(onClick = { selectImageViewModel.selectImage() }) {
                Text(text = "Select Image")
            }
        }
    }
}
