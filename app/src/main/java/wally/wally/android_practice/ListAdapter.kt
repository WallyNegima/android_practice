package wally.wally.android_practice

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class ListAdapter(private val listener: MainActivity.MainListItemClickListener) :
    GroupAdapter<GroupieViewHolder>() {
    fun updateList(list: List<MainActivity.Item>) {
        update(list.map {
            TopListItem(
                text = it.text,
                itemId = it.itemId,
                listener = listener
            )
        })
    }

}