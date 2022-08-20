package com.example.firebase.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.firebase.R


class mainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =inflater.inflate(R.layout.fragment_main, container, false)
        var read=view.findViewById<TextView>(R.id.t1)
        var update_add=view.findViewById<TextView>(R.id.t2)
        var delete=view.findViewById<TextView>(R.id.t3)

         read.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_read)
         }
          update_add.setOnClickListener {
              view.findNavController().navigate(R.id.action_mainFragment_to_add2)
         }
          delete.setOnClickListener {
             view.findNavController().navigate(R.id.action_mainFragment_to_delete2)
         }
        return view

    }

}