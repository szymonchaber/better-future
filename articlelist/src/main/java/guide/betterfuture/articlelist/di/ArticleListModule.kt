package guide.betterfuture.articlelist.di

import dagger.Module
import dagger.Provides
import guide.betterfuture.articlelist.GetArticlesUseCase
import guide.betterfuture.articlelist.data.entity.mapper.ArticleEntityDataMapper
import guide.betterfuture.articlelist.data.net.ArticleService
import guide.betterfuture.articlelist.data.repository.ArticleDataRepository
import guide.betterfuture.articlelist.data.repository.datasource.ArticleListDataStoreFactory
import guide.betterfuture.articlelist.presentation.mapper.ArticleModelDataMapper
import guide.betterfuture.articlelist.presentation.presenter.ArticleListPresenter
import guide.betterfuture.core.domain.executor.PostExecutionThread
import guide.betterfuture.core.domain.executor.ThreadExecutor
import retrofit2.Retrofit

@Module
object ArticleListModule {

    @Provides
    fun provideArticleService(retrofit: Retrofit): ArticleService {
        return retrofit.create(ArticleService::class.java)
    }

    @Provides
    fun provideArticleListDataStoreFactory(articleService: ArticleService): ArticleListDataStoreFactory {
        return ArticleListDataStoreFactory(articleService)
    }

    @Provides
    fun provideArticleModelMapper(): ArticleEntityDataMapper {
        return ArticleEntityDataMapper()
    }

    @Provides
    fun provideGetArticlesUseCase(articlesRepository: ArticleDataRepository, threadExecutor: ThreadExecutor,
                                  postExecutionThread: PostExecutionThread): GetArticlesUseCase {
        return GetArticlesUseCase(articlesRepository, threadExecutor, postExecutionThread)
    }

    @Provides
    fun provideArticleListPresenter(articleModelMapper: ArticleModelDataMapper,
                                    getArticlesUseCase: GetArticlesUseCase): ArticleListPresenter {
        return ArticleListPresenter(articleModelMapper, getArticlesUseCase)
    }
}
