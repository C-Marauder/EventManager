##基于LiveData的跨组件通信框架

### 1.使用
* 在Activity或Fragment中

```

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerEvent<String>("a"){
            Toast.makeText(this, it,Toast.LENGTH_SHORT).show()
        }
    }
}

class BActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textView.setOnClickListener {
            sendEvent("a","Hello MainActivity")
        }

    }

}
```
