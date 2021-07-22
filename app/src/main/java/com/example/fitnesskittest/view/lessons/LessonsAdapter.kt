package com.example.fitnesskittest.view.lessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitnesskittest.R
import com.example.fitnesskittest.databinding.DateItemBinding
import com.example.fitnesskittest.databinding.LessonItemBinding
import com.example.fitnesskittest.model.entity.Lesson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class LessonsAdapter @Inject constructor(
    @ApplicationContext private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val DATE_VIEW_TYPE = 1
    private val LESSON_VIEW_TYPE = 2

    private val items: MutableList<Item> = mutableListOf()
    private var currentDateItem: Item.DateItem? = null

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

    fun setLessons(lessons: List<Lesson>?) {
        items.clear()
        lessons?.let {
            it.forEach { lesson ->
                val dateItem = lesson.toDateItem()
                val lessonItem = lesson.toLessonItem()
                currentDateItem?.let { currentDateItem ->
                    if (currentDateItem.date != dateItem.date) {
                        this.currentDateItem = dateItem
                        items.add(dateItem)
                    }
                } ?: run {
                    currentDateItem = dateItem
                    items.add(dateItem)
                }
                items.add(lessonItem)
            }
            notifyDataSetChanged()
        } ?: return
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
            binding.tvLessonPrice.text = context.getString(R.string.price, lessonItem.price)
            val imageResId = getImageResId(lessonItem.type, context)

            Glide.with(context).load(imageResId).into(binding.imgGroup)
        }

        private fun getImageResId(lessonType: String, context: Context) = when (lessonType) {
            Lesson.TYPE_GROUP -> {
                ResourcesCompat.getDrawable(context.resources, R.drawable.ic_lesson_group, null)
            }

            else -> {
                ResourcesCompat.getDrawable(context.resources, R.drawable.ic_lesson_personal, null)
            }
        }
    }

    sealed class Item {
        class DateItem(val date: String) : Item()

        class LessonItem(
            val name: String?,
            val trainerName: String,
            val type: String,
            val price: Int
        ) : Item()
    }

    private fun Lesson.toLessonItem() = Item.LessonItem(name, trainerName, type, price)

    private fun Lesson.toDateItem(): Item.DateItem {
        val currentDate = LocalDate.parse(this.date)
        val targetDateFormat = "dd.MM.yyyy"
        val formatter = DateTimeFormatter.ofPattern(targetDateFormat)
        val targetDate = currentDate.format(formatter)
        return Item.DateItem(targetDate)
    }
}
