package guide.betterfuture.core.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import guide.betterfuture.core.BuildConfig
import guide.betterfuture.core.data.executor.JobExecutor
import guide.betterfuture.core.domain.executor.PostExecutionThread
import guide.betterfuture.core.domain.executor.ThreadExecutor
import guide.betterfuture.core.presentation.UIThread
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object IOModule {

    private const val API_BASE_URL = "https://betterfuture-dfd4.restdb.io/rest/"

    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        val cache = Cache(context.cacheDir, cacheSize.toLong())

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY)).cache(cache)
            .addInterceptor {
                val request = it.request()
                    .newBuilder()
                    .addHeader("x-apikey", BuildConfig.DatabaseApiKey).build()
                it.proceed(request)
            }
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }
}
