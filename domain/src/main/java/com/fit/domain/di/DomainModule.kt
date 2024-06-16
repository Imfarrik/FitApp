package com.fit.domain.di

import com.fit.data.di.DataModule
import com.fit.data.repository.AuthRepository
import com.fit.domain.useCases.AuthUseCase
import com.fit.domain.useCases.AuthUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module(
    includes = [
        DataModule::class,
        DispatcherModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
    fun provideAuthUseCase(
        authRepository: AuthRepository,
        @IODispatcher
        dispatcher: CoroutineDispatcher
    ): AuthUseCase = AuthUseCaseImpl(authRepository, dispatcher)
}