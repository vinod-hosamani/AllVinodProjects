package com.bridgelabz.navdrawerexample1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            CameraFragment cameraFragment=new CameraFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                    cameraFragment,cameraFragment.getTag()).commit();
        }

        else if (id == R.id.nav_gallery)
        {
            Toast.makeText(MainActivity.this, "nav_gallary", Toast.LENGTH_SHORT).show();
            GalleryFragment galleryFragment=GalleryFragment.newInstance("some1","some2");
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                    galleryFragment,galleryFragment.getTag()).commit();

        }
        else if (id == R.id.nav_slideshow)
        {
            Toast.makeText(MainActivity.this, "nav_slideshow", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_manage)
        {
            Toast.makeText(MainActivity.this, "nav_manage", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_share)
        {
            BlankFragment blankFragment=BlankFragment.newInstance(5);
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                    blankFragment,blankFragment.getTag()).commit();
        }
        else if (id == R.id.nav_send)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String data)
    {
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }
}
