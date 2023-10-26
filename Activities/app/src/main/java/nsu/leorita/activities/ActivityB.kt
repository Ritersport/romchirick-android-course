package nsu.leorita.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        findViewById<AppCompatButton>(R.id.button).setOnClickListener {
            startActivity(intent(this))
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, ActivityC::class.java)
        }
    }
}