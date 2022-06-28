package com.example.lab1peliculas.ui.slideshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab1peliculas.adapter.MovieAdapter
import com.example.lab1peliculas.data.DataSource
import com.example.lab1peliculas.data.Movie
import com.example.lab1peliculas.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)



        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        // */

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val datos = DataSource().getMoviesList()
        with(binding)
        {
            lvMovies.adapter = MovieAdapter(requireContext(), datos)
            lvMovies.setOnItemClickListener{ adapterView, view, i, l ->
                val movieSelect = adapterView.adapter.getItem(i) as Movie
                var uri = Uri.parse(movieSelect.description)
                startActivity(Intent(Intent.ACTION_VIEW, uri))


            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}