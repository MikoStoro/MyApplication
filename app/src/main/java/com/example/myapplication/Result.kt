package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val statsText = findViewById<TextView>(R.id.stats_text)
        val returnBtn = findViewById<Button>(R.id.returnBtn)

        var vit: Int = intent.getIntExtra("vit", 0)
        var sta: Int = intent.getIntExtra("sta", 0)
        var wil: Int = intent.getIntExtra("wil", 0)
        var str: Int = intent.getIntExtra("str", 0)
        var dex: Int = intent.getIntExtra("dex", 0)
        var int: Int = intent.getIntExtra("int", 0)
        var agi: Int = intent.getIntExtra("agi", 0)
        var per: Int = intent.getIntExtra("per", 0)
        var swi: Int = intent.getIntExtra("swi", 0)

        var health25: Int
        var health50: Int
        var health75: Int
        var health100: Int
        var magicka: Int
        var stamina: Int
        var speed: Int
        var spirit: Int
        var block: Int
        var evade: Int
        var accuracy: Int
        var stealh: Int
        var meleeCrit: Int
        var magCrit: Int
        var ranCrit: Int
        var spellForce: Int
        var magAccuracy: Int


                   health25 = vit / 4
                   health50 = vit / 4
                   health75 = vit / 4
                   health100 = vit / 4

                   if (vit % 4 == 1) {
                       health25 += 1
                   }
                   if (vit % 4 == 2) {
                       health25 += 1
                       health75 += 1
                   }
                   if (vit % 4 == 3) {
                       health25 += 1
                       health50 += 1
                       health75 += 1
                   }

                   magicka = wil
                   stamina = sta
                   speed = swi / 2
                   evade = (2 * agi + per) / 3
                   block = (per * 2 + dex) / 3
                   stealh = agi / 2
                   accuracy = (dex * 2 + per) / 3
                   magAccuracy = (wil + int) / 2
                   spellForce = wil / 4
                   meleeCrit = int / 5 + dex / 5 + str / 5
                   ranCrit = int / 5 + dex / 5
                   magCrit = int / 4
                   spirit = (sta + wil) / 4


                   statsText.text =  """
               Zdrowie 25%:  $health25      S: ${str/4} Z: ${dex/4} I: ${int/4}
               Zdrowie 50%:  $health50      S: ${str/2} Z: ${dex/2} I: ${int/2}
               Zdrowie 75%:  $health75      S: ${(str*3)/4} Z: ${(dex*3)/4} I: ${(int*3)/4}
               Zdrowie 100%:  $health100    S: ${str} Z: ${dex} I: ${int}

               Kondycja:  $stamina
               Magia:  $magicka
               Prędkość:  $speed
               Niezłomność:  $spirit

               Blok:  $block
               Unik:  $evade
               Celność:  D: $accuracy  M: $magAccuracy
               Siła zaklęć:  $spellForce
               Ukrycie:  $stealh
               Cios krytyczny:  W: $meleeCrit  D: $ranCrit  M: $magCrit
                   """.trimIndent()

        /*
        getString(R.string.stats_display,
        health25, str/4, dex/4, int/4,
        health50, str/2, dex/2, int/2,
        health75, str*3/4, dex*3/4, int*3/4,
        health100, str, dex, int,
        stamina, magicka, speed, spirit,
        block, evade,
        accuracy, magAccuracy,
        spellForce, stealh,
        meleeCrit, ranCrit, magCrit)
         */



            returnBtn.setOnClickListener {

                val rIntent = Intent(returnBtn.context, MainActivity::class.java)

                returnBtn.context.startActivity(rIntent)
            }

           }


    }

