package com.cursoandroid.smartrecipes

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)  // Layout de esta actividad

        // Obtener los datos pasados desde la actividad anterior (la lista de recetas)
        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")
        val ingredientes = intent.getStringArrayExtra("ingredientes")?.joinToString("\n") // Convertir la lista a un solo texto
        val preparacion = intent.getStringExtra("preparacion")
        val imagenUrl = intent.getStringExtra("imagenUrl")

        // Referencias a los elementos del layout donde mostraremos los datos
        val nombreTextView: TextView = findViewById(R.id.nombreReceta)
        val descripcionTextView: TextView = findViewById(R.id.descripcionReceta)
        val ingredientesTextView: TextView = findViewById(R.id.ingredientesReceta)
        val preparacionTextView: TextView = findViewById(R.id.preparacionReceta)
        val imagenReceta: ImageView = findViewById(R.id.imagenReceta)

        // Establecer los valores de los datos en los componentes de la interfaz de usuario
        nombreTextView.text = nombre
        descripcionTextView.text = descripcion
        ingredientesTextView.text = ingredientes
        preparacionTextView.text = preparacion

        // Usar Picasso para cargar la imagen de la receta en el ImageView
        Picasso.get().load(imagenUrl).into(imagenReceta)

        // Agregar el comportamiento al botón de retroceso
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            // Regresar a la actividad anterior (MainActivity o la lista de recetas)
            finish()  // Este método cierra la actividad actual y vuelve a la actividad anterior
        }
    }
}
