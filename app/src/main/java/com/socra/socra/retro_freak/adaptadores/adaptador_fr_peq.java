package com.socra.socra.retro_freak.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.clases.categorias;

import java.util.List;

public class adaptador_fr_peq  extends RecyclerView.Adapter<adaptador_fr_peq.ViewHolder>{


    private List<categorias> categorias;
    private int reciclerview;
    private OnItemClickListener onItemClickListener;


    public adaptador_fr_peq(List<categorias>categorias, int reciclerview,OnItemClickListener onItemClickListener){

        this.reciclerview=reciclerview;
        this.onItemClickListener = onItemClickListener;
        this.categorias = categorias;
    }



    @Override
    public adaptador_fr_peq.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(reciclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(adaptador_fr_peq.ViewHolder holder, int position) {
        holder.bind(categorias.get(position));
    }



    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private ImageView foto;
        private TextView nombre;

        public ViewHolder (View itemView){
            super(itemView);

            foto = itemView.findViewById(R.id.foto_cat);
            nombre= itemView.findViewById(R.id.nombre_cate);

            foto.setOnClickListener(this);
            nombre.setOnClickListener(this);

        }

        public void bind(categorias categorias){
            foto.setImageResource(categorias.getFoto());
            nombre.setText( categorias.getNombre());


        }

        @Override
        public void onClick(View v) {
            onItemClickListener.OnItemClick(itemView,getAdapterPosition());


        }
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);
    }
}
