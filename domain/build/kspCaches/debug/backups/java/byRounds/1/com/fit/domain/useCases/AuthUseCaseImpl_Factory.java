package com.fit.domain.useCases;

import com.fit.data.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
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
public final class AuthUseCaseImpl_Factory implements Factory<AuthUseCaseImpl> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public AuthUseCaseImpl_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public AuthUseCaseImpl get() {
    return newInstance(authRepositoryProvider.get(), dispatcherProvider.get());
  }

  public static AuthUseCaseImpl_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new AuthUseCaseImpl_Factory(authRepositoryProvider, dispatcherProvider);
  }

  public static AuthUseCaseImpl newInstance(AuthRepository authRepository,
      CoroutineDispatcher dispatcher) {
    return new AuthUseCaseImpl(authRepository, dispatcher);
  }
}
