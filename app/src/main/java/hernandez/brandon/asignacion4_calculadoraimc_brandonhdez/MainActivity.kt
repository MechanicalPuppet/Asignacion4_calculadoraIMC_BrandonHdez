package hernandez.brandon.asignacion4_calculadoraimc_brandonhdez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var imcAux: Double = 0.0
    var rangeAux: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight : EditText = findViewById(R.id.boxPeso) as EditText
        val height : EditText = findViewById(R.id.boxAltura) as EditText
        val calcular: Button = findViewById(R.id.btnCalcular) as Button
        val imcText: TextView = findViewById(R.id.imc) as TextView
        val rangeText: TextView = findViewById(R.id.range) as TextView

        fun calcularIMC(altura: Double, peso: Double): Double{
            val imc = peso / (Math.pow(altura, 2.0))
            return imc
        }

        fun obtenerRango(imc: Double): String {
            when {
                imc < 18.5 -> return "Bajo peso"
                imc >= 18.5 && imc <= 24.9 -> return "Saludable"
                imc >= 25 && imc <= 29.9 -> return "Sobrepeso"
                imc >= 30 && imc <= 34.9 -> return "Obesidad grado 1"
                imc >= 35 && imc <= 39.9 -> return "Obesidad grado 2"
                imc >= 40 -> return "Obesidad grado 3"
            }
            return "Error"
        }
        calcular.setOnClickListener {

            if(!weight.text.isBlank() && !height.text.isBlank()) {

                imcAux = calcularIMC(height.text.toString().toDouble(), weight.text.toString().toDouble())
                imcText.setText(imcAux.toString())

                rangeAux = obtenerRango(imcAux)
                rangeText.setText(rangeAux.toString())

                when (rangeAux) {
                    "Bajo peso" -> rangeText.setBackgroundResource(R.color.brown)
                    "Saludable" -> rangeText.setBackgroundResource(R.color.green)
                    "Sobrepeso" -> rangeText.setBackgroundResource(R.color.greenish)
                    "Obesidad grado 1" -> rangeText.setBackgroundResource(R.color.yellow)
                    "Obesidad grado 2" -> rangeText.setBackgroundResource(R.color.orange)
                    "Obesidad grado 3" -> rangeText.setBackgroundResource(R.color.red)
                }
            }


        }




    }
}