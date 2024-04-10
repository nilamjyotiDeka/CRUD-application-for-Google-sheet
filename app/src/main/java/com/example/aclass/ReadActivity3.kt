package com.example.aclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class ReadActivity3 : AppCompatActivity() {

    lateinit var readProgressLayout: RelativeLayout
    lateinit var ReadProgressBar: ProgressBar
    lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sheet3_read)

        readProgressLayout = findViewById(R.id.ReadProgressLayout)
        ReadProgressBar = findViewById(R.id.ReadProgressBar)
        tableLayout = findViewById(R.id.tableLayout)

        fetchData()
    }

    private fun fetchData() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://script.google.com/macros/s/AKfycbxeapCz_6t-Je2sI90fc0sjGsWeTag_umfXt8CFxj-tSST49i6zfvYM__eMzDEOQnr71g/exec"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                readProgressLayout.visibility = View.GONE
                ReadProgressBar.visibility = View.GONE

                if (response.has("MobileList")) {
                    val data = response.getJSONArray("MobileList")
                    for (i in 0 until data.length()) {
                        val bookJsonObject = data.getJSONObject(i)
                        val itemName = bookJsonObject.optString("itemName", "")
                        val itemCompany = bookJsonObject.optString("itemCompany", "")
                        val itemPrice = bookJsonObject.optString("itemPrice", "")

                        addRowToTable(itemName, itemCompany, itemPrice)
                    }
                } else {
                    Toast.makeText(this@ReadActivity3, "No Mobile list found in response", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                readProgressLayout.visibility = View.GONE
                ReadProgressBar.visibility = View.GONE
                Toast.makeText(this@ReadActivity3, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(jsonObjectRequest)
    }

    private fun addRowToTable(itemName: String, itemCompany: String, itemPrice: String) {
        val tableRow = TableRow(this)

        val weight = 2f
        val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weight)

        // Create a drawable for cell border
        val cellBorderDrawable = resources.getDrawable(R.drawable.cell_border)

        val textView1 = TextView(this)
        textView1.layoutParams = params
        textView1.text = itemName
        textView1.setPadding(10, 10, 10, 10)
        textView1.textSize = 14f
        textView1.gravity = Gravity.CENTER
        textView1.background = cellBorderDrawable // Set border drawable as background

        val textView2 = TextView(this)
        textView2.layoutParams = params
        textView2.text = itemCompany
        textView2.setPadding(10, 10, 10, 10)
        textView2.textSize = 14f
        textView2.gravity = Gravity.CENTER
        textView2.background = cellBorderDrawable // Set border drawable as background

        val textView3 = TextView(this)
        textView3.layoutParams = params
        textView3.text = itemPrice
        textView3.setPadding(10, 10, 10, 10)
        textView3.textSize = 14f
        textView3.gravity = Gravity.CENTER
        textView3.background = cellBorderDrawable // Set border drawable as background

        tableRow.addView(textView1)
        tableRow.addView(textView2)
        tableRow.addView(textView3)

        tableLayout.addView(tableRow)
    }

}
