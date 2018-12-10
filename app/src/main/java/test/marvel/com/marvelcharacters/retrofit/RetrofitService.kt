package test.marvel.com.marvelcharacters.retrofit

import retrofit2.Call
import retrofit2.http.GET
import test.marvel.com.marvelcharacters.models.MarvelCharacters

/**
 * Created by Nedra KACHROUDI on 10/12/2018.
 */
interface RetrofitService {


    @GET("v1/public/characters?apikey=9dc107c3215f7f9bcc0d3d3770674223")
    fun getMarvelCharacters(): Call<MarvelCharacters>

}