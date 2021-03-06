package com.socra.socra.retro_freak.activitis;

import android.content.Intent;
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

public class Dragon_ball extends AppCompatActivity {

    private List<productos> productos;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon_ball);

        Toolbar myTolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(myTolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true );
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        layout= new LinearLayoutManager(this);

        productos = new ArrayList<>();
        recyclerView = findViewById(R.id.reciclerdba);
        getalldragonball();

        adapter = new adaptador_fragments(productos,R.layout.reciclerview,new adaptador_fragments.OnItemClickListener() {


            @Override
            public void OnItemClick(View view, int position) {

                if(position ==0){
                    Intent intent=new Intent(Dragon_ball.this,activiti_gogeta.class);
                    startActivity(intent);
                }

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
    }

    private void getalldragonball(){
        productos.add(new productos(R.drawable.gogeta,"Gogeta","40euros"));
        productos.add(new productos(R.drawable.vegeta," Vegeta con Trunks","30euros"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carrito, menu);

        return true;
    }
}
