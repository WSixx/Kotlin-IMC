package br.com.lucad.myimc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declarar Os objetos
        val editTextPeso = findViewById<EditText>(R.id.edit_text_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_text_altura)
        val buttonCalcular = findViewById<Button>(R.id.button_calcular)

        //Ação de clique
        buttonCalcular.setOnClickListener {
            //Pegar os valores dos EditText e converter para Double
            val peso: Double = editTextPeso.text.toString().toDouble()
            val altura: Double = editTextAltura.text.toString().toDouble()

            //TODO: Fazer validação de Null ou String

            //Chamar a Função para calcular o IMC
            calcularImc(peso, altura)

        }

    }

    private fun calcularImc(peso: Double, altura: Double){
        //Calculo de IMC
        val resultado = peso / (altura * altura)

        //Inicia uma Intent passando o contexto Atual e Activity que sera aberta
        val intent = Intent(this, ResultActivity::class.java)

        //Passando parametro outra Activity || putExtra({Chave}: "resultado", {Variavel passada}: resultado)
        intent.putExtra("resultado", resultado)
        startActivity(intent)
    }
}