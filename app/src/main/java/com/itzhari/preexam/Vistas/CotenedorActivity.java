package com.itzhari.preexam.Vistas;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itzhari.preexam.ItemAdapter;
import com.itzhari.preexam.Items;
import com.itzhari.preexam.MainActivity;
import com.itzhari.preexam.MyService;
import com.itzhari.preexam.R;
import com.itzhari.preexam.Vistas.Fragmentos.CrearNotaFragment;
import com.itzhari.preexam.Vistas.Fragmentos.HomeFragment;
import com.itzhari.preexam.Vistas.Fragmentos.MeFragment;
import com.itzhari.preexam.Vistas.Fragmentos.NotasFragment;
import com.itzhari.preexam.Vistas.Fragmentos.inicioFragment;

import java.util.ArrayList;

public class CotenedorActivity extends ActionBarActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private String[] tagTitles;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotenedor);
        //Obtener arreglo de strings desde los recursos
        tagTitles = getResources().getStringArray(R.array.tabs);
//Obtener drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//Obtener listview
        drawerList = (ListView) findViewById(R.id.left_drawer);

//Nueva lista de drawer items
        ArrayList<Items> items = new ArrayList<Items>();
        items.add(new Items(tagTitles[0], R.drawable.ic_drawe));
        items.add(new Items(tagTitles[1], R.drawable.image));
        items.add(new Items(tagTitles[2], R.drawable.note));
        items.add(new Items(tagTitles[3], R.drawable.user));
        items.add(new Items(tagTitles[4], R.drawable.close));


// Relacionar el adaptador y la escucha de la lista del drawer
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(new ItemAdapter(this, items));
        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.mipmap.ic_drawar,
                R.string.drawer_open,
                R.string.drawer_close
        ){
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {

            // Crear nuevo fragmento
            inicioFragment fragment = new inicioFragment();
            MeFragment fragment1 = new MeFragment();
        NotasFragment fragment2 = new NotasFragment();
      HomeFragment fragment0 = new HomeFragment();

        if(position == 0) {
            //Reemplazar contenido
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment0).commit();
        }
        if(position == 1){
            FragmentManager fragmentManager1 = getFragmentManager();
            fragmentManager1.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
        if(position == 2){
            FragmentManager fragmentManager2 = getFragmentManager();
            fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();
        }
        if(position == 3){
            FragmentManager fragmentManager3 = getFragmentManager();
            fragmentManager3.beginTransaction().replace(R.id.content_frame, fragment1).commit();
        }

        if(position == 4){
           detrolServ();
        }

            // Se actualiza el item seleccionado y el título, después de cerrar el drawer
            drawerList.setItemChecked(position, true);
            setTitle(tagTitles[position]);
            drawerLayout.closeDrawer(drawerList);


    }

    public void detrolServ(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        stopService(new Intent(getBaseContext(),MyService.class));
    }
    @Override
    public void setTitle(CharSequence title) {
        itemTitle = title;
        getSupportActionBar().setTitle(itemTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sincronizar el estado del drawer
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        drawerToggle.onConfigurationChanged(newConfig);
    }
    public void cambiar (View view){
        Intent intent= new Intent(this, CrearNotaFragment.class);
        startActivity(intent);
    }

}
