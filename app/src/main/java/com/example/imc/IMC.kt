package com.example.imc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IMC(
    var nome: String?,
    var peso: Float,
    var altura: Float,
    var imc: Float = 0.0f
) : Parcelable {

    fun calcular(): String {
        val alt = altura / 100
        val calc = peso / (alt * alt)
        val msg = when {
            calc >= 0 && calc < 16 -> "Magreza grave"
            calc >= 16 && calc < 17 -> "Magreza moderada"
            calc >= 17 && calc < 19 -> "Magreza leve"
            calc >= 19 && calc < 25 -> "Saudável"
            calc >= 25 && calc < 30 -> "Sobrepeso"
            calc >= 30 && calc < 35 -> "Obesidade I"
            calc >= 35 && calc < 40 -> "Obesidade II"
            else -> "Obesidade Mórbida."
        }
        imc = calc
        return msg
    }
}
