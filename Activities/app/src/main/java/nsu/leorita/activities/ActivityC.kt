package nsu.leorita.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        val button = findViewById<AppCompatButton>(R.id.button)
        val intent = Intent(this, MainActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }
    }
}