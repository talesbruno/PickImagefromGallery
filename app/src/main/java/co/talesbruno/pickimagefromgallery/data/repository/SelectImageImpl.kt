package co.talesbruno.pickimagefromgallery.data.repository


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject


class SelectImageImpl @Inject constructor(
    private val registry : ActivityResultRegistry
) : DefaultLifecycleObserver, SelectImage {
    private lateinit var getContent : ActivityResultLauncher<String>
    private lateinit var imageUriFlow: Flow<Uri?>
    override fun onCreate(owner: LifecycleOwner) {
        getContent = registry.register("key", owner, ActivityResultContracts.GetContent()) { uri ->
            owner.lifecycleScope.launch {
                imageUriFlow = flowOf(uri)
            }
        }
    }

    override suspend fun selectImage(): Uri? {
        getContent.launch("image/*")
        return imageUriFlow.first()
    }
}
