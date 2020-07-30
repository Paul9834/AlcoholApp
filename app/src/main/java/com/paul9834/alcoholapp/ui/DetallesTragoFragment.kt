package com.paul9834.alcoholapp.ui

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider
import com.paul9834.alcoholapp.AppDataBase
import com.paul9834.alcoholapp.R
import com.paul9834.alcoholapp.data.model.DataSource
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.domain.RepoImpl
import com.paul9834.alcoholapp.ui.viewmodel.MainViewModel
import com.paul9834.alcoholapp.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_detalles_trago.*

class DetallesTragoFragment : Fragment() {

    private lateinit var drink: Drink


    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSource(AppDataBase.getDatabase(requireActivity().applicationContext))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough().apply {
            secondaryAnimatorProvider = SlideDistanceProvider(Gravity.BOTTOM)

        }


        requireArguments().let {

            // !! Verifica si es nulo

            drink = it.getParcelable<Drink>("drink")!!

            Log.d("Detalles:", "$drink")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalles_trago, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext()).load(drink.imagen).into(img_trago)
        trago_title.text = drink.nombre
        trago_desc.text = drink.descripcion

        if (drink.hasAlcohol == "Non_Alcoholic") {
            txt_has_alcohol.text = "Bebida sin alcohol"
        } else {
            txt_has_alcohol.text = "Bebida con alcohol"
        }


        btn_guardar_trago.setOnClickListener{
            viewModel.guardarTrago(DrinkEntity(drink.tradoId, drink.imagen, drink.nombre, drink.descripcion, drink.hasAlcohol))
            Toast.makeText(requireContext(), "Se ha guardado como favoritos", Toast.LENGTH_SHORT).show()
        }

    }



}