package org.abubaker.material101

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.abubaker.material101.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnSubmit.setOnClickListener {
            // Log.e("Submit", binding.autoCompleteTextView.text.toString())
            Toast.makeText(
                this,
                "Designer: " + binding.tvShoeDesigner.text + "\nColor: " + binding.tvShoeColor.text + "\nSize: " + binding.tvShoeSize.text,
                Toast.LENGTH_SHORT
            ).show()
        }

        setContentView(binding.root)

    }

    // Safeguard
    override fun onResume() {
        super.onResume()

        // Designer
        val designer = resources.getStringArray(R.array.shoe_designer)
        val arrayAdapterDesigner = ArrayAdapter(this, R.layout.dropdown_item, designer)
        binding.tvShoeDesigner.setAdapter(arrayAdapterDesigner)

        // Color
        val color = resources.getStringArray(R.array.shoe_colors)
        val arrayAdapterColor = ArrayAdapter(this, R.layout.dropdown_item, color)
        binding.tvShoeColor.setAdapter(arrayAdapterColor)

        // Size
        val size = resources.getStringArray(R.array.shoe_size)
        val arrayAdapterSize = ArrayAdapter(this, R.layout.dropdown_item, size)
        binding.tvShoeSize.setAdapter(arrayAdapterSize)

    }


}