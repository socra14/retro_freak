package com.socra.socra.retro_freak.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class pantalla_carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(pantalla_carga.this,MainActivity.class);
        startActivity(intent);

    }



}
