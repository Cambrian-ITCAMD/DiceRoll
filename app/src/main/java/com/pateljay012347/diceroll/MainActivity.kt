package com.pateljay012347.diceroll

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener,
    AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    private var result1 = 0
    private var result2 = 0

    private lateinit var spinnerValues: ArrayAdapter<String>
    private lateinit var resultTextView1: TextView
    private lateinit var resultTextView2: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton1 = findViewById<Button>(R.id.roll_Button1)
        val rollButton2 = findViewById<Button>(R.id.roll_Button2)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val customValue = findViewById<EditText>(R.id.customValue)
        val addButton = findViewById<Button>(R.id.addButton)

        resultTextView1 = findViewById(R.id.result1)
        resultTextView2 = findViewById(R.id.result2)

        spinnerValues = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
        spinnerValues.add("4")
        spinnerValues.add("6")
        spinnerValues.add("8")
        spinnerValues.add("10")
        spinnerValues.add("12")
        spinnerValues.add("20")
        spinner.adapter = spinnerValues


        addButton.setOnClickListener {
            var isValueInAdapter = false
            var newValve = customValue.text.toString()

            for (i in 0 until spinnerValues.count) {
                if (spinnerValues.getItem(i) == newValve) {
                    isValueInAdapter = true
                    break
                }
            }
            if (isValueInAdapter) {
                Log.i("spinner", "Dice already has this value")
                customValue.text.clear()
            } else {
                spinnerValues.add(newValve)
                customValue.text.clear()
            }
        }
        rollButton1.setOnClickListener {
            val sides = spinner.selectedItem.toString().toInt()
            val result1 = ((Math.random() * sides) + 1).toInt()
            resultTextView1.text = result1.toString()
            resultTextView2.text = "Not Rolled"
        }
        rollButton2.setOnClickListener {
            val sides = spinner.selectedItem.toString().toInt()
            val result1 = ((Math.random() * sides) + 1).toInt()
            val result2 = ((Math.random() * sides) + 1).toInt()
            resultTextView1.text = result1.toString()
            resultTextView2.text = result2.toString()
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    /**
     *
     * Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.
     *
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.i("Spinner", spinnerValues.getItem(position).toString())
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     *
     *
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked (this
     * will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    /**
     * Callback method to be invoked when an item in this view has been
     * clicked and held.
     *
     * Implementers can call getItemAtPosition(position) if they need to access
     * the data associated with the selected item.
     *
     * @param parent The AbsListView where the click happened
     * @param view The view within the AbsListView that was clicked
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     *
     * @return true if the callback consumed the long click, false otherwise
     */
    override fun onItemLongClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long,
    ): Boolean {
        TODO("Not yet implemented")
    }
}