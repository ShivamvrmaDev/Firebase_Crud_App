package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
lateinit var id :EditText
lateinit var name :EditText
lateinit var price :EditText

    lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        price=findViewById(R.id.price)
      var  desc=findViewById<EditText>(R.id.desc)
      var  writer=findViewById<EditText>(R.id.writer)
      var  rating=findViewById<EditText>(R.id.rating)
        var  child=findViewById<EditText>(R.id.child)


        id=findViewById(R.id.id)
        name=findViewById(R.id.name)
        val b=findViewById<Button>(R.id.b)

        ref=FirebaseDatabase.getInstance().getReference()

b.setOnClickListener{

    var hello=price.text.toString()
    var name =name.text.toString()
    var id =id.text.toString()
    var descr =desc.text.toString()
    var writerr =writer.text.toString()
    var ratingg =rating.text.toString()
var ch=child.text.toString()
    var data =Data(id,name,hello,descr,writerr,ratingg)
    ref.child(ch).child(id).setValue(data)
}

    }
}