package com.cursoandroid.smartrecipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso  // Importar Picasso

class RecetaAdapter(private val context: Context, private val listaRecetas: List<Comida>) :
    RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>() {

    // ViewHolder para los elementos del RecyclerView
    class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreComida: TextView = itemView.findViewById(R.id.nombreComida)
        val dificultadComida: TextView = itemView.findViewById(R.id.dificultadComida)
        val tiempoComida: TextView = itemView.findViewById(R.id.tiempoComida)
        val imagenComida: ImageView = itemView.findViewById(R.id.imagenComida)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_receta, parent, false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = listaRecetas[position]

        // Asignamos los datos del modelo al ViewHolder
        holder.nombreComida.text = receta.nombre
        holder.dificultadComida.text = receta.dificultad
        holder.tiempoComida.text = receta.tiempo

        // Usamos Picasso para cargar la imagen de la URL
        Picasso.get().load(receta.imagenUrl).into(holder.imagenComida)

        // Acción al hacer clic en un ítem
        holder.itemView.setOnClickListener {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            // Pasar los datos de la receta seleccionada
            intent.putExtra("nombre", receta.nombre)
            intent.putExtra("descripcion", receta.descripcion)
            intent.putExtra("ingredientes", receta.ingredientes.toTypedArray())  // Convertir la lista a array
            intent.putExtra("preparacion", receta.preparacion)
            intent.putExtra("imagenUrl", receta.imagenUrl)

            // Iniciar la actividad de detalles
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listaRecetas.size
}
