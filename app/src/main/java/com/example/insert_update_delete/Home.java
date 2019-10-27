package com.example.insert_update_delete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
         {
    Toolbar toolbar;
ActionBarDrawerToggle drawerToggle;
    DrawerLayout mDrawer;
    NavigationView navigationView;
     TextView t1;
MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawer=findViewById(R.id.drawerLayout);


navigationView=findViewById(R.id.navigation_View);
navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawer,toolbar
        ,R.string.drawer_open,R.string.drawer_close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent,new Fragment_one()).commit() ;
            navigationView.setCheckedItem(R.id.nav_first_fragment);}
        navigationView=findViewById(R.id.navigation_View);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_first_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,new Fragment_one()).commit() ;
            break;
            case R.id.nav_second_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,new Fragment_two()).commit() ;
                break;

        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
