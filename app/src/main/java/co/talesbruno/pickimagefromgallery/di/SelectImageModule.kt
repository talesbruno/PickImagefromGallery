package co.talesbruno.pickimagefromgallery.di

import androidx.activity.result.ActivityResultRegistry
import co.talesbruno.pickimagefromgallery.data.repository.SelectImageImpl
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object SelectImageModule {
    @Provides
    fun provideSelectImage(registry: ActivityResultRegistry): SelectImage {
        return SelectImageImpl(registry)
    }
}