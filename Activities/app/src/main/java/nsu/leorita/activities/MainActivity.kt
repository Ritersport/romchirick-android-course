package nsu.leorita.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.button).setOnClickListener {
            startActivity(intent(this))
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, ActivityB::class.java)
        }
    }
}