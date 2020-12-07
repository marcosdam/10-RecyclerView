package com.marcosledesma.a10_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.marcosledesma.a10_recyclerview.Adapters.OrdenadoresAdapter;
import com.marcosledesma.a10_recyclerview.Modelos.Ordenador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Modelo de datos
    private ArrayList<Ordenador> listaOrdenadores;
    // Fila
    private int filaOrdenador;
    // RecyclerView
    private RecyclerView recyclerView;
    // ADAPTER
    private OrdenadoresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializar
        filaOrdenador = R.layout.ordenador_card;
        listaOrdenadores = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerMain);

        inicializaDatos();

        // Permite tener diferentes Layouts (Contenedores -> "estructurantes")
        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this);    // Vertical por defecto
        LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Permite elegir cantidad de filas (spanCount) -> Se comportará como un Linear Vertical
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManagerVertical);

        // Iniciar adapter
        adapter = new OrdenadoresAdapter(listaOrdenadores, filaOrdenador, this);
        // Asignar adapter al RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true); // Todas las filas tendrán el mismo tamaño
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    // Función que crea 1000 ordenadores (ejemplo)
    private void inicializaDatos(){
        for (int i = 0; i < 1000 ; i++) {
            listaOrdenadores.add(new Ordenador("Marca", "Modelo", 2, 3.5f));
        }
    }
}