package com.example.aclass

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import javax.security.auth.Subject
import kotlin.jvm.Throws


class WriteActivity : AppCompatActivity() {

    lateinit var WriteProgressLayout:RelativeLayout
    lateinit var WriteProgressBar:ProgressBar
    lateinit var edtBookName:EditText
    lateinit var edtBookAuthor:EditText
    lateinit var edtBookPrice:EditText
    lateinit var btnSaveToDrive:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        WriteProgressLayout=findViewById(R.id.WriteProgressLayout)
        WriteProgressBar=findViewById(R.id.WriteProgressBar)
        edtBookName=findViewById(R.id.edtBookName)
        edtBookAuthor=findViewById(R.id.edtBookAuthor)
        edtBookPrice=findViewById(R.id.edtBookPrice)
        btnSaveToDrive=findViewById(R.id.btnSaveToDrive)

        WriteProgressLayout.visibility= View.GONE
        WriteProgressBar.visibility=View.GONE

        btnSaveToDrive.setOnClickListener {
            if (edtBookName.text.toString().isEmpty() or edtBookAuthor.text.toString().isEmpty() or edtBookPrice.text.toString().isEmpty() ){
                Toast.makeText(this@WriteActivity, "Enter all the data", Toast.LENGTH_SHORT).show()
            }else{
                WriteProgressLayout.visibility= View.VISIBLE
                WriteProgressBar.visibility=View.VISIBLE


                val url="https://script.google.com/macros/s/AKfycbzymkwGumZsNF-BiTNKUCn4osaptcsVMzfFLreS4ujN8Cw0R3yCdP1aPcPI9DtnmQTS/exec"
                val stringRequest=object :StringRequest(Method.POST,url,
                    Response.Listener {
                        Toast.makeText(this@WriteActivity,it.toString(),Toast.LENGTH_SHORT).show()
                        WriteProgressLayout.visibility= View.GONE
                        WriteProgressBar.visibility=View.GONE
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_SHORT).show()
                        WriteProgressLayout.visibility= View.GONE
                        WriteProgressBar.visibility=View.GONE
                    }
                ){
                    @Throws(AuthFailureError::class)
                    override fun getParams(): MutableMap<String, String> {
                        val params=HashMap<String,String>()
                        params["BookName"]=edtBookName.text.toString()
                        params["BookAuthor"]=edtBookAuthor.text.toString()
                        params["BookPrice"]=edtBookPrice.text.toString()
                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRequest)
            }
        }
    }
}