package com.example.tokenfilms.Activitys

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

import com.example.tokenfilms.Models.Filme
import com.example.tokenfilms.R
import com.example.tokenfilms.Utils.GlideApp
import com.example.tokenfilms.Utils.GlideModule
//import com.example.tokenfilms.Utils.GlideApp
import kotlinx.android.synthetic.main.item_filme.view.*

import com.bumptech.glide.request.RequestOptions
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent




class FilmesAdapter(val context: Context, val filmes: List<Filme>): RecyclerView.Adapter<FilmesAdapter.ViewHolder>(){
   // private val listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, filmes[position], position)
    }

    override fun getItemCount() = filmes.size // Return the size of your dataset (invoked by the layout manager)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(context: Context, filme: Filme, position: Int){
            //itemView.titulo_filme.text = filme.get_title()
            itemView.rate.text = filme.get_vote_average().toString()

            val options = RequestOptions() // Caso de erro no request
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .override(720, 320)

            GlideApp.with(context)
                .load(filme.get_poster_url())
                .apply(options)
                .fitCenter()
                .into(itemView.background_filme)

            itemView.setOnClickListener {
                var id = filme.get__id().toString()
                var title = filme.get_title().toString()
                var release = filme.get_release_date().toString()
                var genres: Array<String>  = filme.get_generos()
                var rate: String = filme.get_vote_average().toString()


                //Toast.makeText(context, id, Toast.LENGTH_LONG).show()

                val activity_detalhes = Intent(context, Detalhes::class.java)
                activity_detalhes.putExtra("id", id)
                activity_detalhes.putExtra("titulo", title)
                activity_detalhes.putExtra("data", release)
                activity_detalhes.putExtra("generos", genres)
                activity_detalhes.putExtra("rate", rate)
                context.startActivity(activity_detalhes)
            }



        }


    }





}