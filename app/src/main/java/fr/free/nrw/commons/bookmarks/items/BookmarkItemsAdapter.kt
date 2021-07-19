package fr.free.nrw.commons.bookmarks.items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import fr.free.nrw.commons.R
import fr.free.nrw.commons.upload.structure.depictions.DepictedItem

class BookmarkItemsAdapter (val list: List<DepictedItem>, val context: Context) :
    RecyclerView.Adapter<BookmarkItemsAdapter.BookmarkItemViewHolder>() {

    class BookmarkItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var depictsLabel: TextView = itemView.findViewById(R.id.depicts_label)
        var description: TextView = itemView.findViewById(R.id.description)
        var depictsImage: SimpleDraweeView = itemView.findViewById(R.id.depicts_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkItemViewHolder {
        val v: View = LayoutInflater.from(context)
            .inflate(R.layout.item_depictions, parent, false)
        return BookmarkItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookmarkItemViewHolder, position: Int) {

        val depictedItem = list[position]
        holder.depictsLabel.text = depictedItem.name
        holder.description.text = depictedItem.description
        if (depictedItem.imageUrl?.isNotBlank() == true) {
            holder.depictsImage.setImageURI(depictedItem.imageUrl)
        } else {
            holder.depictsImage.setActualImageResource(R.drawable.ic_wikidata_logo_24dp)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}