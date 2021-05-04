package br.com.lucad.myimc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.NumberFormat

class ResultActivity : AppCompatActivity() {

    lateinit var textViewResultadoImc: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)
        textViewResultadoImc = findViewById(R.id.text_view_resultado_imc)

        val resultado:Double = intent.getDoubleExtra("resultado", 0.0)

        var mNumberFormat = NumberFormat.getInstance()
        mNumberFormat.maximumFractionDigits = 2

        textViewResultado.text = mNumberFormat.format(resultado)

        checkImc(resultado)

    }

    private fun checkImc(resultado: Double){
        //TODO: Fazer Com When

        if(resultado < 18.5){
            textViewResultadoImc.text = "Magreza"
        }else if( resultado >= 18.5 && resultado < 24.9){
            textViewResultadoImc.text = "Normal"
        }

    }

}