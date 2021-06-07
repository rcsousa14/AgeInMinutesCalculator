package com.example.agetominutescalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnDatePicker)
        button.setOnClickListener {
            clickDatePicker()


        }
    }

    private fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDayOfMonth ->

            // this sets the dateText from the view on main
            val date = findViewById<TextView>(R.id.dateText)
            val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            date.text = selectedDate

            // this sets the minText from the view on main
            // Converts date inputs and parses it into date
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate: Date? = sdf.parse(selectedDate)
            val today = Date()
            val calc = ((today.time - theDate!!.time)/86400000)*1440
            val dob = findViewById<TextView>(R.id.minText)
            dob.text= calc.toString()

            // on (okay from DP) btn click it calls on the Toast to make sure it works
            Toast.makeText(this, "date was selected", Toast.LENGTH_LONG).show()
        }, year, month, day).show()
    }
}