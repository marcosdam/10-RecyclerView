package com.marcosledesma.a10_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

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

    private LinearLayoutManager linearLayoutManagerVertical;
    private GridLayoutManager gridLayoutManager;

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
        linearLayoutManagerVertical = new LinearLayoutManager(this);    // Vertical por defecto
        // LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Permite elegir cantidad de filas (spanCount) -> Se comportará como un Linear Vertical
        gridLayoutManager = new GridLayoutManager(this, 2);
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

    // Los 2 métodos que siempre borramos ahora nos hacen falta para el menú
    // Para montar el menú
    /**
     * Para insertar el menú en la actividad (inicializar)
     * @param menu en el objeto menú del método
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);    // Eliminar el return del super

        // Menú inflater con el resource fail creado (main_menu)
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;    // Por último return true
    }

    // Para opciones del menú
    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);  // Eliminar el return del super aquí tambien

        // Según el item pulsado
        switch (item.getItemId()){
            case R.id.gridView:
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
            case R.id.linearView:
                recyclerView.setLayoutManager(linearLayoutManagerVertical);
                break;
            case R.id.configMenu:
                Toast.makeText(this, "Has presionado Config", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;    // Al final return true
    }
}