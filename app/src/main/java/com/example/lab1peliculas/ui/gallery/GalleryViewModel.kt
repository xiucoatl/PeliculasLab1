package com.example.lab1peliculas.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _nombre = MutableLiveData<String>().apply {
        value = "Nombre"
    }

    private val _correo = MutableLiveData<String>().apply {
        value = "Correo"
    }

    private val _contraseña = MutableLiveData<String>().apply {
        value = "Contraseña"
    }
    val nombre: LiveData<String> = _nombre
    val correo: LiveData<String> = _correo
    val contraseña: LiveData<String> = _contraseña
}