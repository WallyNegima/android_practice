package wally.wally.android_practice

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import wally.wally.android_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val VIEW_A = "viewA"
        const val VIEW_B = "viewB"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = ListAdapter(object : MainListItemClickListener {
            override fun onItemClick(itemId: String) {
                itemClickHandler(itemId)
            }
        })

        binding.recyclerView.adapter = adapter
        binding.lifecycleOwner = this
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            Item("ViewAへ", VIEW_A), Item("ViewBへ", VIEW_B)
        )
        adapter.updateList(itemList)

        binding.fab.setOnClickListener {
            // TODO: code
        }
    }

    private fun itemClickHandler(itemId: String) {
        println(itemId)
    }

    inner class Item(val text: String, val itemId: String)

    interface MainListItemClickListener {
        fun onItemClick(
            itemId: String
        )
    }
}
