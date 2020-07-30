package com.paul9834.alcoholapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.paul9834.alcoholapp.AppDataBase
import com.paul9834.alcoholapp.R
import com.paul9834.alcoholapp.data.model.DataSourceImpl
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.domain.RepoImpl
import com.paul9834.alcoholapp.ui.adapter.MainAdapter
import com.paul9834.alcoholapp.ui.viewmodel.MainViewModel
import com.paul9834.alcoholapp.ui.viewmodel.VMFactory
import com.paul9834.alcoholapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favorite_drink.*

class FavoriteDrinkFragment : Fragment(), MainAdapter.onTragoClickListener{


    private lateinit var adapter:MainAdapter


    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSourceImpl(AppDataBase.getDatabase(requireActivity().applicationContext))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView ()
        setupObservers ()



    }

    private fun setupObservers () {

        viewModel.getTragosFavorites().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {

                    val lista = result.data.map {
                        Drink(it.tragoId,it.imagen,it.nombre,it.descripcion,it.hasAlcohol)
                    }.toMutableList()

                  /*  val lista = result.data
                    val listDrink = mutableListOf<Drink>()

                    for (drink in lista ) {
                        listDrink.add(Drink(drink.tradoId, drink.imagen,drink.nombre, drink.descripcion, drink.hasAlcohol))
                    }*/

                    adapter = MainAdapter(requireContext(), lista,this)

                    rv_lista_favoritos.adapter = adapter


                    Log.d(TAG, "onViewCreated: ${result.data}")
                }
                is Resource.Failure -> {

                }
            }
        })


    }

    private fun setupRecyclerView() {

        rv_lista_favoritos.layoutManager = LinearLayoutManager(requireContext())
        rv_lista_favoritos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))

    }

    override fun onTragoClick(drink: Drink, position: Int) {

        viewModel.deleteDrink(DrinkEntity(drink.tragoId,drink.imagen,drink.nombre,drink.descripcion,drink.hasAlcohol))

        adapter.deleteDrink(position)
        Toast.makeText(requireContext(), "Se borró el trago favorito", Toast.LENGTH_SHORT).show()



    }


}