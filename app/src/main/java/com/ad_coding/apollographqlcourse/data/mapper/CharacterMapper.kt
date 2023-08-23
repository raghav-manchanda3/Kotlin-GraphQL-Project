package com.ad_coding.apollographqlcourse.data.mapper
import com.ad_coding.CharacterQuery
import com.ad_coding.CharactersQuery
import com.ad_coding.apollographqlcourse.domain.model.Character
import com.ad_coding.apollographqlcourse.domain.model.SimpleCharacter

fun CharactersQuery.Characters.toCharacterList():List<SimpleCharacter> =
    this.results
        ?.mapNotNull { result -> SimpleCharacter(
            id=result?.id.orEmpty(),
            name=result?.name.orEmpty(),
            image = result?.image.orEmpty(),
            species = result?.species.orEmpty()
        ) }.orEmpty()

fun CharacterQuery.Character.toCharacter():Character=
    Character(
        id=this?.id.orEmpty(),
        name=this.name.orEmpty(),
        gender = this.gender.orEmpty(),
        image = this.image.orEmpty(),
        species = this.species.orEmpty()
    )
