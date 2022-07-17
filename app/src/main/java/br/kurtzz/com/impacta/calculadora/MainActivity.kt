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


    }
}