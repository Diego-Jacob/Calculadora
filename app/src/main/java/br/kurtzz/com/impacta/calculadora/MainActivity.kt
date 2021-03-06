package br.kurtzz.com.impacta.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.kurtzz.com.impacta.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

       var _binding: ActivityMainBinding? = null
       val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?)
    {
       super.onCreate(savedInstanceState)
       _binding = ActivityMainBinding.inflate(layoutInflater)
       var root = binding.root
       setContentView(root)

         var soma: (Double, Double) -> Double = {v1, v2 -> v1+v2}
         var sub: (Double, Double) -> Double = {v1,v2 -> v1-v2}
         var mult: (Double, Double) -> Double = {v1,v2 -> v1*v2}
         var div: (Double, Double) -> Double = {v1, v2 -> v1/v2}
         var percent: (Double, Double) -> Double = {v2, v1 -> v1/100 * v2}

       var guardaString: String = ""
       var guardaVisor2: String = ""
       var v1: String = ""
       var v2: String = ""
       var result: Double = 0.0
       var operacao: String = ""
       var contPonto: Int = 0

       fun calculadora(v1:Double, v2:Double, calc: (Double, Double) -> Double):Double
       {
          return (calc(v1,v2))
       }

       fun retornaCalculo (operacao: String)
       {
          when
           {
              operacao == "+" -> result = calculadora(v1.toDouble(),v2.toDouble(), soma)
              operacao == "-" -> result = calculadora(v1.toDouble(),v2.toDouble(), sub)
              operacao == "x" -> result = calculadora(v1.toDouble(),v2.toDouble(), mult)
              operacao == "/" -> result = calculadora(v1.toDouble(),v2.toDouble(), div)
              operacao == "%" -> result = calculadora(v1.toDouble(),v2.toDouble(), percent)
           }

       }

       fun digitaNumero (v1: String)
       {
          guardaString += v1
          binding.Visor1.text = "$guardaString"
       }

        fun apagaNumero ()
        {
           if (guardaString =="0.")
           {
               guardaString = ""
           }
           guardaString = guardaString.dropLast(1)
           binding.Visor1.text = "${guardaString}"
           if (guardaString == "") binding.Visor2.text = "$guardaVisor2"

        }

        fun apagaTudo()
        {
           guardaString = ""
           guardaVisor2 = ""
           v1 = ""
           v2 = ""
           operacao = ""
           contPonto = 0
           result = 0.0
           binding.Visor1.text = guardaString
           binding.Visor2.text = guardaVisor2
        }

        binding.Zero.setOnClickListener{
            if (guardaString != "") digitaNumero("0") }

        binding.Um.setOnClickListener{
            digitaNumero("1") }

        binding.Dois.setOnClickListener{
            digitaNumero("2") }

        binding.Tres.setOnClickListener{
            digitaNumero("3") }

        binding.Quatro.setOnClickListener{
            digitaNumero("4") }

        binding.Cinco.setOnClickListener{
            digitaNumero("5") }

        binding.Seis.setOnClickListener{
            digitaNumero("6") }

        binding.Sete.setOnClickListener{
            digitaNumero("7") }

        binding.Oito.setOnClickListener{
            digitaNumero("8") }

        binding.Nove.setOnClickListener{
            digitaNumero("9") }

        binding.Ponto.setOnClickListener{
            var contPonto: Int = guardaString.length
            var guardaPonto: String = ""
            var comparaPonto: Boolean = false

            if (guardaString == "") digitaNumero("0.")else
            {for (i in 0..contPonto -1)
            {
                guardaPonto = guardaString[i].toString()
                if (guardaPonto == ".") { comparaPonto = true }
            }
            if (!comparaPonto) digitaNumero(".")}
        }

        binding.Apagar.setOnClickListener {
            apagaNumero() }

        binding.Apagar.setOnLongClickListener{
            apagaTudo()
            true }

        binding.Soma.setOnClickListener {
            operacao = "+"
            guardaVisor2 = guardaString + operacao
            v1 = guardaString
            guardaString = ""
            binding.Visor1.text = "$guardaString"
            binding.Visor2.text = "$guardaVisor2"
        }

        binding.Sub.setOnClickListener {
            operacao = "-"
            guardaVisor2 = guardaString + operacao
            v1 = guardaString
            guardaString = ""
            binding.Visor1.text = "$guardaString"
            binding.Visor2.text = "$guardaVisor2"
        }

        binding.Div.setOnClickListener {
            operacao = "/"
            guardaVisor2 = guardaString + operacao
            v1 = guardaString
            guardaString = ""
            binding.Visor1.text = "$guardaString"
            binding.Visor2.text = "$guardaVisor2"
        }

        binding.Mult.setOnClickListener {
            operacao = "x"
            guardaVisor2 = guardaString + operacao
            v1 = guardaString
            guardaString = ""
            binding.Visor1.text = "$guardaString"
            binding.Visor2.text = "$guardaVisor2"
        }

        binding.Percent.setOnClickListener {
            operacao = "%"
            guardaVisor2 = guardaString + operacao
            v1 = guardaString
            guardaString = ""
            binding.Visor1.text = "$guardaString"
            binding.Visor2.text = "$guardaVisor2"
        }

        binding.Igual.setOnClickListener {
            v2 = guardaString
            guardaVisor2 = guardaVisor2 + guardaString
            retornaCalculo(operacao)
            binding.Visor1.text = "= $result"
            binding.Visor2.text = "$guardaVisor2"
            guardaString = ""
            guardaVisor2 = ""
        }

    }
}