package com.example.todo.sidedish.common

import android.graphics.Bitmap
import android.util.Log
import android.util.LruCache

class LruMemoryCache {
   lateinit var imageWarehouse: LruCache<String,Bitmap>

    fun initializeCache(){
        val maxMemory= (Runtime.getRuntime().maxMemory()/1024)
        val cacheSize = (maxMemory/8).toInt()
        Log.d("Cache", "$cacheSize")

        imageWarehouse = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String?, value: Bitmap): Int {
                val bitmapByteCount = value.rowBytes * value.height
                return bitmapByteCount / 1024
            }
        }

    }

    fun addImageToWareHouse(key:String, value:Bitmap){
        if(imageWarehouse.get(key)==null){
            imageWarehouse.put(key,value)
        }
    }

    fun getImageFromWarehouse(key:String):Bitmap?{
        return if(imageWarehouse.get(key)!=null){
            imageWarehouse.get(key)
        } else{
            null
        }
    }

    fun removeImageFromWarehouse(key:String){
        if(imageWarehouse.get(key)!=null) {
            imageWarehouse.remove(key)
        }
    }

    fun clearCache(){
        imageWarehouse.evictAll()
    }

}