package com.example.just_do_it

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.just_do_it.service.model.PostModel

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    val foto: ImageView = view.findViewById(R.id.photoPerfil)
    val nomeUsuario: TextView = view.findViewById(R.id.nomeUsuario)
    val dataPublicacao: TextView = view.findViewById(R.id.dataPublicacao)
    val conteudo: TextView = view.findViewById(R.id.conteudo)
    val fotoPublicacao: ImageView = view.findViewById(R.id.fotoPublicacao)
    // val like: ImageView = view.findViewById(R.id.like)

    fun bind(item: PostModel) {

        var fotoPerfil = item.imagem?.let { convertImg(it)?.let { roundedBitmap(it) } }

        if (!item.img_conteudo.isNullOrEmpty()) {
            var fotoPost = item.img_conteudo?.let { convertImg(it) }
            fotoPublicacao.visibility = View.VISIBLE
            fotoPublicacao.setImageBitmap(fotoPost)
        }

        foto.setImageDrawable(fotoPerfil)
        nomeUsuario.text = item.nome
        dataPublicacao.text = item.data
        conteudo.text = item.conteudo

    }


    fun convertImg(foto: String): Bitmap? {
        val base64String = foto
        val base64Image = base64String?.split(",".toRegex())?.toTypedArray()?.get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    fun roundedBitmap(bitmap: Bitmap): RoundedBitmapDrawable {
        val roundedBitmapDrawable =
            RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap)
        roundedBitmapDrawable.isCircular = true
        roundedBitmapDrawable.cornerRadius = Math.max(bitmap.width, bitmap.height) / 3.0f
        return roundedBitmapDrawable

    }
}