package com.example.tokenfilms.Activitys

import com.example.tokenfilms.Models.Filme
import com.example.tokenfilms.Servicos.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPresenter(val view: Contract.DetailView): Contract.Presenter {
    override fun onLoadList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMovieDetail(id: Int) {
        val call = RetrofitInitializer().moviesService().get_movie_detail(id)
        call.enqueue(object: Callback<Filme> {
            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                response?.body()?.let {
                    val filme: Filme = it
                    view.ExibeMovieDetail(filme)
                }
            }
            override fun onFailure(call: Call<Filme>, t: Throwable) {
                view.showMessage("Sem filmes para mostrar")
            }
        })
    }


}