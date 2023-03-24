package com.mancomunidadmontejurra.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.mancomunidadmontejurra.myapp.Adapters.MyViewPagerAdapter;
import com.mancomunidadmontejurra.myapp.Conexion.MySQLConnection;
import com.mancomunidadmontejurra.myapp.R;

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    private final String tabla = "users";
    TabLayout tabLayout;
    androidx.appcompat.widget.Toolbar toolbar;
    ViewPager viewPager;

    MyViewPagerAdapter myViewPagerAdapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM "+tabla);
            consulta.executeQuery();
        }catch (Exception e){


        }
        fab = findViewById(R.id.idbtnNewChat);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Chats"));
        tabLayout.addTab(tabLayout.newTab().setText("Aveías"));

        LinearLayout layout = ((LinearLayout) ((LinearLayout) tabLayout.getChildAt(0)).getChildAt(0));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.weight = 0.5f;
        layout.setLayoutParams(layoutParams);

        toolbar = findViewById(R.id.Toolbar);
        toolbar.setTitle("Whatsapp");

        viewPager = findViewById(R.id.viewPager);
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            // ...
        });

        viewPager = findViewById(R.id.viewPager);
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        fab.setImageDrawable(getResources().getDrawable(R.drawable.buscar));
                        toolbar.getMenu().clear();

                        fab.setOnClickListener(v -> {
                            Toast.makeText(MainActivity.this, "Prueba", Toast.LENGTH_SHORT).show();
                           // Intent ToTouched = new Intent(MainActivity.this, ContactsActivity.class);
                            try {
                                //startActivity(ToTouched);
                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 1:

                        toolbar.getMenu().clear();

                        fab.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Camara", Toast.LENGTH_SHORT).show());
                        break;


                }
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        tabLayout.selectTab(tabLayout.getTabAt(0));
    }




}