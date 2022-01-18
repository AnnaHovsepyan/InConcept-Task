package com.inconceptlabs.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import com.inconceptlabs.task.adapter.CustomAdapter
import com.inconceptlabs.task.viewModel.PersonViewModel

class MainActivity : AppCompatActivity() {
    private var adapter: CustomAdapter = CustomAdapter()
    private val personViewModel: PersonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinnerData()
        recyclerView.adapter = adapter
    }

    private fun setSpinnerData() {
        ArrayAdapter.createFromResource(
            this,
            R.array.arr,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSortBy.adapter = adapter
            spinnerSortBy.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    when (position) {
                        0 -> {
                            getPersonData()
                        }
                        1 -> {
                            getPersonOrderedData("ASC")
                        }
                        2 -> {
                            getPersonOrderedData("DESC")
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

    private fun getPersonOrderedData(sort: String) {
        personViewModel.getPersonOrderedData(sort).observe(this, {
            adapter.setItems(it.toMutableList())
            recyclerView.scrollToPosition(0)
        })
    }

    private fun getPersonData() {
        personViewModel.getPersonData().observe(this, {
            adapter.setItems(it.toMutableList())
            recyclerView.scrollToPosition(0)

        })
    }
}