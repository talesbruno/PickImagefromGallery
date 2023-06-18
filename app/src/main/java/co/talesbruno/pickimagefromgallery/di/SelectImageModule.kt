package co.talesbruno.pickimagefromgallery.di



import androidx.activity.ComponentActivity
import co.talesbruno.pickimagefromgallery.data.repository.SelectImageImpl
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideSelectImage(activity: ComponentActivity): SelectImage {
        return SelectImageImpl(activity)
    }
}