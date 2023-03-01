package com.maatp.moveandassemblethepyramid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val imgRingOfPyramide = listOf<Int>(R.drawable.piramide_1, R.drawable.piramide_2,
    R.drawable.piramide_3, R.drawable.piramide_4,R.drawable.piramide_5)
    val stateOfRings = mutableListOf(4,0,2,3,1)
    val arrayOfImgView = mutableListOf<ImageView>()
    var firstClickRing = -1
    var temp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewWhatToDo = findViewById<TextView>(R.id.textViewWhatToDo)
        arrayOfImgView.add(findViewById(R.id.imageView))
        arrayOfImgView.add(findViewById(R.id.imageView2))
        arrayOfImgView.add(findViewById(R.id.imageView3))
        arrayOfImgView.add(findViewById(R.id.imageView4))
        arrayOfImgView.add(findViewById(R.id.imageView5))
        for (i in 0..4) arrayOfImgView[i].setImageResource(imgRingOfPyramide[stateOfRings[i]])
        for (i in 0..4){

            arrayOfImgView[i].setOnClickListener {
                if (firstClickRing == -1) firstClickRing = i
                else {
                    temp = stateOfRings[i]
                    stateOfRings[i] = stateOfRings[firstClickRing]
                    stateOfRings[firstClickRing] = temp
                    firstClickRing = -1
                }
                for (ii in 0..4) arrayOfImgView[ii].setImageResource(imgRingOfPyramide[stateOfRings[ii]])
                if (stateOfRings == listOf(0,1,2,3,4)) textViewWhatToDo.text = "Cool!!! You Win!!!"

            }
        }



    }
}