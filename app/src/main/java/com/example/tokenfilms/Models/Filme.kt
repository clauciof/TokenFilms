package com.example.tokenfilms.Models

import android.support.v7.widget.DialogTitle

class Filme {
    var id: Int? = null
    var vote_average: Double? = null //rate
    var title: String? = null //titulo
    var poster_url: String = "" //url
    var genres: Array<String> = arrayOf() //generos[3]
    var release_date: String? = null
    var backdrop_url: String? = null
    var original_language: String? = null
    var overview: String? = null



    fun set__id(id: Int){
        this.id = id
    }
    fun set_poster_url(url: String){
        this.poster_url = url
    }
    fun set_vote_average(vote: Double){
        this.vote_average = vote
    }
    fun set_title(title: String){
        this.title = title
    }
    fun set_generos(generos: Array<String>){
        this.genres = generos
    }
    fun set_release_date(data: String){
        this.release_date = data
    }

    fun set_backdrop_url(url: String){
        this.backdrop_url = url
    }

    fun set_pais_origem(pais: String){
        this.original_language = pais
    }
    fun set_descricao(descricao: String){
        this.overview= descricao
    }


    fun get__id(): Int{
        return this.id!!
    }
    fun get_poster_url(): String{
        return this.poster_url!!
    }
    fun get_vote_average(): Double{
        return this.vote_average!!
    }
    fun get_title():String{
        return this.title!!
    }
    fun get_generos(): Array<String>{
        return this.genres!!
    }
    fun get_release_date(): String{
       return  this.release_date!!
    }
    fun get_backdrop_url(): String{
        return this.backdrop_url!!
    }
    fun get_pais_origem(): String{
        return this.original_language!!
    }
    fun get_descricao(): String{
        return this.overview!!
    }
}