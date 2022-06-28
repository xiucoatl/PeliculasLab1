package com.example.lab1peliculas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lab1peliculas.data.Movie
import com.example.lab1peliculas.databinding.ElementoBinding
import com.example.lab1peliculas.ui.slideshow.SlideshowFragment

class MovieAdapter(private val contexto: Context, val datos: ArrayList<Movie>):BaseAdapter() {

    private  val layoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return  datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ElementoBinding.inflate(layoutInflater)

        with(binding){
            textTitle.text = datos[p0].title
            textGenero.text = datos[p0].genero
        }
        return binding.root
    }


}