package com.xqy.androidx.event
import androidx.lifecycle.MutableLiveData

@SuppressWarnings("WeakerAccess")
internal class EventLiveData<T>(private val eventId:String): MutableLiveData<T>() {

    override fun onInactive() {
        super.onInactive()
        EventManager.mInstance.mConcurrentHashMap.remove(eventId)
    }
}