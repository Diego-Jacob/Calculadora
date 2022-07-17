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
       var guardaString: String = ""

       fun digitaNumero (v1: String)
       {
          guardaString += v1
          binding.Visor1.text = "$guardaString"
       }

        fun apagaNumero ()
        {
           guardaString = guardaString.dropLast(1)
           binding.Visor1.text = "${guardaString}"
        }

        fun apagaTudo()
        {
           guardaString = ""
           binding.Visor1.text = guardaString
           binding.Visor2.text = "Apagou Tudo"
        }

        binding.Zero.setOnClickListener{
            if (guardaString != "") digitaNumero("0") }

        binding.Um.setOnClickListener{
            digitaNumero("1")
        }

        binding.Dois.setOnClickListener{
            digitaNumero("2") }

        binding.Apagar.setOnClickListener {
            apagaNumero()
        }

        binding.Apagar.setOnLongClickListener{
            apagaTudo()
            true
        }




    }
}