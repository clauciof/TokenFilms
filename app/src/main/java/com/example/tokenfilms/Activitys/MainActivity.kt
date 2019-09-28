package com.example.tokenfilms.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.tokenfilms.Models.Filme
import com.example.tokenfilms.R
import com.example.tokenfilms.Servicos.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Contract.View {
    lateinit var recyclerView: RecyclerView
    val presenter: Contract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        presenter.onLoadList()
    }

    override fun ExibeLista(filmes: List<Filme>){
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        val mAdapter = FilmesAdapter(this, filmes)// specify an adapter (see also next example)
        recyclerView.adapter = mAdapter
    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

}


/*
 var lista_de_filmes = mutableListOf<Filme>()
    var filme1 = Filme()
    var filme2 = Filme()
    var filme3 = Filme()
    var filme4 = Filme()
 filme1.set__id(1)
        filme1.set_poster_url("https://image.tmdb.org/t/p/w200/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg")
        filme1.set_title("Dilwale Dulhania Le Jayenge")
        filme1.set_vote_average(9.3)

        filme2.set__id(2)
        filme2.set_poster_url("https://image.tmdb.org/t/p/w200/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg")
        filme2.set_title("The Shawshank Redemption")
        filme2.set_vote_average(8.6)

        filme3.set__id(3)
        filme3.set_poster_url("https://image.tmdb.org/t/p/w200/rPdtLWNsZmAtoZl9PK7S2wE3qiS.jpg")
        filme3.set_title("The Godfather")
        filme3.set_vote_average(8.6)

        filme4.set__id(4)
        filme4.set_poster_url("https://image.tmdb.org/t/p/w200/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg")
        filme4.set_title("Whiplash")
        filme4.set_vote_average(8.4)

        lista_de_filmes.add(filme1)
        lista_de_filmes.add(filme2)
        lista_de_filmes.add(filme3)
        lista_de_filmes.add(filme4)
*
* */