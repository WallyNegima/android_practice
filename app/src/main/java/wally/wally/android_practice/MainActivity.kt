package wally.wally.android_practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import wally.wally.android_practice.databinding.ActivityMainBinding
import wally.wally.android_practice.views.viewA.ViewAActivity
import wally.wally.android_practice.views.viewB.ViewBActivity

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
        when (itemId) {
            VIEW_A -> {
                val intent = Intent(this, ViewAActivity::class.java)
                startActivity(intent)
            }
            VIEW_B -> {
                val intent = Intent(this, ViewBActivity::class.java)
                startActivity(intent)
            }
        }
    }

    inner class Item(val text: String, val itemId: String)

    interface MainListItemClickListener {
        fun onItemClick(
            itemId: String
        )
    }
}
