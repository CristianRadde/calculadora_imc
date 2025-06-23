package com.example.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var titleDensidadeCorporal: TextView
    private lateinit var textViewHeaderDensidadeCorporal: TextView
    private lateinit var textViewResultadoDensidadeCorporal: TextView
    private lateinit var textViewPeso: TextView
    private lateinit var textViewAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        // Inicializando os componentes com findViewById
        titleDensidadeCorporal = findViewById(R.id.titleDensidadeCorporal)
        textViewHeaderDensidadeCorporal = findViewById(R.id.textViewHeaderDensidadeCorporal)
        textViewResultadoDensidadeCorporal = findViewById(R.id.textViewResultadoDensidadeCorporal)
        textViewPeso = findViewById(R.id.textViewPeso)
        textViewAltura = findViewById(R.id.textViewAltura)

        // Obtendo o objeto IMC passado pela Intent
        val imc: IMC? = intent.getParcelableExtra("value", IMC::class.java)

        // Configurando os textos dos componentes da UI
        titleDensidadeCorporal.text = imc?.nome ?: "Sem nome"
        textViewHeaderDensidadeCorporal.text = imc?.calcular() ?: "Resultado não disponível"

        // Exibir o IMC com 2 casas decimais (formatado)
        val imcFormatado = String.format("%.2f", imc?.imc ?: 0.0f)
        textViewResultadoDensidadeCorporal.text = "IMC: $imcFormatado"

        // Exibir peso e altura
        textViewPeso.text = "Peso: ${imc?.peso} kg"
        textViewAltura.text = "Altura: ${imc?.altura} cm"
    }
}
