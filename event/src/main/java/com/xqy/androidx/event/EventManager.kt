package com.xqy.androidx.event

import androidx.lifecycle.MutableLiveData
import java.util.concurrent.ConcurrentHashMap

internal class EventManager private constructor(){

    val mConcurrentHashMap:ConcurrentHashMap<String,MutableLiveData<Any>> by lazy {
        ConcurrentHashMap<String,MutableLiveData<Any>>()
    }
    companion object {
        const val TAG:String = "EventManager"
        val mInstance:EventManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            EventManager()
        }
    }

}