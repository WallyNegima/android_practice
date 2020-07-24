package wally.wally.android_practice.views.viewA

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import wally.wally.android_practice.R
import wally.wally.android_practice.databinding.ActivityViewABinding

class ViewAActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_a)
        binding.lifecycleOwner = this
    }
}