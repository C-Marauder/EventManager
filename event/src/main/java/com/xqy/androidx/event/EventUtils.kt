package com.xqy.androidx.event

import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


 fun <M> AppCompatActivity.registerEvent(eventId:String,onReceive:(data:M)->Unit){

    var liveData = EventManager.mInstance.mConcurrentHashMap[eventId]
    if (liveData == null){
        liveData = MutableLiveData()
        liveData.observe(this, Observer {
            onReceive(it as M)
        })
        EventManager.mInstance.mConcurrentHashMap[eventId] = liveData
    }

}

 fun <M> Fragment.registerEvent(eventId:String,onReceive:(data:M)->Unit){

    var liveData = EventManager.mInstance.mConcurrentHashMap[eventId]
    if (liveData == null){
        liveData = MutableLiveData()
        liveData.observe(this, Observer {
            onReceive(it as M)
        })
        EventManager.mInstance.mConcurrentHashMap[eventId]=liveData

    }

}

 fun<M> sendEvent(eventId: String,data: M){
    val liveData = EventManager.mInstance.mConcurrentHashMap[eventId]
    if (liveData!=null){
        if (Looper.myLooper() == Looper.getMainLooper()){
            liveData.value = data
        }else{
            liveData.postValue(data)
        }
    }else{
        Log.e(EventManager.TAG,"$eventId is not register")
    }
}

