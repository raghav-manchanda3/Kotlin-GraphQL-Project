package com.ad_coding.apollographqlcourse.data.di

import com.ad_coding.apollographqlcourse.data.network.ApolloRickAndMortyClient
import com.ad_coding.apollographqlcourse.domain.network.RickandMortyClient
import com.ad_coding.apollographqlcourse.domain.use_case.CharacterUseCases
import com.ad_coding.apollographqlcourse.domain.use_case.GetCharacterList
import com.ad_coding.apollographqlcourse.domain.use_case.GetCharacterbyId
import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient =
        ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()

 @Provides
 @Singleton
    fun provideRickAndMortyClient(
        apolloClient: ApolloClient
    ): RickandMortyClient = ApolloRickAndMortyClient(apolloClient)

  @Provides
  @Singleton
  fun provideCharacterUseCases(rickandMortyClient: RickandMortyClient):
          CharacterUseCases=
      CharacterUseCases(
          getCharacterbyId = GetCharacterbyId(client = rickandMortyClient),
          getCharacterList = GetCharacterList(client = rickandMortyClient)
              )

}