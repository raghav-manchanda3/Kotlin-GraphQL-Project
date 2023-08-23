package com.ad_coding.apollographqlcourse.domain.use_case

import com.ad_coding.apollographqlcourse.domain.network.RickandMortyClient

class GetCharacterbyId(
    private val client: RickandMortyClient
) {
    suspend fun execute(id:String)=
        client.getCharacterbById(id)
}