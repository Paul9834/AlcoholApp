package com.paul9834.alcoholapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.paul9834.alcoholapp.AppDataBase
import com.paul9834.alcoholapp.R
import com.paul9834.alcoholapp.data.model.DataSource
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.domain.RepoImpl
import com.paul9834.alcoholapp.ui.adapter.MainAdapter
import com.paul9834.alcoholapp.ui.viewmodel.MainViewModel
import com.paul9834.alcoholapp.ui.viewmodel.VMFactory
import com.paul9834.alcoholapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favorite_drink.*
import kotlinx.android.synthetic.main.fragment_main.*

class FavoriteDrinkFragment : Fragment(), MainAdapter.onTragoClickListener{


    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSource(AppDataBase.getDatabase(requireActivity().applicationContext))))
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
                        Drink(it.tradoId, it.imagen, it.nombre, it.descripcion, it.hasAlcohol)
                    }

                  /*  val lista = result.data
                    val listDrink = mutableListOf<Drink>()

                    for (drink in lista ) {
                        listDrink.add(Drink(drink.tradoId, drink.imagen,drink.nombre, drink.descripcion, drink.hasAlcohol))
                    }*/

                    rv_lista_favoritos.adapter = MainAdapter(requireContext(), lista, this)


                    Log.d(TAG, "onViewCreated: ${result.data}")
                }
                is Resource.Failure -> {

                }
            }
        })


    }

    private fun setupRecyclerView() {

        rv_lista_favoritos.layoutManager = LinearLayoutManager(requireContext())
        rv_lista_favoritos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

    }

    override fun onTragoClick(drink: Drink, position: Int) {
        viewModel.deleteDrink(drink)
        rv_lista_favoritos.adapter?.notifyItemRemoved(position)
        rv_lista_favoritos.adapter?.notifyItemRangeRemoved(position, rv_lista_favoritos.adapter?.itemCount!!)



    }


}