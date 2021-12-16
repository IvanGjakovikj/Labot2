package com.example.labot2.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.labot2.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieDetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id: TextView = view.findViewById(R.id.mID)
        val title: TextView = view.findViewById(R.id.mTitle)
        val plot: TextView = view.findViewById(R.id.mPlot)
        val actors: TextView = view.findViewById(R.id.mActors)
        val directors: TextView = view.findViewById(R.id.mDirectors)

        id.text ="ID:" + "  " + args.id
        title.text ="TITLE:" + "  " +  args.title
        plot.text ="PLOT:" + "  " + args.plot
        actors.text ="ACTORS:" + "  " + args.actors
        directors.text ="DIRECTOR/S:" + "  " + args.director
    }


}
