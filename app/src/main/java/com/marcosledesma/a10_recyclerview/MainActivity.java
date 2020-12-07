package com.marcosledesma.a10_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.marcosledesma.a10_recyclerview.Modelos.Ordenador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Modelo de datos
    private ArrayList<Ordenador> listaOrdenadores;
    // Fila
    private int filaOrdenador;
    // RecyclerView
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializar
        filaOrdenador = R.layout.ordenador_item;
        listaOrdenadores = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerMain);
    }
}