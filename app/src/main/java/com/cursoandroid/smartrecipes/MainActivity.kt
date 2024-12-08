package com.cursoandroid.smartrecipes

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursoandroid.smartrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear una lista de recetas (de ejemplo)
        val listaRecetas = listOf(
            Comida("Tarta de Manzana", "Fácil", "30 min", "https://cdn0.recetasgratis.net/es/posts/5/4/2/torta_invertida_de_manzana_con_aceite_77245_orig.jpg", "Tarta deliciosa con manzanas frescas", listOf("Manzanas", "Harina", "Azúcar", "Huevo"), "1. Precalentar el horno a 180°C. 2. Mezclar todos los ingredientes. 3. Hornear durante 30 minutos."),
            Comida("Ensalada César", "Fácil", "10 min", "https://cdn.kiwilimon.com/brightcove/6506/6506.jpg", "Ensalada fresca con aderezo César", listOf("Lechuga", "Pollo", "Aderezo César", "Pan tostado"), "1. Cortar la lechuga. 2. Añadir el pollo y el aderezo. 3. Servir con pan tostado."),
            Comida("Pizza Casera", "Media", "40 min", "https://cecinasllanquihue.cl/blog/wp-content/uploads/2021/05/food-photographer-david-fedulov-Xt84tIHbjRY-unsplash-1200x600.jpg", "Pizza con masa casera, salsa de tomate, queso y tus ingredientes favoritos", listOf("Harina", "Levadura", "Tomate", "Queso", "Pepperoni"), "1. Preparar la masa y dejar reposar. 2. Extender la masa. 3. Colocar salsa de tomate, queso y toppings. 4. Hornear por 20 minutos."),
            Comida("Spaghetti Integral", "Fácil", "25 min", "https://i.blogs.es/399159/dap/450_1000.jpg", "Espaguetis integrales acompañados de salsa de tomate natural", listOf("Espaguetis integrales", "Tomate", "Ajo", "Albahaca"), "1. Cocinar los espaguetis según las instrucciones. 2. Preparar la salsa con tomate, ajo y albahaca. 3. Mezclar y servir."),
            Comida("Pechuga de Pollo a la Parrilla", "Fácil", "25 min", "https://minervafoods.com/wp-content/uploads/2022/12/peito_de_frango_grelhado_na_churrasqueira_-_blog-2.jpg", "Pechuga de pollo marinada y cocinada a la parrilla", listOf("Pechuga de pollo", "Aceite de oliva", "Ajo", "Limón"), "1. Marinar el pollo con ajo, limón y aceite de oliva. 2. Cocinar a la parrilla durante 10-12 minutos."),
            Comida("Ensalada de Quinua", "Fácil", "20 min", "https://www.recetaslider.cl/wp-content/uploads/2021/06/principal_5cb62f13ceb97.jpg", "Ensalada fresca con quinua, verduras y un aderezo ligero", listOf("Quinua", "Pepino", "Tomate", "Limón", "Aceite de oliva"), "1. Cocinar la quinua. 2. Cortar las verduras. 3. Mezclar todo con el aderezo y servir."),
            Comida("Sopa de Lentejas", "Fácil", "35 min", "https://pittsburghfoodbank.org/wp-content/uploads/2021/08/Recipe-Images-20.png", "Sopa nutritiva de lentejas con vegetales", listOf("Lentejas", "Zanahorias", "Cebolla", "Tomate", "Ajo"), "1. Cocinar las lentejas con zanahorias y cebolla. 2. Agregar los tomates y el ajo. 3. Cocinar hasta que esté todo tierno."),
            Comida("Tacos Veganos", "Fácil", "20 min", "https://recetasveganas.net/wp-content/uploads/2020/07/recetas-tacos-sin-carne-vegetariano-alubias-aguacate-tomate-olivas2.jpg", "Tacos veganos con guacamole y frijoles", listOf("Tortillas", "Frijoles", "Aguacate", "Tomate", "Lechuga"), "1. Calentar las tortillas. 2. Rellenar con frijoles, guacamole y verduras frescas."),
            Comida("Aguadito de Pollo", "Media", "45 min", "https://okdiario.com/img/2021/09/22/aguadito-de-pollo-peruano_-la-mejor-sopa-que-probaras-en-este-inverno.jpg", "Sopa peruana de pollo con arroz y verduras", listOf("Pollo", "Arroz", "Papas", "Cilantro", "Ajo"), "1. Cocinar el pollo con las papas. 2. Añadir arroz y cilantro. 3. Cocinar hasta que esté listo."),
            Comida("Causa Rellena", "Media", "13 min", "https://mercadosanmartinpe.com/wp-content/uploads/2020/08/causa-vegetariana.png", "Causa rellena con puré de papa y aguacate", listOf("Papa", "Aguacate", "Jugo de limón", "Pollo"), "1. Hacer un puré con la papa. 2. Rellenar con pollo y aguacate. 3. Servir frío.")
        )

        // Mostrar todas las recetas inicialmente
        val recetaAdapter = RecetaAdapter(this, listaRecetas)
        binding.recetaRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.recetaRecyclerView.adapter = recetaAdapter

        // Configuración del filtro de dificultad
        val difficultyFilter = binding.difficultyFilter
        val difficultyOptions = arrayOf("Nada", "Fácil", "Media", "Difícil") // "Nada" para no filtrar nada al inicio
        val difficultyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, difficultyOptions)
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        difficultyFilter.adapter = difficultyAdapter

        // Configuración del filtro de tiempo
        val timeFilter = binding.timeFilter
        val timeOptions = arrayOf("Nada", "0-10 min", "11-20 min", "21-30 min", "31-40 min", "41-50 min") // "Nada" para no filtrar nada al inicio
        val timeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, timeOptions)
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timeFilter.adapter = timeAdapter

        // Agregar listeners para los filtros
        binding.difficultyFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                filterRecipes(
                    binding.difficultyFilter.selectedItem.toString(),
                    binding.timeFilter.selectedItem.toString(),
                    listaRecetas
                )
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No hacer nada
            }
        }

        binding.timeFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                filterRecipes(
                    binding.difficultyFilter.selectedItem.toString(),
                    binding.timeFilter.selectedItem.toString(),
                    listaRecetas
                )
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No hacer nada
            }
        }
    }

    private fun filterRecipes(difficulty: String, time: String, recipes: List<Comida>) {
        // Filtrar las recetas según los filtros seleccionados
        val filteredRecipes = recipes.filter {
            val difficultyFilter = difficulty == "Nada" || it.dificultad == difficulty
            val timeFilter = time == "Nada" || getTimeInMinutes(it.tiempo) in getTimeRange(time)

            difficultyFilter && timeFilter
        }

        // Actualizar el RecyclerView con las recetas filtradas
        val recetaAdapter = RecetaAdapter(this, filteredRecipes)
        binding.recetaRecyclerView.adapter = recetaAdapter
    }

    private fun getTimeInMinutes(time: String): Int {
        return when {
            time.contains("min") -> time.replace(" min", "").toInt()
            else -> 0
        }
    }

    private fun getTimeRange(time: String): IntRange {
        return when (time) {
            "0-10 min" -> 0..10
            "11-20 min" -> 11..20
            "21-30 min" -> 21..30
            "31-40 min" -> 31..40
            "41-50 min" -> 41..50
            else -> 0..0 // Si no hay filtro, no aplicamos rango
        }
    }
}
