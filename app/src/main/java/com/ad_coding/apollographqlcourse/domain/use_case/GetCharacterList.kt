package com.ad_coding.apollographqlcourse.domain.use_case

import com.ad_coding.apollographqlcourse.domain.model.SimpleCharacter
import com.ad_coding.apollographqlcourse.domain.network.RickandMortyClient

class GetCharacterList(
    private val  client: RickandMortyClient
) {
    suspend fun execute(): List<SimpleCharacter> =
        client.getCharacterList()

}