package com.example.ui0113

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class EventHandlingActivity : AppCompatActivity() {
    //뷰 클래스
    //View 클래스는 매개변수가 없는 생성자가 없기 때문에
    //생성자에서 대입받아서 넘겨주어야 합니다.
    inner class MyView(context: Context?): View(context){
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_event_handling)

        //사용자 정의 뷰를 생성
        val myView = MyView(this)
        //사용자 정의 뷰를 Activity의 전체 화면으로 설정
        setContentView(myView)

        //인터페이스를 구현한 클래스를 생성
        /*
        class TouchImpl : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Toast.makeText(this@EventHandlingActivity,
                "클래스를 만들어서 구현", Toast.LENGTH_LONG).show()
                return true
            }
        }

        myView.setOnTouchListener(TouchImpl())
         */

        //anonymous class를 만들어서 처리
        /*
        myView.setOnTouchListener(object:View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Toast.makeText(this@EventHandlingActivity,
                    "익명 클래스를 만들어서 구현", Toast.LENGTH_LONG).show()
                return false
            }
        })
        */

        //SAM 방법을 이용한 이벤트 처리
        //메소드가 1개인 인터페이스인 경우만 사용 가능
        myView.setOnTouchListener({
                v:View?, event:MotionEvent? ->
            Toast.makeText(this@EventHandlingActivity,
                "SAM을 이용한 이벤트 처리", Toast.LENGTH_LONG).show()
            true
        })

    }
}