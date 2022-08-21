package com.example.firebase.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.firebase.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class delete : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(R.layout.fragment_delete, container, false)
var delete=view.findViewById<Button>(R.id.delete)
        var edit=view.findViewById<EditText>(R.id.edit)
        var b3=view.findViewById<TextView>(R.id.t1)

             b3.visibility=View.GONE
           var  reference= FirebaseDatabase.getInstance("https://retrieve-4329f-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("sites")
        delete.setOnClickListener {

            var data=edit.text.toString()
            reference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.hasChild(data) && data.isNotEmpty()) {


                        var build = AlertDialog.Builder(activity as Context)

                        build.setTitle("Delete ")
                        build.setMessage("Are you sure you want to this site's details")
                        build.setPositiveButton("yes") { text, listner ->


                            reference.child(data).removeValue()

                                .addOnSuccessListener {

                                    edit.setText("")
                                    Toast.makeText(
                                        activity as Context,
                                        "$data deleted successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    b3.visibility = View.VISIBLE
                                    b3.setOnClickListener {
                                        view.findNavController()
                                            .navigate(R.id.action_delete2_to_read)
                                    }
                                }

                            build.setNegativeButton("No") { text, listner ->

                            }

                            build.create()
                            build.show()

                        }
                    }else{


                        Toast.makeText(activity as Context, "Enter valid Value", Toast.LENGTH_SHORT).show()
                    }
                }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }




        })
        }

        return view

    }


}