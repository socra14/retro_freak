package com.socra.socra.retro_freak.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.clases.productos;

import java.util.List;

public class adaptador_fragments extends RecyclerView.Adapter<adaptador_fragments.ViewHolder> {

    private List<productos> productos;
    private int reciclerview;
    private OnItemClickListener onItemClickListener;

    public adaptador_fragments(List<productos>productos, int reciclerview, OnItemClickListener onItemClickListener){

        this.reciclerview=reciclerview;
        this.onItemClickListener = onItemClickListener;
        this.productos= productos;
    }




    @Override
    public adaptador_fragments.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(reciclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adaptador_fragments.ViewHolder holder, int position) {
        holder.bind(productos.get(position));

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView foto;
        private TextView descripcion;
        private TextView precio;

        public  ViewHolder(View itemView){
            super(itemView);
            foto= itemView.findViewById(R.id.foto);
            descripcion= itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);

            descripcion.setOnClickListener(this);
            foto.setOnClickListener(this);
            precio.setOnClickListener(this);
        }

        public void bind(productos productos){
            foto.setImageResource(productos.getFoto());
            descripcion.setText(productos.getDescripcion());
            precio.setText(productos.getPrecio());

        }


        @Override
        public void onClick(View view) {
            onItemClickListener.OnItemClick(itemView,getAdapterPosition());

        }


    }

    public interface OnItemClickListener{
        void OnItemClick(View view, int position);
    }

}
