package nsu.leorita.recycler.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import nsu.leorita.recycler.R
import nsu.leorita.recycler.ui.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            add(R.id.fragment_container, ListFragment.getInstance())
        }
    }
}