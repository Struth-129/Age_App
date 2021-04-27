package com.example.age_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view->
            clickDatePicker(view)
            Toast.makeText(this,"Select Date",Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                SelectedDate.text="$day - $month - $year"
                val in_minutes = year*360*24*60+month*30*24*60+day*24*60
                cal.text="$in_minutes"
        }
            ,year,month,day
        ).show()
    }
}
