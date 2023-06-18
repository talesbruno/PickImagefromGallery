package co.talesbruno.pickimagefromgallery.data.repository


import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import javax.inject.Inject

class SelectImageImpl @Inject constructor(
    activity: ComponentActivity
) : SelectImage {
    private lateinit var imageUriFlow: Uri
    private val getContent = activity.registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            imageUriFlow = uri
        }
    }

    override suspend fun selectImage(): Uri {
        getContent.launch("image/*")
        return imageUriFlow
    }
}
