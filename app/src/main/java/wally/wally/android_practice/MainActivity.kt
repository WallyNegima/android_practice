package wally.wally.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import wally.wally.android_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = GroupAdapter<GroupieViewHolder>()
        binding.recyclerView.adapter = adapter
        binding.lifecycleOwner = this
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.update((1..30).map { TopListItem("テストボタン${it}") })
        adapter.add(TopListItem("テストボタンファイナル"))

        binding.fab.setOnClickListener {
            // TODO: code
        }
    }
}
