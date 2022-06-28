package com.example.lab1peliculas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.lab1peliculas.R
import com.example.lab1peliculas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        val textView2: TextView = binding.textCorreo
        val textView3: TextView = binding.textPassword
        galleryViewModel.nombre.observe(viewLifecycleOwner) {
            textView.text = it
        }
        galleryViewModel.correo.observe(viewLifecycleOwner){
            textView2.text = it
        }
        galleryViewModel.contraseña.observe(viewLifecycleOwner){
            textView3.text = it
        }

        binding.button.setOnClickListener{ view ->
            val pattern: String = "^[a-z0-9+]{6,}\$"
            val regExp: Regex = Regex(pattern)
            val texto = binding.tietContraseA.text.toString()
            val resultado = regExp.matches(texto)
            if(!resultado){
                Toast.makeText(
                    requireContext(),
                    "la contraseña tiene que ser de almenos 6 caracteres y un numero",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                if(binding.tietCorreo.text.toString().equals("") && binding.tietNombre.text.toString().equals("")){
                    Toast.makeText(
                        requireContext(),
                        "la contraseña tiene que ser de almenos 6 caracteres y un numero",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else{
                    Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_nav_slideshow)
                }

            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}