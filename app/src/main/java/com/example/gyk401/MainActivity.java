package com.example.gyk401;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    //değişkenlerin tanımlanması
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    HealthFragment healthFragment;
    DietFragment dietFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //değikenlerin atanması ve Fragment objelerin oluşturulması
        homeFragment = new HomeFragment();
        healthFragment = new HealthFragment();
        dietFragment = new DietFragment();
        bottomNavigationView = findViewById(R.id.BottomNav);
        //başlangıç olarak homeFragmentının atanması
        setFragment(homeFragment);

        //navigationbarda tıklanan itemi dinleyen fonskyion
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.home: //homea tıklanması durumu
                        setFragment(homeFragment);
                        return true;
                    case R.id.health: //health kısmına tıklanması durumu
                        setFragment(healthFragment);
                        return true;
                    case R.id.diet: //diet kısmına tıklanması durumu
                        setFragment(dietFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });



    }

    //fragmentı değiştirien fonksyion
    private void setFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //değişim işlemini başlatacak transaction
        ft.replace(R.id.Frame,fragment); //framelayoutun içerisie fragmentı yerleştirecek
        ft.commit();

    }
}
