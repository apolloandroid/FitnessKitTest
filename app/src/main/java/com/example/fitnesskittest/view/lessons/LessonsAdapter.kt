package com.example.fitnesskittest.view.lessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitnesskittest.databinding.DateItemBinding
import com.example.fitnesskittest.databinding.LessonItemBinding
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.entity.LessonType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LessonsAdapter @Inject constructor(
    @ApplicationContext private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val DATE_VIEW_TYPE = 1
    private val LESSON_VIEW_TYPE = 2

    private val items: MutableList<Item> = mutableListOf()
    private var currentDateItemItem: Item.DateItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            DATE_VIEW_TYPE -> DateViewHolder.from(inflater, parent)
            else -> LessonViewHolder.from(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DateViewHolder -> holder.bind(items[position] as Item.DateItem)
            is LessonViewHolder -> holder.bind((items[position] as Item.LessonItem), context)
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is Item.DateItem -> DATE_VIEW_TYPE
        is Item.LessonItem -> LESSON_VIEW_TYPE
    }

    override fun getItemCount(): Int = items.size

    fun setLessons(lessons: List<Lesson>) {
        lessons.forEach {
            val dateItem = it.toDateItem()
            val lessonItem = it.toLessonItem()
            if (currentDateItemItem == null) {
                currentDateItemItem = dateItem
                items.add(dateItem)
            } else {
                if (currentDateItemItem?.date != dateItem.date) {
                    currentDateItemItem = dateItem
                    items.add(dateItem)
                }
            }
            items.add(lessonItem)
        }
        notifyDataSetChanged()
    }

    class DateViewHolder(private val binding: DateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(inflater: LayoutInflater, parent: ViewGroup) =
                DateViewHolder(DateItemBinding.inflate(inflater, parent, false))
        }

        fun bind(dateItem: Item.DateItem) {
            binding.date = dateItem
        }
    }

    class LessonViewHolder(private val binding: LessonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(inflater: LayoutInflater, parent: ViewGroup) =
                LessonViewHolder(LessonItemBinding.inflate(inflater, parent, false))
        }

        fun bind(lessonItem: Item.LessonItem, context: Context) {
            binding.lesson = lessonItem
            val imageResId = ResourcesCompat.getDrawable(
                context.resources,
                lessonItem.type.imageResourceId,
                null
            )

            Glide.with(context).load(imageResId).into(binding.imgGroup)
        }
    }

    sealed class Item {
        class DateItem(val date: String) : Item()
        class LessonItem(
            val name: String?,
            val trainerName: String,
            val type: LessonType,
            val price: String
        ) : Item()
    }

    private fun Lesson.toLessonItem(): Item.LessonItem =
        Item.LessonItem(name, trainerName, type, price.toString())

    private fun Lesson.toDateItem(): Item.DateItem {
//        val dateFormat = "dd.MM.yyyy"
//        val dateFormatter = ofPattern(dateFormat).withZone(ZoneId.systemDefault())
//        val date = dateFormatter.format(Instant.parse(this.date))
        return Item.DateItem(date)
    }
}
