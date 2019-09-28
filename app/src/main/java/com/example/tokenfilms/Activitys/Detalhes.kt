package com.example.tokenfilms.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions
import com.example.tokenfilms.Models.Filme
import com.example.tokenfilms.R
import com.example.tokenfilms.Utils.GlideApp
import kotlinx.android.synthetic.main.activity_detalhes.*
import kotlinx.android.synthetic.main.item_filme.view.*
import java.util.EnumSet.range


class Detalhes : AppCompatActivity() , Contract.DetailView {

    val presenter: Contract.Presenter = DetailsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        if  ( intent.hasExtra("id") ){
           var id = intent.getStringExtra("id").toString()
           presenter.onLoadMovieDetail(intent.getStringExtra("id").toInt())
           //Toast.makeText(this, intent.getStringExtra("id"), Toast.LENGTH_LONG).show()
            //Log.e("onFailure error", id)
        }
        var genres: Array<String>  = intent.getStringArrayExtra("generos")
        titulo_filme.text = intent.getStringExtra("titulo").toString()
        rate.text = intent.getStringExtra("rate").toString()
        if(genres.size == 3){
            genero1.text = genres[0]
            genero2.text = genres[1]
            genero3.text = genres[2]
        }
        if(genres.size == 2){
            genero1.text = genres[0]
            genero2.text = genres[1]
            genero3.text = ""
        }
        if(genres.size == 1){
            genero1.text = genres[0]
            genero2.text = ""
            genero3.text = ""
        }

    }

  override fun ExibeMovieDetail(filme: Filme) {

            titulo_filme.text = filme.get_title()
            rate.text = filme.get_vote_average().toString()
            var imagem: String = filme.get_backdrop_url()
            descricao.text = filme.get_descricao()
            language.text = filme.get_pais_origem().toUpperCase()
            var generos: Array<String> = filme.get_generos()
            var release_date: String = filme.get_release_date()
            release.text = filme.get_release_date()

            val options = RequestOptions() // Caso de erro no request
                .centerCrop()
                .placeholder(R.drawable.imagem_background)
                .error(R.drawable.imagem_background)
                .override(720, 320)

            GlideApp.with(this)
                .load(imagem)
                .apply(options)
                //.fitCenter()
                .into(background_filme)

    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

}
