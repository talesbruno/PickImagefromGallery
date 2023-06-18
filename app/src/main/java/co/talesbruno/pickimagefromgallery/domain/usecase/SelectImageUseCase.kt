package co.talesbruno.pickimagefromgallery.domain.usecase

import android.net.Uri
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import javax.inject.Inject

class SelectImageUseCase @Inject constructor(private val selectImage: SelectImage) {
    suspend operator fun invoke() : Uri? = selectImage.selectImage()
}