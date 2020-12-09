package com.junga.socketio_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel
import kotlinx.android.synthetic.main.activity_entrance.*
import org.jetbrains.anko.startActivity

class EntranceActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        button.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
            when(p0?.id){
                R.id.button -> enterChatroom()
            }
    }

    private fun enterChatroom(){
        val user:SessionManager = SessionManager();
        var usuario:UserModel;
        usuario = user.loadUser()
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
}
