package com.marcosledesma.a10_recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marcosledesma.a10_recyclerview.Modelos.Ordenador;
import com.marcosledesma.a10_recyclerview.R;

import java.util.List;

public class OrdenadoresAdapter extends RecyclerView.Adapter<OrdenadoresAdapter.OrdenadorVH> {
    // Variables necesarias
    private List<Ordenador> objects;
    private int resource;
    private Context context;
    // Constructor
    public OrdenadoresAdapter(List<Ordenador> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    /**
     * Instancia un nuevo Objeto (OrdenadorVH) y lo retorna para que se le cambie la info
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public OrdenadorVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View ordenadorItem = LayoutInflater.from(context).inflate(resource, null);
        // Modificar disposición aquí (Match parent) - Por algún motivo no funciona en el xml
        ordenadorItem.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        // Retornará un nuevo OrdenadorVH pasándole el ítem del ordenador
        return new OrdenadorVH(ordenadorItem);
    }

    /**
     * Asignar los valores correspondientes a los atributos del ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull OrdenadorVH holder, int position) {
        Ordenador ordenador = objects.get(position);
        // Asignar Valores a los atributos del holder
        holder.txtMarca.setText(ordenador.getMarca());
        holder.txtModelo.setText(ordenador.getModelo());
        holder.txtRam.setText(String.valueOf(ordenador.getRam()));
        holder.txtVelocidadProcesador.setText(String.valueOf(ordenador.getVelocidadProcesador()));

        // CARD
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CARD "+position, Toast.LENGTH_SHORT).show();
            }
        });

        // txtMarca (dentro de la CARD)
        holder.txtMarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Marca "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Devolver el número de "filas" que hay que pintar (cantidad de elementos en listaOrdenadores)
     * @return
     */
    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class OrdenadorVH extends RecyclerView.ViewHolder{
        // Elementos de la fila
        TextView txtMarca, txtModelo, txtRam, txtVelocidadProcesador;
        View card;
        // Instanciarlo en su constructor
        public OrdenadorVH(@NonNull View itemView) {
            super(itemView);
            txtMarca = itemView.findViewById(R.id.txtVelocidadFila);
            txtModelo = itemView.findViewById(R.id.txtModeloFila);
            txtRam = itemView.findViewById(R.id.txtRamFila);
            txtVelocidadProcesador = itemView.findViewById(R.id.txtMarcaFila);
            card = itemView;
        }
    }
}
