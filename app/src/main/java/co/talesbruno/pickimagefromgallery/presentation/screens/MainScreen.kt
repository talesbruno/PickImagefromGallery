package co.talesbruno.pickimagefromgallery.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import co.talesbruno.pickimagefromgallery.presentation.viewmodel.SelectImageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(selectImageViewModel: SelectImageViewModel){
    Scaffold() {
        Column() {
            Button(onClick = { selectImageViewModel.selectImage() }) {
                Text(text = "Select Image")
            }
        }
    }
}
