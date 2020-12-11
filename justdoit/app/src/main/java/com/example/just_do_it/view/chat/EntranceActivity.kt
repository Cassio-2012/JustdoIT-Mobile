package com.junga.socketio_android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.just_do_it.R
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel
import kotlinx.android.synthetic.main.activity_entrance.*
import org.jetbrains.anko.startActivity

class EntranceActivity : AppCompatActivity(), View.OnClickListener {


    val sessionManager = SessionManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        button.setOnClickListener(this)


    }

    override fun onResume() {
        super.onResume()
        checkDark()
    }


    override fun onClick(p0: View?) {
            when(p0?.id){
                R.id.button -> enterChatroom()
            }
    }

    private fun enterChatroom(){
//        val user:SessionManager = SessionManager();
        var usuario:UserModel;
        sessionManager.init(getApplicationContext())
        usuario = sessionManager.loadUser()
        val userName = usuario.nome
        val roomName = roomname.text.toString()


        if(!roomName.isNullOrBlank()&&!userName.isNullOrBlank()) {
            startActivity<ChatRoomActivity>(
                "userName" to userName,
                "roomName" to roomName
            )
        }else{
            Toast.makeText(this,"Nickname and Roomname should be filled!",Toast.LENGTH_SHORT)
        }
    }

    fun changeDark() {

        val layout = findViewById<ConstraintLayout>(R.id.layout_entrance)
        val tv_sala = findViewById<TextView>(R.id.textView2)
        val tv_room = findViewById<TextView>(R.id.roomname)
        val btn_room = findViewById<TextView>(R.id.button)

        layout.setBackgroundColor(Color.parseColor("#000000"))
        tv_sala.setTextColor(Color.parseColor("#ffffff"))
        tv_room.setTextColor(Color.parseColor("#ffffff"))
        btn_room.setTextColor(Color.parseColor("#ffffff"))



    }

    fun checkDark() {
        sessionManager.init(getApplicationContext())

        val isdark = sessionManager.checkDark()

        if (isdark) {
            changeDark()
        }

    }


}
