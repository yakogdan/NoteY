package com.yakogdan.notey.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yakogdan.notey.R
import com.yakogdan.notey.databinding.ItemNoteBinding
import com.yakogdan.notey.domain.entities.NoteDomainEntity


class NotesAdapter(
    private var onItemClickListener: (NoteDomainEntity) -> Unit,
    private var onItemLongClickListener: (NoteDomainEntity) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNoteBinding.bind(view)

        fun bind(note: NoteDomainEntity) {
            binding.apply {
                tvTitle.text = note.title
                tvSubtitle.text = note.subtitle
                tvDate.text = note.date
                root.setOnClickListener {
                    onItemClickListener(note)
                }

                root.setOnLongClickListener {
                    onItemLongClickListener(note)
                    return@setOnLongClickListener true
                }
            }
        }
    }

    private val callback = object : DiffUtil.ItemCallback<NoteDomainEntity>() {
        override fun areItemsTheSame(oldItem: NoteDomainEntity, newItem: NoteDomainEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteDomainEntity, newItem: NoteDomainEntity): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, callback)

    fun setData(notes: List<NoteDomainEntity>) {
        differ.submitList(notes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = differ.currentList[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setOnItemClickListener(listener: (NoteDomainEntity) -> Unit) {
        onItemClickListener = listener
    }


    fun setOnItemLongClickListener(listener: (NoteDomainEntity) -> Unit) {
        onItemLongClickListener = listener
    }
}

