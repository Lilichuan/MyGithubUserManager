package com.lililib.mygithub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lililib.mygithub.R
import com.lililib.mygithub.ui.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class UserItemFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyUserItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }
        return view
    }

    companion object {



        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() =
            UserItemFragment().apply {
                arguments = Bundle().apply {
                    //putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}