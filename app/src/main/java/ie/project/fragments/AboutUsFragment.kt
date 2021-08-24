package ie.project.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ie.project.R


class AboutUsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = getString(R.string.aboutus_title)
        return inflater.inflate(R.layout.about_us, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AboutUsFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
