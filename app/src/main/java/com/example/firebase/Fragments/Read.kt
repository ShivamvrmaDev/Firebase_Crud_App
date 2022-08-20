package com.example.firebase.Fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.RelativeLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.adapters.adapter
import com.example.firebase.classes.Data
import com.google.firebase.database.*
import java.util.*

class Read : Fragment(){
    lateinit var mref: DatabaseReference
    lateinit var array: ArrayList<Data>
    lateinit var array2: ArrayList<Data>
    lateinit var recycle :RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_read,container,false)
        setHasOptionsMenu(true)
        var progress=view.findViewById<RelativeLayout>(R.id.layout)
        progress.visibility=View.VISIBLE
array= ArrayList()
        array2= ArrayList()

         recycle=view.findViewById(R.id.recycler)
    recycle.layoutManager= LinearLayoutManager(context)

        mref = FirebaseDatabase.getInstance("https://retrieve-4329f-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("sites")

            mref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()) {
                        for(snap in snapshot.children) {

                            var data = snap.getValue(Data::class.java)!!
                            array.add(data)
                        }
                        array2.addAll(array)
                    }
                    progress.visibility=View.GONE
                  recycle.adapter= adapter(array2)

                    }

                override fun onCancelled(error: DatabaseError) {

                }

            })
return view
    }
    @SuppressLint("NewApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.icons,menu)
        var search= menu.findItem(R.id.search)
        var s=search.actionView as SearchView
        s.onActionViewExpanded()

        s.queryHint="Enter Your Id"
        s.setOnQueryTextListener(object:SearchView.OnQueryTextListener{


            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(p0: String?): Boolean {



                array2.clear()
                var text=p0?.lowercase(Locale.getDefault())

                if (text != null) {
                    array.forEach {

                        if (it.IDs?.lowercase(Locale.getDefault())?.contains(text) == true){

                            array2.add(it)
                        }
                    }
                    recycle.adapter?.notifyDataSetChanged()
                }

                else{
                    array2.clear()
                    array2.addAll(array)
                    recycle.adapter?.notifyDataSetChanged()
                }
                return true
            }
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

        })

        super.onCreateOptionsMenu(menu, inflater)
    }


}