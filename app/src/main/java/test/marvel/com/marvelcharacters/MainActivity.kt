package test.marvel.com.marvelcharacters

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import test.marvel.com.marvelcharacters.models.MarvelCharacter
import test.marvel.com.marvelcharacters.models.MarvelCharacters
import test.marvel.com.marvelcharacters.retrofit.RetrofitServiceImpl

class MainActivity : AppCompatActivity() {

    private var charactersRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listener = object : OnItemCharacterCardClickListener {
            override fun onItemClick(item: MarvelCharacter) {
                Toast.makeText(this@MainActivity, "Open Details", Toast.LENGTH_SHORT).show()
            }
        }

        val callbackRetorift = object : retrofit2.Callback<MarvelCharacters> {
            override fun onFailure(call: Call<MarvelCharacters>, t: Throwable) {

            }

            override fun onResponse(call: Call<MarvelCharacters>, response: Response<MarvelCharacters>) {


                var contractAllAdapter = CharacterItemAdapter(this@MainActivity, response.body()!!.results, listener)


                val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                charactersRecyclerView!!.run {
                    layoutManager = linearLayoutManager
                    setHasFixedSize(true)
                    isNestedScrollingEnabled = false
                    adapter = contractAllAdapter
                }
                contractAllAdapter.notifyDataSetChanged()
            }

        }

        RetrofitServiceImpl().getMarvelCharacters(callbackRetorift)


    }
}
