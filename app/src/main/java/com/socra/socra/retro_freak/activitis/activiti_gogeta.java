package com.socra.socra.retro_freak.activitis;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.socra.socra.retro_freak.R;

public class activiti_gogeta extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiti_gogeta);

        Toolbar myTolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(myTolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true );
        getSupportActionBar().setDisplayShowHomeEnabled(true);





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carrito, menu);

        return true;
    }


}
