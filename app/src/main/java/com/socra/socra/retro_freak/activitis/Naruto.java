package com.socra.socra.retro_freak.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.adaptadores.adaptador_fragments;
import com.socra.socra.retro_freak.clases.productos;

import java.util.ArrayList;
import java.util.List;

public class Naruto extends AppCompatActivity {

    private List<productos> productos;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto);

        Toolbar myTolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(myTolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true );
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        layout= new LinearLayoutManager(this);

        productos = new ArrayList<>();
        recyclerView = findViewById(R.id.ReciclerNaruto);
        getallnaru();



        adapter = new adaptador_fragments(productos,R.layout.reciclerview,new adaptador_fragments.OnItemClickListener() {


            @Override
            public void OnItemClick(View view, int position) {

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

    }

    private void getallnaru(){
        productos.add(new productos(R.drawable.naruto,"Naruto","40euros"));
        productos.add(new productos(R.drawable.tia," tia","30euros"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carrito, menu);

        return true;
    }
}
