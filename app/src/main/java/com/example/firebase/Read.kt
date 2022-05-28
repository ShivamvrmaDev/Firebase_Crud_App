package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.*

class Read : AppCompatActivity() {
    lateinit var mref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)


        var t = findViewById<TextView>(R.id.t)

        mref = FirebaseDatabase.getInstance().getReference()
        mref.child("id").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    var a = snapshot.value as Map<*, *>

                    t.text = a.get("id").toString()  //t is text view
                }
            }
var b=13
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }
}