package com.example.sendnotifications

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.))

        findViewById<Button>(R.id.button).setOnClickListener { _ ->
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->

                if(!task.isSuccessful) {

                    return@OnCompleteListener
                }

                val token = task.result

                Toast.makeText(baseContext,token,Toast.LENGTH_LONG).show()

                var clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text",token)
                clipboardManager.setPrimaryClip(clipData)

            })
        }

        findViewById<Button>(R.id.button2).setOnClickListener { _ ->
            val intent = Intent(this, WebView::class.java)
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { _ ->
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->

                if(!task.isSuccessful) {
                    return@OnCompleteListener
                }

                val token = task.result
                Toast.makeText(baseContext,token, Toast.LENGTH_LONG).show()
                var clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text",token)
                clipboardManager.setPrimaryClip(clipData)

            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
       // menuInflater.inflate(androidx.core.R.menu.example_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
           // R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}