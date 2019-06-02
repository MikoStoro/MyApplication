package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var vit: Int
        var sta: Int
        var wil: Int
        var str: Int
        var dex: Int
        var int: Int
        var agi: Int
        var per: Int
        var swi: Int

        val editVit = findViewById<EditText>(R.id.vit_edit)
        val editSta = findViewById<EditText>(R.id.sta_edit)
        val editWil = findViewById<EditText>(R.id.wil_edit)
        val editStr = findViewById<EditText>(R.id.str_edit)
        val editDex = findViewById<EditText>(R.id.dex_edit)
        val editInt = findViewById<EditText>(R.id.int_edit)
        val editAgi = findViewById<EditText>(R.id.agi_edit)
        val editPer = findViewById<EditText>(R.id.per_edit)
        val editSwi = findViewById<EditText>(R.id.swi_edit)

        val calculate = findViewById<Button>(R.id.calculateBtn)
        val reset = findViewById<Button>(R.id.resetBtn)


        fun reset() {
            editVit.setText("")
            editSta.setText("")
            editWil.setText("")
            editStr.setText("")
            editDex.setText("")
            editInt.setText("")
            editAgi.setText("")
            editPer.setText("")
            editSwi.setText("")
        }

        reset()



        calculate.setOnClickListener {

            if (
                editVit.text.isNullOrEmpty() ||
                editSta.text.isNullOrEmpty() ||
                editWil.text.isNullOrEmpty() ||
                editStr.text.isNullOrEmpty() ||
                editDex.text.isNullOrEmpty() ||
                editInt.text.isNullOrEmpty() ||
                editAgi.text.isNullOrEmpty() ||
                editPer.text.isNullOrEmpty() ||
                editSwi.text.isNullOrEmpty()
            ) {

                toast("Wprowadź wsystkie Atrybuty postaci!")
            } else {
                vit = Integer.parseInt(editVit.getText().toString())
                sta = Integer.parseInt(editSta.getText().toString())
                wil = Integer.parseInt(editWil.getText().toString())
                str = Integer.parseInt(editStr.getText().toString())
                dex = Integer.parseInt(editDex.getText().toString())
                int = Integer.parseInt(editInt.getText().toString())
                agi = Integer.parseInt(editAgi.getText().toString())
                per = Integer.parseInt(editPer.getText().toString())
                swi = Integer.parseInt(editSwi.getText().toString())


                val intent = Intent(calculate.context, Result::class.java)

                intent.putExtra("vit", vit)
                intent.putExtra("sta", sta)
                intent.putExtra("wil", wil)
                intent.putExtra("str", str)
                intent.putExtra("dex", dex)
                intent.putExtra("int", int)
                intent.putExtra("agi", agi)
                intent.putExtra("per", per)
                intent.putExtra("swi", swi)


                calculate.context.startActivity(intent)
            }
        }
            reset.setOnClickListener {
            reset()
            toast("Atrybuty zresetowane")
        }
    }
}

