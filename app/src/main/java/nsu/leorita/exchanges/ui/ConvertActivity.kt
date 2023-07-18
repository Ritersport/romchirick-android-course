package nsu.leorita.exchanges.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nsu.leorita.exchanges.databinding.ActivityConvertBinding

class ConvertActivity: AppCompatActivity(   ) {
    private var _binding: ActivityConvertBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityConvertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            onConvertButtonClick()
        }
        binding.currencyTextView.text = intent.getStringExtra("currencyName")
    }

    private fun onConvertButtonClick() {
        binding.convertedTextView.text = ""
        if (!binding.valueEditText.text.isEmpty()) {
            binding.convertedTextView.text = (binding.valueEditText.text.toString()
                .toFloat() / intent.getFloatExtra("currencyValue", 0F)).toString()
        }
    }

}