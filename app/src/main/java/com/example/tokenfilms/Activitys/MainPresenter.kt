package com.example.tokenfilms.Activitys

import android.content.Context
import android.widget.Toast
import com.example.tokenfilms.Models.Filme
import com.example.tokenfilms.Servicos.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: Contract.View): Contract.Presenter {
    override fun onLoadMovieDetail(id:  Int) {

    }

    override fun onLoadList(){
        val call = RetrofitInitializer().moviesService().get_all_movies()
        call.enqueue(object: Callback<List<Filme>> {
            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                response?.body()?.let {
                    val filmes: List<Filme> = it
                    view.ExibeLista(filmes)
                }
            }
            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                view.showMessage("Sem filmes para mostrar")
            }
        })
    }

}