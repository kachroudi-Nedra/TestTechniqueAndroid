package test.marvel.com.marvelcharacters.models

import java.io.Serializable
import java.util.*

data class MarvelCharacter(
    val id: Long,
    val name: String,
    val description: String,
    val modified: Date,
    val thumbnail: MarvelCharacterIcon
) : Serializable {

}
