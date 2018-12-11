package test.marvel.com.marvelcharacters.models

import java.io.Serializable

data class MarvelCharacterIcon(val path: String, val extension: String) : Serializable {


    companion object {
        fun concatUrlPicto(path: String, extension: String): String {

            return "$path.$extension"
        }
    }
}
