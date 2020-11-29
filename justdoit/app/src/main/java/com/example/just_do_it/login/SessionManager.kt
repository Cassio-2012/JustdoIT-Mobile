package com.example.just_do_it.login


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.view.evento.Usuario

class SessionManager {


    private lateinit var prefs: SharedPreferences

    private  val PREFS_NAME = "session"

//         val ID_USER = "id_user"
//         val TOKEN = "token"

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun read(key: String, value: String?): String? {
        return prefs.getString(key, value)
    }

//        fun read(key: String, value: Long): Long? {
//            return prefs.getLong(key, value)
//        }

    fun writeUser(usuario: UserModel) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putInt("id", usuario.id!!)
            putString("nome", usuario.nome)
            putString("e-mail", usuario.email)
            putString("photo", usuario.photo)
            commit()
        }
    }

    fun loadUser(): UserModel {
        val usuario = UserModel();
        usuario.id = prefs.getInt("id", 0)
        usuario.nome = prefs.getString("nome", null)
        usuario.email = prefs.getString("e-mail", null)
        usuario.photo = prefs.getString("photo", null)

        return usuario

    }

    fun removeUser() {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            clear()
            commit()
        }
    }

    fun setDark() {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putBoolean("dark",true)
            commit()
        }
    }

    fun rmDark() {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putBoolean("dark",false)
            commit()
        }
    }

    fun checkDark(): Boolean {
        return prefs.getBoolean("dark",false)
    }

}

