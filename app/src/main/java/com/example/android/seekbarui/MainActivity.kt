package com.example.android.seekbarui

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Intialize view to have the custom view from start : DO NOT REMOVE IT or else you will ger default thumb
         */
        seekBar.thumb  = getThumb(0)

//        val thumbView = LayoutInflater.from(this).inflate(R.layout.layout_seekbar_thumb, null, false)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBar.thumb = getThumb(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

     fun getThumb(progress : Int) : Drawable{

         val thumbView = LayoutInflater.from(this).inflate(R.layout.layout_seekbar_thumb, null, false)

         thumbView.findViewById<TextView>(R.id.tvProgress).setText("$progress%")
        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        thumbView.layout(0, 0, thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight())
        thumbView.draw(canvas)

        return BitmapDrawable(getResources(), bitmap)
    }
}
