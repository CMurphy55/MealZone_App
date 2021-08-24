package ie.project.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.project.R
import ie.project.adapters.TransferAdapter
import ie.project.main.MealRepository
import ie.project.utils.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*
import org.jetbrains.anko.AnkoLogger

class MealListFragment : Fragment(), AnkoLogger{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_recyclerview, container, false)
        activity?.title = getString(R.string.action_report)

        root.recyclerView.layoutManager = LinearLayoutManager(activity)
        root.recyclerView.adapter = TransferAdapter(MealRepository.donations)

        val swipeDeleteHandler = object : SwipeToDeleteCallback(activity!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = root.recyclerView.adapter as TransferAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchDeleteHelper = ItemTouchHelper(swipeDeleteHandler)
        itemTouchDeleteHelper.attachToRecyclerView(root.recyclerView)

        return root
    }
}

