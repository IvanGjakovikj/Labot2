package com.example.labot2
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labot2.adapters.MovieAdapter
import com.example.labot2.api.MoviesApi
import com.example.labot2.api.MoviesApiClient
import com.example.labot2.databinding.FragmentFirstBinding
import com.example.labot2.fragment.MovieDetailsFragment
import com.example.labot2.models.MovieWrapper
import com.example.labot2.models.Movies
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieListFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var movieApiClient: MoviesApi
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: MovieAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         inflater.inflate(R.layout.fragment_first, container, false)
         //inflater.inflate(R.layout.movie,container,false)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieApiClient = MoviesApiClient.getUserApi()!!
        movieRecyclerView = view.findViewById(R.id.allMoviesRecyclerView)
        movieRecyclerView.layoutManager = LinearLayoutManager(activity)
        movieRecyclerView.setHasFixedSize(true)
        recyclerViewAdapter = MovieAdapter(mutableListOf())
        {

            val titile =  it.title

           Toast.makeText(this.context, titile, Toast.LENGTH_SHORT).show()
            val action = MovieListFragmentDirections.actionFirstFragmentToMovieDetailsFragment2(it.title,it.id.toString(),it.plot,it.actors,it.director)
                findNavController().navigate(action)
        }
        movieRecyclerView.adapter = recyclerViewAdapter
        val listId = "98685cd6-24d2-42a4-a69d-0e508addb125"
            searchPlayList(listId)
    }

    fun searchPlayList(id: String){
        movieApiClient.getPlayListByURL(id).enqueue(object : Callback<MovieWrapper>{
            override fun onResponse(call: Call<MovieWrapper>, response: Response<MovieWrapper>) {
                if(response.code() == 200) {
                    displayData(response.body())
                    Toast.makeText(activity,"Success!!", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<MovieWrapper>, t: Throwable) {
                Toast.makeText(activity,"Error!!",Toast.LENGTH_LONG).show()
            }
        })

    }
   private fun displayData(data: MovieWrapper?) {
       if (data != null) {
           data.movies?.let { recyclerViewAdapter.updateData(it) }
       }
   }

}
