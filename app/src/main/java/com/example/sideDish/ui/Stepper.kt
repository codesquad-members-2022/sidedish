package com.example.sideDish.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.example.sideDish.R

class Stepper(context: Context, attrs: AttributeSet) :
    LinearLayout(context, attrs) {
    lateinit var plus: ImageButton
    lateinit var value: TextView
    lateinit var minus: ImageButton
    lateinit var orderCount: MutableLiveData<Int>

    init {
        LayoutInflater.from(context).inflate(R.layout.stepper, this, true)
        plus = findViewById(R.id.button_stepper_plus)
        value = findViewById(R.id.text_view_stepper_value)
        minus = findViewById(R.id.button_stepper_minus)

        plus.setOnClickListener {
            orderCount.value = orderCount.value?.plus(1)
        }
        minus.setOnClickListener {
            orderCount?.value = orderCount?.value?.minus(1)
        }
    }

}