package com.example.firebase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.firebase.R
import com.example.firebase.classes.Data
import com.google.firebase.database.DatabaseReference
import com.squareup.picasso.Picasso

lateinit var firebase :DatabaseReference

class adapter(var data: ArrayList<Data>) : Adapter<adapter.viewholderclass>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderclass {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.adapter,parent,false)

        return viewholderclass(view)
    }

    override fun onBindViewHolder(holder: viewholderclass, position: Int) {


        holder.site.text=data[position].sitename.toString()
         holder.id.text=data[position].IDs
         holder.password.text= data[position].password.toString()
       Picasso.get().load(data[position].image).into(holder.image)

        }

    override fun getItemCount() :Int{
        return data.size             /* returning the size  */
    }
    class viewholderclass(view: View) : RecyclerView.ViewHolder(view) {

        var site=view.findViewById<TextView>(R.id.site)
        var id=view.findViewById<TextView>(R.id.id)
        var password=view.findViewById<TextView>(R.id.password)
        var image=view.findViewById<ImageView>(R.id.image)





    }
}