package com.xqy.androidx.event

import java.util.concurrent.ConcurrentHashMap

internal class EventManager private constructor(){

    val mConcurrentHashMap:ConcurrentHashMap<String,EventLiveData<Any>> by lazy {
        ConcurrentHashMap<String,EventLiveData<Any>>()
    }
    companion object {
        const val TAG:String = "EventManager"
        val mInstance:EventManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            EventManager()
        }
    }

}