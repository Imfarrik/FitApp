package com.fit.domain.di;

import com.fit.data.repository.AuthRepository;
import com.fit.domain.useCases.AuthUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.fit.domain.di.IODispatcher")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DomainModule_ProvideAuthUseCaseFactory implements Factory<AuthUseCase> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public DomainModule_ProvideAuthUseCaseFactory(Provider<AuthRepository> authRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public AuthUseCase get() {
    return provideAuthUseCase(authRepositoryProvider.get(), dispatcherProvider.get());
  }

  public static DomainModule_ProvideAuthUseCaseFactory create(
      Provider<AuthRepository> authRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new DomainModule_ProvideAuthUseCaseFactory(authRepositoryProvider, dispatcherProvider);
  }

  public static AuthUseCase provideAuthUseCase(AuthRepository authRepository,
      CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideAuthUseCase(authRepository, dispatcher));
  }
}
