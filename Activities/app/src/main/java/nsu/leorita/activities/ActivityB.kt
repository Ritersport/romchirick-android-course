package nsu.leorita.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val button = findViewById<AppCompatButton>(R.id.button)
        val intent = Intent(this, ActivityC::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }
    }
}