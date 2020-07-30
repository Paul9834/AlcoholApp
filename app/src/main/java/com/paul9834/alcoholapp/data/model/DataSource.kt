package com.paul9834.alcoholapp.data.model

import com.paul9834.alcoholapp.vo.Resource

class DataSource {


    val generateTragosList = Resource.Success(listOf<Drink>(

        Drink(
            "https://dislicores.vteximg.com.br/arquivos/ids/155936-1000-1000/Licores-licor-de-lychee_307110_1.jpg?v=637085599582830000",
            "Margarita",
            "Con azucar, vodka y nueces"
        ),
        Drink(
            "https://www.tiendalicoressinc.com/server/Portal_0005128/img/products/licores-tradicionales-biri-biri-100cl_566896_xl.jpg",
            "Fernet",
            "Con azucar, vodka y sin nueces"
        ),
        Drink(
            "https://dislicores.vteximg.com.br/arquivos/ids/155968-1000-1000/Licores-vodka_307057_1.jpg?v=637085599685470000",
            "Toro",
            "Con azucar, vodka y nueces"
        )
    ))


}