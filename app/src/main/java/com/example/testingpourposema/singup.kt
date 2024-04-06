package com.example.testingpourposema

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class singup : AppCompatActivity() {
    private lateinit var logtxt:TextView
    private lateinit var un:EditText
    private lateinit var ea:EditText
    private lateinit var pw:EditText
    private lateinit var dob:EditText
    private lateinit var cu:Spinner
    private lateinit var gn:Spinner
    private lateinit var al:Switch
    private lateinit var ac:RadioButton
    private lateinit var su:CheckBox
    private lateinit var caa:Button
    private lateinit var pb:ProgressBar
    private lateinit var singupp:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)
        logtxt = findViewById(R.id.logtxt)

        un = findViewById(R.id.un)
        ea = findViewById(R.id.ea)
        pw = findViewById(R.id.pw)
        dob = findViewById(R.id.dob)
        cu = findViewById(R.id.cu)
        gn = findViewById(R.id.gn)
        al = findViewById(R.id.al)
        ac = findViewById(R.id.ac)
        su = findViewById(R.id.su)
        caa = findViewById(R.id.caa)
        pb = findViewById(R.id.pb)
        singupp = findViewById(R.id.singupp)
//recebe intebt
        logtxt.setText(getIntent().getStringExtra("gotup"))
        //country spinner
        val countriesAll = resources.getStringArray(R.array.countriesAll)//access countriesAll arry Items
        if(cu != null){
            val adapter = ArrayAdapter(
                this,android.R.layout.simple_spinner_item,countriesAll
            )
            cu.adapter=adapter
            cu.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val te1:String = adapter.getItem(position).toString()
                    Toast.makeText(this@singup, te1, Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }


        }
        val Gender=resources.getStringArray(R.array.Gender)//access gensder array
        if(gn != null){
            val adapter = ArrayAdapter(
                this,android.R.layout.simple_spinner_item,Gender
            )
            gn.adapter=adapter
            gn.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val gan:String=adapter.getItem(position).toString()
                    Toast.makeText(this@singup, gan, Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

        al.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Read spinner Code")
                builder.setMessage("        val Gender=resources.getStringArray(R.array.Gender)//access gensder array\n" +
                        "        if(gn != null){\n" +
                        "            val adapter = ArrayAdapter(\n" +
                        "                this,android.R.layout.simple_spinner_item,Gender\n" +
                        "            )\n" +
                        "            gn.adapter=adapter\n" +
                        "            gn.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{\n" +
                        "                override fun onItemSelected(\n" +
                        "                    parent: AdapterView<*>?,\n" +
                        "                    view: View?,\n" +
                        "                    position: Int,\n" +
                        "                    id: Long\n" +
                        "                ) {\n" +
                        "                    val gan:String=adapter.getItem(position).toString()\n" +
                        "                    Toast.makeText(this@singup, gan, Toast.LENGTH_LONG).show()\n" +
                        "                }\n" +
                        "\n" +
                        "                override fun onNothingSelected(parent: AdapterView<*>?) {\n" +
                        "                    TODO(\"Not yet implemented\")\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }")

                builder.setPositiveButton("Ok"){
                    dialog, which -> dialog.cancel()
                }

               builder.setNegativeButton("No"){
                   dialog, which -> val intent = Intent(this,MainActivity::class.java)
                   startActivity(intent)
               }
                builder.show()
            }else
                Toast.makeText(this, "Uncheaked", Toast.LENGTH_SHORT).show()
        }

        ac.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show()
            }

        }

        su.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }

        }

        caa.setOnClickListener {
            pb.visibility=View.VISIBLE
            val snak = Snackbar.make(singupp,"account Created",Snackbar.LENGTH_LONG)
            snak.show()
        }





    }
}