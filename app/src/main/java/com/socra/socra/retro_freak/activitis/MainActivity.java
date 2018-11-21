package com.socra.socra.retro_freak.activitis;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.adaptadores.adaptador_tabs;
import com.socra.socra.retro_freak.clases.productos;
import com.socra.socra.retro_freak.clases.productossqlite;
import com.socra.socra.retro_freak.fragments.Series_y_Pelis;
import com.socra.socra.retro_freak.fragments.camisetas;
import com.socra.socra.retro_freak.fragments.carrito;
import com.socra.socra.retro_freak.fragments.categorias;
import com.socra.socra.retro_freak.fragments.figuras;
import com.socra.socra.retro_freak.fragments.gamer;
import com.socra.socra.retro_freak.fragments.informatica;
import com.socra.socra.retro_freak.fragments.inicio;
import com.socra.socra.retro_freak.fragments.manga;
import com.socra.socra.retro_freak.fragments.mapfragments;
import com.socra.socra.retro_freak.fragments.superheroes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements gamer.OnFragmentInteractionListener,
        Series_y_Pelis.OnFragmentInteractionListener, manga.OnFragmentInteractionListener, superheroes.OnFragmentInteractionListener,
        camisetas.OnFragmentInteractionListener,categorias.OnFragmentInteractionListener,figuras.OnFragmentInteractionListener,
        informatica.OnFragmentInteractionListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;





    private List<com.socra.socra.retro_freak.clases.productos> productos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.navview);
        productos = new ArrayList<>();
        registrar();


        Toolbar myTolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(myTolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_navdraw);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentDefecto();













        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaccion = false;
                Fragment fragment = null;



                switch (item.getItemId()) {

                    case R.id.categorias:
                        fragment = new categorias();
                        fragmentTransaccion = true;
                        break;



                    case R.id.contactar:
                        fragment = new mapfragments();
                        fragmentTransaccion = true;
                        break;

                    case R.id.camisetas:
                        fragment = new camisetas();
                        fragmentTransaccion = true;
                        break;

                    case R.id.figuras:
                        fragment = new figuras();
                        fragmentTransaccion = true;
                        break;

                    case R.id.informatica:
                        fragment = new informatica();
                        fragmentTransaccion = true;
                        break;

                    case R.menu.carrito:
                        fragment = new carrito();
                        fragmentTransaccion = true;
                        break;







                }








               if (fragmentTransaccion){
                    cambiarFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }
                return false;

            }

        });

    }

    private void cambiarFragment(Fragment fragment, MenuItem item){

        getSupportFragmentManager()
                .beginTransaction()
               .replace(R.id.contenedorprincipal, fragment)
                .commit();

        item.setChecked(true);

    }





    public boolean onOptionsItemSelected(MenuItem item) {

        boolean fragmentTransaccion = false;
        Fragment fragment = null;

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);

                break;

            case R.menu.carrito:
                fragment = new carrito();
                fragmentTransaccion = true;

                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carrito, menu);

        return true;
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void fragmentDefecto(){


        cambiarFragment(new categorias(),navigationView.getMenu().getItem(0));

    }

    public void registrar (){
        productossqlite admin = new productossqlite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();




        ContentValues registro = new ContentValues();

        registro.put("descripcion","vegeta con trunks");
        registro.put("precio","20 euros");
        registro.put("descripcion","snes");
        registro.put("precio","60 euros");
        registro.put("descripcion","mario");
        registro.put("precio","10 euros");
        registro.put("descripcion","camiseta bbt");
        registro.put("precio","12 euros");
        registro.put("descripcion","cortina bbt");
        registro.put("precio","10 euros");
        registro.put("descripcion","camiseta ff");
        registro.put("precio","10 euros");
        registro.put("descripcion","figura cloud");
        registro.put("precio", "15 euros");
        registro.put("descripcion","figura got");
        registro.put("precio","20 euros");
        registro.put("descripcion","gogeta");
        registro.put("precio", "23 euros");
        registro.put("descripcion","camiseta got");
        registro.put("precio","10 euros");
        registro.put("descripcion","figura naruto");
        registro.put("precio","16 euros");
        registro.put("descripcion","figura tia");
        registro.put("precio","12 euros");




        BaseDeDatos.insert("productos",null,registro);
        BaseDeDatos.close();

    }

   // private void actualizarbd (){
     //   productos.clear();
       // productos.addAll();
    //}



  //  private List<productos> todosLosProductos () {
//
  //      Cursor cursor = BaseDeDatos.rawQuery("select * from productos", null);
    //    List<productos> list = new ArrayList<productos>();

      //  if (cursor.moveToFirst()) {
        //    while (cursor.isAfterLast() == false) {
          //      String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
            //    String precio = cursor.getString(cursor.getColumnIndex("precio"));

              //  list.add(new productos(descripcion, precio));
                //cursor.moveToNext();

            //}
       // }
        //return list;


   // }


}
