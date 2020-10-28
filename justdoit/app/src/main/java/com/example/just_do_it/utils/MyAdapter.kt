package com.example.vamos_lucrar.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.just_do_it.R
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.evento.DetalhesEventoActivity
import com.example.just_do_it.view.evento.ListaEventosActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var contexto: Context, var resouces: Int, var itens: List<EventoModel>,
var usuario: UserModel) :
    ArrayAdapter<EventoModel>(contexto, resouces, itens) {

    val remote = RetrofitClient.createService(EventoService::class.java)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(contexto)
        val view: View = layoutInflater.inflate(resouces, null)

        val imageView: ImageView = view.findViewById(R.id.image)
        val titleTextView: TextView = view.findViewById(R.id.textView)
        val descriptionTextView: TextView = view.findViewById(R.id.textView2)
        val deletar: ImageView = view.findViewById(R.id.deletar)
        val mais: ImageView = view.findViewById(R.id.mais)

        var mItem: EventoModel = itens[position]

       // imageView.setImageDrawable(mItem.img?.let { contexto.resources.getDrawable(it) })
        titleTextView.text = mItem.nome
        descriptionTextView.text = mItem.codigo.toString()


        deletar.setOnClickListener(View.OnClickListener {
            remove(itens[position])
        })
        mais.setOnClickListener(View.OnClickListener {
            itens[position].codigo?.let { it1 -> detalhesItem(it1) }
        })

        return view
    }

    fun remove(contato: EventoModel) {




        val codigo = contato.codigo
        val deletarContato = remote.deleteEvento(codigo, usuario.id)

        if (deletarContato != null) {
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

        super.remove(contato)

    }




    fun detalhesItem(position: Long) {
        SharedPreferences(contexto).storeId("codigo", position)

        val detalhes = Intent(contexto, DetalhesEventoActivity::class.java)

        detalhes.putExtra("email",usuario.email)
        detalhes.putExtra("nome", usuario.nome)
        detalhes.putExtra("id", usuario.id)

        contexto.startActivity(detalhes)

    }


}






