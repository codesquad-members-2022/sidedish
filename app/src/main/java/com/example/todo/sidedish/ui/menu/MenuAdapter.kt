package com.example.todo.sidedish.ui.menu

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.todo.sidedish.common.LruMemoryCache
import com.example.todo.sidedish.databinding.ItemHeaderBinding
import com.example.todo.sidedish.databinding.ItemMenuBinding
import com.example.todo.sidedish.domain.model.DishType
import com.example.todo.sidedish.domain.model.Header
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.domain.model.MenuItem
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

const val VIEW_TYPE_HEADER = 0
const val VIEW_TYPE_ITEM = 1

class MenuAdapter(private val itemClick: (hash: String, title: String, badges: List<String>?) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var menuItems = mutableListOf<MenuItem>()
    private lateinit var contentResolver: ContentResolver
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemHeaderBinding.inflate(inflater, parent, false))
            else -> ItemViewHolder(ItemMenuBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val item = menuItems[position] as Header
                holder.bind(item)
            }
            is ItemViewHolder -> {
                val item = menuItems[position] as Menu
                holder.bind(item, itemClick)
            }
        }
    }

    override fun getItemCount(): Int = menuItems.size

    override fun getItemViewType(position: Int): Int {
        return when (menuItems[position]) {
            is Header -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_ITEM
        }
    }

    fun submitHeaderAndItemList(
        items: Map<DishType, List<Menu>?>,
        contentResolver: ContentResolver,
        context: Context
    ) {
        val menuItems = mutableListOf<MenuItem>()
        this.contentResolver = contentResolver
        this.context = context
        items.entries.forEach { entry ->
            val header = Header(entry.key, dishCount = entry.value?.size ?: 0)
            menuItems.add(header)
            if (!entry.value.isNullOrEmpty()) menuItems.addAll(entry.value!!)
        }
        this.menuItems = menuItems
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(header: Header) {
            binding.header = header
            binding.root.setOnClickListener {
                header.visible = !header.visible
                binding.header = header
            }
            binding.executePendingBindings()
        }
    }

    inner class ItemViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
          
        fun bind(item: Menu, itemClick: (hash: String, title: String, badges: List<String>?) -> Unit) {
            binding.item = item
            binding.root.setOnClickListener {
                itemClick.invoke(item.detailHash, item.title, item.badge)
            }
            getImage(item.image)
            binding.executePendingBindings()
        }

        private fun getImage(imageUri: String) {
            var bmp = LruMemoryCache.getImageFromWarehouse(imageUri)
            if (bmp != null) {
                binding.ivMenu.setImageBitmap(bmp)
            } else {
                val loadBitmapFromDisk = getBitmapFromCache(imageUri)
                if (loadBitmapFromDisk != null) {
                    binding.ivMenu.setImageBitmap(loadBitmapFromDisk)
                    LruMemoryCache.addImageToWareHouse(imageUri, loadBitmapFromDisk)
                } else {
                    Glide.with(binding.ivMenu)
                        .asBitmap()
                        .load(imageUri)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(object :
                            CustomTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                binding.ivMenu.setImageBitmap(resource)
                                saveBitmapToCache(resource, imageUri)
                            }
                            override fun onLoadCleared(placeholder: Drawable?) {}
                        })
                }
            }
        }

        private fun getBitmapFromCache(fileName: String): Bitmap? {
            val cachePath = File(context.cacheDir.toString())
            val files = cachePath.listFiles()
            val fileKey = fileName.replace("/", "_")
            for (file in files) {
                if (file.name == fileKey) {
                    return BitmapFactory.decodeFile(file.toString())
                }
            }
            return null
        }


        private fun saveBitmapToCache(bitmap: Bitmap, name: String) {
            val cachePath = context.cacheDir
            val fileName = name.replace("/", "_")
            val tempFile = File(cachePath, fileName)
            try {
                tempFile.createNewFile()
                val out = FileOutputStream(tempFile)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                out.close()
            } catch (e: FileNotFoundException) {
                Log.e(ContentValues.TAG, "FileNotFoundException: ${e.message}")
            } catch (e: IOException) {
                Log.e(ContentValues.TAG, "IOException: ${e.message}")
            }
        }
    }
}
