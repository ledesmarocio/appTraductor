package com.example.apptraductor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TraductorViewModel extends ViewModel { //si queremos compartir el viewmodel a varias clases deberia usar AndroidVieModel
    private List<Palabra> palabras;
    private MutableLiveData<String> palabraTraducida= new MutableLiveData<>();
    private MutableLiveData<Integer> imagen= new MutableLiveData<>();
    /*necesitamos mutable porque nos permite actualizar la vista en vivo. Mutable porque van a ser modificados.
    * En este caso necesitamos modificar el texto, el editText y la imágen. Queda a la espera de que se resuelvan los cambios */

    public TraductorViewModel(){
        palabras= new ArrayList<>();
        palabras.add(new Palabra("Gato", "Cat", R.drawable.gatito));
        palabras.add(new Palabra("Perro", "Dog", R.drawable.perrito));
        palabras.add(new Palabra("Casa", "House", R.drawable.casa));
        palabras.add(new Palabra("Manzana", "Apple", R.drawable.manzana));
        palabras.add(new Palabra("Conejo", "Rabbit", R.drawable.conejito));

    }
    public void traducirPalabra(String palabraEsp){
        for (Palabra p: palabras){
            if(p.getSpanish().equalsIgnoreCase(palabraEsp)){
                palabraTraducida.setValue(p.getEnglish());
                imagen.setValue(p.getImg());
                return;
            }
        }
        palabraTraducida.setValue("No encontrada");
        imagen.setValue(R.drawable.nada1);
    }
    public LiveData<String> getPalabraTraducida(){
        return palabraTraducida;
    }
    public LiveData<Integer> getImagen(){
        return imagen;
    }
}
