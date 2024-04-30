package com.example.connectionretrofit.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.connectionretrofit.viewmodels.DogViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsView(dogViewModel: DogViewModel){
    var image = dogViewModel.urlImage
    var imagesByBreed = dogViewModel.images.collectAsState()
    var raza by remember {
        mutableStateOf("hound")
    }

    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        AsyncImage(model = "${image}", contentDescription = null,
        modifier = Modifier
            .height(300.dp)
            .width(300.dp))

        //Text(text = "Imagen de la URL es: ${image}")

        Button(onClick = {dogViewModel.fetchData()}){
            Text(text = "Dame otro perro")
        }

        Button(onClick = {dogViewModel.fetchImagesByBreed(raza)}){
            Text(text = "Traer Lista")
        }

        TextField(value = raza, onValueChange = {raza = it})

        LazyColumn(){
            items(imagesByBreed.value){imagen ->
                //Text(text = imagen)
                AsyncImage(model = imagen, contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .width(300.dp))
            }
        }
    }
}