package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customTextWatcher = object : CustomTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                binding.actionButton.isEnabled = binding.inputEditText.text.toString().length > 2
            }
        }

        binding.actionButton.setOnClickListener {
            binding.titleTextView.text = binding.inputEditText.text
            binding.inputEditText.text?.clear()
        }

        binding.inputEditText.addTextChangedListener(customTextWatcher)
    }
}

private abstract class CustomTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(s: Editable?) = Unit

}