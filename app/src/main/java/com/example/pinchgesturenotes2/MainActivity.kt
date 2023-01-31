package com.example.pinchgesturenotes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

var scale: Float = 1.0f
lateinit var mika : ImageView
lateinit var pinchCheck: ScaleGestureDetector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mika = findViewById(R.id.mika_image)
        pinchCheck = ScaleGestureDetector(this, ScaleListener())
    }

    class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
                    scale*= detector.scaleFactor
                    scale = Math.max(0.1f, Math.min(scale, 5.0f))
                    mika.scaleX = scale
                    mika.scaleY = scale
                    return true
                }
        }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        pinchCheck.onTouchEvent(event!!)
        return super.onTouchEvent(event)
    }


}