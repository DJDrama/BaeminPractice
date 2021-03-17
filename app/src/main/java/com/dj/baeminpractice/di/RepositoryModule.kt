package com.dj.baeminpractice.di

import com.dj.baeminpractice.repository.a_home.HomeRepository
import com.dj.baeminpractice.repository.a_home.HomeRepositoryImpl
import com.dj.baeminpractice.repository.b_eatwhat.EatWhatRepository
import com.dj.baeminpractice.repository.b_eatwhat.EatWhatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideEatWhatRepository(): EatWhatRepository {
        return EatWhatRepositoryImpl()
    }

}
