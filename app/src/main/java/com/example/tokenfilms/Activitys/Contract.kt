package com.example.tokenfilms.Activitys

import com.example.tokenfilms.Models.Filme

interface Contract {

    interface View{
        fun ExibeLista(flmes: List<Filme>)
        fun showMessage(s: String)
    }

    interface DetailView{
        fun ExibeMovieDetail(filme: Filme)
        fun showMessage(s: String)
    }

    interface Presenter{
        fun onLoadList()
        fun onLoadMovieDetail(id: Int)
    }
}