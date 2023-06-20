package co.talesbruno.pickimagefromgallery.di



import android.content.Context
import androidx.activity.ComponentActivity
import co.talesbruno.pickimagefromgallery.data.repository.SelectImageImpl
import co.talesbruno.pickimagefromgallery.domain.repository.SelectImage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSelectImageImpl(activity: ComponentActivity): SelectImage {
        return SelectImageImpl(activity)
    }

    @Provides
    fun provideComponentActivity(@ApplicationContext context: Context): ComponentActivity {
        return context as ComponentActivity
    }
}