package com.ad_coding.apollographqlcourse.domain.network

import com.ad_coding.apollographqlcourse.domain.model.Character
import com.ad_coding.apollographqlcourse.domain.model.SimpleCharacter

interface RickandMortyClient {
    suspend fun getCharacterList():List<SimpleCharacter>

    suspend fun getCharacterbById(id:String): Character?

}