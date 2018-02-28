package com.example.truptimangrule.day7challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.RelativeLayout
import kotlin.math.roundToInt
import android.support.v4.view.GestureDetectorCompat
import android.util.DisplayMetrics


class MainActivity() : AppCompatActivity(), View.OnTouchListener{

    val TAG="MainActivity"
    private var xDelta: Float = 0f
    private var yDelta: Float = 0f

    var dX:Float?=null
    var dY:Float?=null

    var displaymetrics: DisplayMetrics ?=null
    var screenHight: Int?=null
   var screenWidth:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv_ball.setOnTouchListener(this)

        displaymetrics=DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        screenHight = displaymetrics?.heightPixels
        screenWidth = displaymetrics?.widthPixels
    }


    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        var action:Int = event?.action as (Int);
        var x:Float ?=v?.getX()
        var y:Float ?=v?.getY()
        var xx:Float ?=event.getRawX()
        var yy:Float ?=event.rawY
        var newX:Float?=null
        var newY:Float?=null


        if (action== MotionEvent.ACTION_DOWN) {

            dX = (x as Float) - (xx as Float)
            dY = (y as Float) - (yy as Float)

        }else if(action==MotionEvent.ACTION_MOVE) {

            newX=(xx as Float)+(dX as Float)
            newY=(yy as Float) +(dY as Float)
            if (
                    (newX <= 0 || newX >= (screenWidth as Int) -(v?.getWidth() as Int))
                    || (newY <= 0 || newY >= ((screenHight as Int)-(v?.getHeight() as Int))))
            {


            }else{
               v.setX(newX)
                v.setY(newY)
            }

        }else if(action==MotionEvent.ACTION_UP){
           // iv_ball.setImageDrawable(getDrawable(R.drawable.ic_launcher_foreground))

        }
        main.invalidate();
        return true
    }/*override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        var action:Int = event?.action as (Int);
        val x = event.rawX
        val y = event.rawY


        if (action== MotionEvent.ACTION_DOWN) {
            val lParams = v?.getLayoutParams() as RelativeLayout.LayoutParams

            xDelta = x - lParams.leftMargin
            yDelta = y - lParams.topMargin
            Toast.makeText(this, "ACTION_DOWN",Toast.LENGTH_LONG).show()

        }else if(action==MotionEvent.ACTION_MOVE) {
            val layoutParams = v?.getLayoutParams() as RelativeLayout.LayoutParams
            layoutParams.leftMargin = x.roundToInt() - xDelta.roundToInt()
            layoutParams.topMargin = y.roundToInt() - yDelta.roundToInt()


            Log.d(TAG," "+layoutParams.leftMargin+" "+layoutParams.rightMargin+" "+layoutParams.topMargin+" "+layoutParams.bottomMargin)

            if(layoutParams.leftMargin>0 && layoutParams.topMargin>0  ){
                v.setLayoutParams(layoutParams)
            }

        }else if(action==MotionEvent.ACTION_UP){
           // iv_ball.setImageDrawable(getDrawable(R.drawable.ic_launcher_foreground))

        }
        main.invalidate();
        return true
    }*/


}

