package com.example.aclass

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import javax.security.auth.Subject


class WriteActivity : AppCompatActivity() {

    lateinit var WritePogressLayout:RelativeLayout
    lateinit var WriteProgressBar:ProgressBar
    lateinit var edtEnterName:EditText
    lateinit var edtEmail:EditText
    lateinit var edtSubject:EditText
    lateinit var edtDateOfClasss:EditText
    lateinit var btnSaveToDrive:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        WritePogressLayout=findViewById(R.id.WritePogressLayout)
        WriteProgressBar=findViewById(R.id.WriteProgressBar)
        edtEnterName=findViewById(R.id.edtEnterName)
        edtEmail=findViewById(R.id.edtEmail)
        edtSubject=findViewById(R.id.edtSubject)
        edtDateOfClasss=findViewById(R.id.edtDateOfClasss)
        btnSaveToDrive=findViewById(R.id.btnSaveToDrive)

        WritePogressLayout.visibility= View.GONE
        WriteProgressBar.visibility=View.GONE

        btnSaveToDrive.setOnClickListener {
            if (edtEnterName.text.toString().isEmpty() or edtEmail.text.toString().isEmpty() or edtSubject.text.toString().isEmpty() or edtDateOfClasss.text.toString().isEmpty()){
                Toast.makeText(this@WriteActivity, "Enter all the data", Toast.LENGTH_SHORT).show()
            }else{
                val url=""
                val stringRequest=object :StringRequest(Request.Method.POST,url,
                    Response.Listener {
                                      Toast.makeText(this@WriteActivity,it,toString(),Toast.LENGTH_SHORT).show
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity,it,toString(),Toast.LENGTH_SHORT).show
                    }){
                    override fun getParams(): MutableMap<String, String>? {
                        val paramas=HashMap<String,String>()
                        paramas["EnterName"]=edtEnterName.text.toString()
                        paramas["Email"]=edtEmail.text.toString()
                        paramas["Subject"]=edtSubject.text.toString()
                        paramas["DateOfClass"]=edtDateOfClasss.text.toString()
                        return params
                    }
                }
                val queue= Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRequest)
            }
        }
    }
}