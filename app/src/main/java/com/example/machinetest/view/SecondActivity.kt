package com.example.machinetest.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import com.example.machinetest.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    var number:Double=0.0
    var checknumber:Boolean=false
    lateinit var gl:GridLayout
    //lateinit var btnsubmit:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        gl = GridLayout(this)
        /* gl.setLayoutParams(
            GridLayout.LayoutParams(
                GridLayout.LayoutParams.MATCH_PARENT,
                GridLayout.LayoutParams.MATCH_PARENT
            )
        )
        gl.setOrientation(0)*/


        btnsubmit.setOnClickListener {
            var num = etnumber.text.toString()
            number = num.toDouble()
            Math.sqrt(number)
            checknumber = checkPerfectSquare(number)
            if (checknumber == true) {
               /* gl.setColumnCount(3)
                gl.setRowCount(3)
                gl.addView()*/
                Toast.makeText(this,"strat",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"stop",Toast.LENGTH_SHORT).show()
            }

            /* // Used to save exist password element count.
            var existPasswordRowNumber = 0
            // Get all GridLayout child count.
            var childCount = gl.getChildCount();
            // Loop all the GridLayout child.
            for (i in 0 until childCount)
            {
                // If one child is EditText type.
                val child = gl.getChildAt(i);
                if(child is EditText)
                {
                    // Get it's input type.
                    val editText =child
                    val inputType = editText.getInputType();
                    // If the edit text input type is password. The real value is 129 which is InputType.TYPE_TEXT_VARIATION_PASSWORD + 1.
                    if(inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD + 1)
                    {
                        // Exist password row number plus 1.
                        existPasswordRowNumber++;
                    }
                }
            }
            // Create a text view component.
            val passwordTextView = TextView(this);
            // Set password label text value.
            passwordTextView.setText("Password " + existPasswordRowNumber + ":");
            // Create a edit text component.
            val passwordEditText = EditText(this);
            // Set edit text input type to password.
            passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD + 1);
            // Set edit text size to 10 ems.
            passwordEditText.setEms(10);
            // Insert password label at last third position.
            gl.addView(passwordTextView, childCount - 2);
            // Recalculate gridlayout child count again.
            childCount = gl.getChildCount();
            // Insert password input box at last third position again.
            gl.addView(passwordEditText, childCount - 2);

        }*/
        }
    }
    fun checkPerfectSquare(number:Double):Boolean{
        //Square Root of Number
        val sq= Math.sqrt(number)

        //Floor value, nearest Integer Part  floor(983.2) = 983
        val f = Math.floor(sq)

        return sq==f
    }
}