package com.example.imc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var titleDensidadeCorporal: TextView
    private lateinit var textViewHeaderDensidadeCorporal: TextView
    private lateinit var textViewResultadoDensidadeCorporal: TextView
    private lateinit var textViewResultadoPeso: TextView
    private lateinit var textViewResultadoAltura: TextView
    private lateinit var btnFechar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        // Inicializando os componentes com findViewById
        titleDensidadeCorporal = findViewById(R.id.titleDensidadeCorporal)
        textViewHeaderDensidadeCorporal = findViewById(R.id.textViewHeaderDensidadeCorporal)
        textViewResultadoDensidadeCorporal = findViewById(R.id.textViewResultadoDensidadeCorporal)
        textViewResultadoPeso = findViewById(R.id.textViewResultadoPeso)
        textViewResultadoAltura = findViewById(R.id.textViewResultadoAltura)
        btnFechar = findViewById(R.id.btnFecharResultados)

        // Obtendo o objeto IMC passado pela Intent
        val imc = intent.getParcelableExtra<IMC>("value")

        // Configurando os textos dos componentes da UI
        titleDensidadeCorporal.text = imc?.nome.toString()
        textViewHeaderDensidadeCorporal.text = imc?.calcular()
        textViewResultadoDensidadeCorporal.text = "Seu IMC ${String.format("%.2f", imc?.imc)}"
        textViewResultadoPeso.text = "Seu Peso ${imc?.peso.toString()}"
        textViewResultadoAltura.text = "Sua Altura ${imc?.altura.toString()}"

        btnFechar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
