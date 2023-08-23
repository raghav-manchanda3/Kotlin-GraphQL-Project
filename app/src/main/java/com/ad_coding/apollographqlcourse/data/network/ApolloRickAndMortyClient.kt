package com.ad_coding.apollographqlcourse.data.network

import com.ad_coding.CharacterQuery
import com.ad_coding.CharactersQuery
import com.ad_coding.apollographqlcourse.data.mapper.toCharacter
import com.ad_coding.apollographqlcourse.data.mapper.toCharacterList
import com.ad_coding.apollographqlcourse.domain.model.Character
import com.ad_coding.apollographqlcourse.domain.model.SimpleCharacter
import com.ad_coding.apollographqlcourse.domain.network.RickandMortyClient
import com.apollographql.apollo3.ApolloClient

class ApolloRickAndMortyClient(
    private val apolloClient: ApolloClient
) : RickandMortyClient{

    override suspend fun getCharacterList(): List<SimpleCharacter> =

        apolloClient.query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.toCharacterList()
            .orEmpty()


    override suspend fun getCharacterbById(id: String): Character? =
        apolloClient
            .query(CharacterQuery(id))
            .execute()
            .data
            ?.character
            ?.toCharacter()



}