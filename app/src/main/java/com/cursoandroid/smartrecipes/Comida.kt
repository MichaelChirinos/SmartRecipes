package com.cursoandroid.smartrecipes

data class Comida(
    val nombre: String,
    val dificultad: String,
    val tiempo: String,
    val imagenUrl: String,
    val descripcion: String,
    val ingredientes: List<String>, // Asegúrate de que sea una lista
    val preparacion: String
)


/*
data class Comida(
    val nombre: String,
    val dificultad: String,
    val tiempo: String,
    val imagenUrl: String
)
*/