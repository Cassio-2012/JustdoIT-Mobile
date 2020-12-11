package com.example.just_do_it

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.service.repository.remote.UserService
import com.example.just_do_it.view.GenericActivity
import com.example.just_do_it.view.evento.DetalhesEventoActivity
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : GenericActivity() {
    val remote = RetrofitClient.createService(UserService::class.java)
    var usuarioLogado = UserModel()
    val sessionManager = SessionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        start()
        usuarioLogado = loadUser()

        var fotoPerfil = usuarioLogado.photo?.let { convertImg(it) }
        img_perfil.setImageBitmap(fotoPerfil)
        name.text = "Nome: ${usuarioLogado.nome}"
        email.text = "Email: ${usuarioLogado.email}"

    }

    override fun onResume() {
        super.onResume()
        checkDark()
    }

    fun convertImg(foto: String): Bitmap? {
        val base64String = foto
        val base64Image = base64String?.split(",".toRegex())?.toTypedArray()?.get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    //METODO PARA ARrEDONDAR BORDA DA IMAGEM
    fun roundedBitmap(bitmap: Bitmap): RoundedBitmapDrawable {
        val roundedBitmapDrawable =
                RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap)
        roundedBitmapDrawable.isCircular = true
        roundedBitmapDrawable.cornerRadius = Math.max(bitmap.width, bitmap.height) / 2.0f
        return roundedBitmapDrawable

    }

    fun loadUser(): UserModel {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)
        sessionManager.removeUser()

    }

    override fun onBackPressed() {
        super.onBackPressed()


    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if (menuItem.itemId == R.id.nav_logout) {

            val login = Intent(this, Login_activity::class.java)
            removeUser();
            startActivity(login)
            return false

        }
        if(menuItem.itemId == R.id.nav_dark) {
            chooseThemeDialog()
            return false
        }
        else {
            return super.onNavigationItemSelected(menuItem)
        }
    }

    fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Chose the Theme")
        val styles = arrayOf("Light","Dark")
        var checkedItem = 0
        if (sessionManager.checkDark()) {
            checkedItem = 1

        }

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            sessionManager.init(getApplicationContext())

            when (which) {
                0 -> {

                    changeLight()
                    sessionManager.rmDark()
                    dialog.dismiss()

                }
                1 -> {

                    changeDark()
                    sessionManager.setDark()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    fun changeLight() {


        val perfil = Intent(this, PerfilActivity::class.java)


        startActivity(perfil)

    }

    fun changeDark() {

        var scroll = findViewById<ScrollView>(R.id.scroolViewPerf)
        var tv_titulo = findViewById<TextView>(R.id.titulo)
        var tv_name = findViewById<TextView>(R.id.name)
        var tv_email = findViewById<TextView>(R.id.email)


        scroll.setBackgroundColor(Color.parseColor("#000000"))
        tv_titulo.setTextColor(Color.parseColor("#FFFFFF"))
        tv_name.setTextColor(Color.parseColor("#A9A9A9"))
        tv_email.setTextColor(Color.parseColor("#A9A9A9"))

    }


    fun checkDark() {
        sessionManager.init(getApplicationContext())

        val isdark = sessionManager.checkDark()

        if (isdark) {
            changeDark()
        }

    }

}
