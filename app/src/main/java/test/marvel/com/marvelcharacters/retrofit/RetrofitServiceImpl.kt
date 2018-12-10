package test.marvel.com.marvelcharacters.retrofit

import retrofit2.Callback
import test.marvel.com.marvelcharacters.models.MarvelCharacters

/**
 * Created by Nedra KACHROUDI on 10/12/2018.
 */
class RetrofitServiceImpl {


    /**
     * get Marvel Characters from api
     */
    fun getMarvelCharacters(listener: Callback<MarvelCharacters>) {

        val mService = RetrofitClient.getMarvelService()
        mService.getMarvelCharacters().enqueue(listener)
    }
}