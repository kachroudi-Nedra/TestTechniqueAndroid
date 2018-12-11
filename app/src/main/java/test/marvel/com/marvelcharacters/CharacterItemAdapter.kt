package test.marvel.com.marvelcharacters

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_character_item.view.*
import test.marvel.com.marvelcharacters.models.MarvelCharacter
import test.marvel.com.marvelcharacters.models.MarvelCharacterIcon

class CharacterItemAdapter(
    val context: Context,
    val items: List<MarvelCharacter>,
    val listener: OnItemCharacterCardClickListener
) :
    RecyclerView.Adapter<CharacterItemViewHolder>() {


    var characters: ArrayList<MarvelCharacter>? = null


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CharacterItemViewHolder {
        return CharacterItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_character_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return characters!!.size
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder?, position: Int) {


        val character: MarvelCharacter = items[position]
        holder!!.imgCharacterPicto.setImageURI(
            Uri.parse(
                MarvelCharacterIcon.concatUrlPicto(
                    character.thumbnail.path,
                    character.thumbnail.extension
                )
            )
        )
        holder!!.tvCharacterName.text = character.name
    }

}

class CharacterItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvCharacterName = view.character_name!!
    val imgCharacterPicto = view.character_icon!!
}

interface OnItemCharacterCardClickListener {
    fun onItemClick(item: MarvelCharacter)
}

