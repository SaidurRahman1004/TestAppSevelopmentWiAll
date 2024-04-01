package com.example.testingpourposema

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var b1:Button
    private lateinit var b2:Button
    private lateinit var b3:Button
    private lateinit var b4:Button
    private lateinit var b5:Button
    private lateinit var b6:Button
    private lateinit var b7:Button
    private lateinit var b8:Button
    private lateinit var b9:Button
    private lateinit var rb1:RadioButton
    private lateinit var cb: CheckBox
    private lateinit var sw1: Switch
    private lateinit var sp1:Spinner
    private lateinit var sel:TextView
    private lateinit var list1:Button
    private lateinit var load:ProgressBar
    private lateinit var mainlayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        b4=findViewById(R.id.b4)
        b5=findViewById(R.id.b5)
        b6=findViewById(R.id.b6)
        b7=findViewById(R.id.b7)
        b8=findViewById(R.id.b8)
        b9=findViewById(R.id.b9)
        load=findViewById(R.id.load)
        rb1=findViewById(R.id.rb1)
        cb=findViewById(R.id.cb)
        sw1=findViewById(R.id.sw1)
        sp1=findViewById(R.id.sp1)
        list1=findViewById(R.id.list1)

        list1.setOnClickListener {
            val intent = Intent(this,lista::class.java)
            startActivity(intent)
        }

/////Spinner startt////
        val BestLang = resources.getStringArray(R.array.BestLang)//access the arte Item from string.xml
        if(sp1 != null){
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,BestLang
            )
            sp1.adapter = adapter

            sp1.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    /////toast/////
                    val te1:String = adapter.getItem(position).toString()
                    Toast.makeText(this@MainActivity, te1, Toast.LENGTH_SHORT).show()
                    /////text/////
                    val text3: String = parent?.getItemAtPosition(position).toString()
                    sel.text=text3

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
        /////Spinner end/////


        rb1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Cheaked", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Not Cheaked", Toast.LENGTH_LONG).show()
            }
        }

        cb.setOnCheckedChangeListener { buttonView, isChecked ->
            val sn = Snackbar.make(mainlayout,"CheckBox Cheaked",Snackbar.LENGTH_LONG)
                .setAction("Done?"){
                    val sn = Snackbar.make(mainlayout,"backek",Snackbar.LENGTH_LONG)
                    sn.show()
                }
            sn.show()

        }

        b7.setOnClickListener {
            load.visibility=View.VISIBLE
        }

        b8.setOnClickListener {
            load.visibility=View.GONE
        }

        mainlayout=findViewById(R.id.mainlayout)
        b1.setOnClickListener {
            val snackbar = Snackbar.make(mainlayout,"snackbar showed",Snackbar.LENGTH_LONG).setAction("Retry"){
                val snackbar = Snackbar.make(mainlayout,"snackbar showed",Snackbar.LENGTH_LONG)
                snackbar.setActionTextColor(Color.RED)
                snackbar.show()
            }
            snackbar.show()


        }

        b2.setOnClickListener {
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }

        b3.setOnClickListener {
            val alartcode = AlertDialog.Builder(this)
            alartcode.setTitle("Alert Sources code")
            alartcode.setMessage("        b3.setOnClickListener {\n" +
                    "            val alartcode = AlertDialog.Builder(this)\n" +
                    "            alartcode.setTitle(\"Alert Sources code\")\n" +
                    "            alartcode.setMessage(\"Write Massege\")\n" +
                    "            alartcode.setPositiveButton(\"back\"){\n" +
                    "                dialog, hich -> dialog.cancel()\n" +
                    "            }\n" +
                    "        }")
            alartcode.setPositiveButton("back"){
                dialog, hich -> dialog.cancel()
            }
            alartcode.show()
        }

        b4.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("This is AlertDialog")
            builder.setMessage("Do you Exit?")
            builder.setCancelable(false)
            builder.setPositiveButton("yes"){
                dialog, which -> finish()
            }
            builder.setNegativeButton("No"){
                dialog, which -> dialog.cancel()
            }
            builder.setIcon(R.drawable.alart)
            builder.show()

        }
        sw1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Switch Cheaket", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Switch not Cheaket", Toast.LENGTH_LONG).show()
            }

        }


    }
}