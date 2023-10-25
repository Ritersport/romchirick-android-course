package nsu.leorita.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<AppCompatButton>(R.id.button)
        val intent = Intent(this, ActivityB::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }
    }
}