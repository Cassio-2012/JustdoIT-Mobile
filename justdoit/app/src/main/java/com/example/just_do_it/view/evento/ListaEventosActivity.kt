package com.example.just_do_it.view.evento

import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.GenericActivity
import com.example.vamos_lucrar.utils.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaEventosActivity : GenericActivity() {
    val remote = RetrofitClient.createService(EventoService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_eventos)
        start()
        val listaEventos = remote.listarEventos()
        listaEventos.enqueue(object : Callback<List<EventoModel>> {
            override fun onResponse(
                call: Call<List<EventoModel>>,
                response: Response<List<EventoModel>>
            ) {

                val listView = findViewById<ListView>(R.id.listView)
                val list = mutableListOf<EventoModel>()

                response.body()?.forEach {
                    list.add(
                        EventoModel(
                            it.codigo,
                            it.nome,
                            it.cep,
                            it.logradouro,
                            it.complemento,
                            it.bairro,
                            it.localidade,
                            it.uf,
                            it.dataEvento,
                            it.horario,
                            it.descricao

                        )
                    )
                    listView.adapter = MyAdapter(this@ListaEventosActivity, R.layout.row, list)

                }
            }


            override fun onFailure(call: Call<List<EventoModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "erro ao listar contatos ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })


    }

    override fun onBackPressed() {
        super.onBackPressed()


    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return super.onNavigationItemSelected(menuItem)
    }


}