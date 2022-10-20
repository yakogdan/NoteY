package com.yakogdan.notey.app.adapters

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yakogdan.notey.R
import com.yakogdan.notey.data.database.room.entities.DbNoteEntity
import com.yakogdan.notey.databinding.ItemNoteBinding
import com.yakogdan.notey.domain.models.NoteDomain

//import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(
    private val noteList: List<NoteDomain>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNoteBinding.bind(view)

        fun bind(note: NoteDomain) = with(binding) {
            tvTitle.text = note.title
            tvSubtitle.text = note.subtitle
            tvDate.text = note.date
        }
    }

//    private val callback = object : DiffUtil.ItemCallback<DbNoteEntity>() {
//        override fun areItemsTheSame(oldItem: DbNoteEntity, newItem: DbNoteEntity): Boolean {
//            return oldItem.title == newItem.title
//        }
//
//        override fun areContentsTheSame(oldItem: DbNoteEntity, newItem: DbNoteEntity): Boolean {
//            return oldItem == newItem
//        }
//    }

//    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder =
        NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )


    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(noteList[position])
//        val note = differ.currentList[position]
//        holder.itemView
//        holder.itemView.apply {
//            tv_title.text = note.title
//            tv_subtitle.text = note.subtitle
//            tv_date.text = note.date
//            setOnClickListener {
//                onItemClickListener?.let { it(note) }
//            }
//
//            setOnLongClickListener {
//                onItemLongClickListener?.let { it(note) }
//                return@setOnLongClickListener true
//            }
//        }
    }

    override fun getItemCount(): Int {
        return noteList.size
//        return differ.currentList.size
    }

//    private var onItemClickListener: ((DbNoteEntity) -> Unit)? = null
//
//    fun setOnItemClickListener(listener: (DbNoteEntity) -> Unit) {
//        onItemClickListener = listener
//    }
//
//    private var onItemLongClickListener: ((DbNoteEntity) -> Unit)? = null
//
//    fun setOnItemLongClickListener(listener: (DbNoteEntity) -> Unit) {
//        onItemLongClickListener = listener
//    }

}