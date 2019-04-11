# 基于LiveData的跨组件通信框架

[ ![Download](https://api.bintray.com/packages/xqy/maven/event/images/download.svg?version=1.0.1) ](https://bintray.com/xqy/maven/event/1.0.1/link)

## 依赖

`implementation 'com.xqy.androidx.event:event:1.0.0'`

## 1.使用

```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener {
            startActivity(Intent(this,BActivity::class.java))
        }
        registerEvent<String>("a"){
            Log.e("==","=====")
            textView.text = it
            textView.textSize = 24f
        }
    }
}

class BActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_activity)
        textView.setOnClickListener {
            sendEvent("a","Hello MainActivity")
        }

    }

}
```
<img src="https://github.com/xqy666666/EventManager/blob/master/event.gif" width="200" height="400" alt="状态监听"/>

