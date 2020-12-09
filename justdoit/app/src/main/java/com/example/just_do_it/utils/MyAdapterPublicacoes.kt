package com.example.just_do_it.utils

import android.content.Context
import android.content.res.Resources

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.just_do_it.R
import com.example.just_do_it.login.SessionManager

import com.example.just_do_it.service.model.PostModel
import com.example.just_do_it.service.model.UserModel

import com.example.just_do_it.service.repository.remote.PostService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_detalhes_evento.*

class MyAdapterPublicacoes(var contexto: Context, var resouces: Int, var itens: List<PostModel>) :
    ArrayAdapter<PostModel>(contexto, resouces, itens) {

    val remote = RetrofitClient.createService(PostService::class.java)
    val sessionManager = SessionManager();
    val usuarioLogado = loadUser();


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(contexto)
        val view: View = layoutInflater.inflate(resouces, null)

        val foto: ImageView = view.findViewById(R.id.photoPerfil)
        val nomeUsuario: TextView = view.findViewById(R.id.nomeUsuario)
        val dataPublicacao: TextView = view.findViewById(R.id.dataPublicacao)
        val conteudo: TextView = view.findViewById(R.id.conteudo)
        val fotoPublicacao: ImageView = view.findViewById(R.id.fotoPublicacao)
        // val like: ImageView = view.findViewById(R.id.like)

        var post: PostModel = itens[position]

        var fotoPerfil = post.imagem?.let { convertImg(it) }
        if (!post.img_conteudo.isNullOrEmpty()) {
            var fotoPost = post.img_conteudo?.let { convertImg(it) }
            fotoPublicacao.visibility = View.VISIBLE
            fotoPublicacao.setImageBitmap(fotoPost)
        }

        foto.setImageDrawable(fotoPerfil?.let { roundedBitmap(it) })
        nomeUsuario.text = post.nome
        dataPublicacao.text = post.data
        conteudo.text = post.conteudo
        return view
    }

    fun loadUser(): UserModel {

        sessionManager.init(contexto)

        return sessionManager.loadUser()

    }

    //METODO PARA DECODIFICAR IMAGEM EM BASE64
    fun convertImg(foto: String): Bitmap? {
        val base64String = foto
        val base64Image = base64String?.split(",".toRegex())?.toTypedArray()?.get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    //METODO PARA AREDONDAR BORDA DA IMAGEM
    fun roundedBitmap(bitmap: Bitmap): RoundedBitmapDrawable {
        val roundedBitmapDrawable =
            RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap)
        roundedBitmapDrawable.isCircular = true
        roundedBitmapDrawable.cornerRadius = Math.max(bitmap.width, bitmap.height) / 2.0f
        return roundedBitmapDrawable

    }

/*
    fun remove(contato: EventoModel) {

        val codigo = contato.codigo
        val id = usuarioLogado.id
        val deletarContato = remote.deleteEvento(codigo, id)


            deletarContato.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    if(response.code() == 403){
                        Toast.makeText(
                            contexto, "Você não é o administrador deste evento.",
                            Toast.LENGTH_SHORT
                        ).show()
                        return
                    }

                    if(response.code() == 200){
                        Toast.makeText(
                            contexto, "Evento deletado com sucesso .",
                            Toast.LENGTH_SHORT
                        ).show()
                        remover(contato)
                    }
                }
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(
                        contexto, "Erro ao deletar",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
            })
    }




    fun detalhesItem(position: Long) {
        val detalhes = Intent(contexto, DetalhesEventoActivity::class.java)

        SharedPreferences(contexto).storeId("codigo", position)

        contexto.startActivity(detalhes)

    }
*/

}







