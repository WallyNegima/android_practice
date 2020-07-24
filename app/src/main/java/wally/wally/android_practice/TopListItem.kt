package wally.wally.android_practice

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import wally.wally.android_practice.databinding.ItemTopListBinding

class TopListItem(
    private val text: String,
    private val itemId: String,
    private val listener: MainActivity.MainListItemClickListener
) : BindableItem<ItemTopListBinding>() {
    override fun getLayout() = R.layout.item_top_list

    override fun bind(viewBinding: ItemTopListBinding, position: Int) {
        viewBinding.button.text = text
        viewBinding.button.setOnClickListener {
            listener.onItemClick(
                itemId = itemId
            )
        }
    }

    override fun initializeViewBinding(view: View): ItemTopListBinding {
        return ItemTopListBinding.bind(view)
    }
}