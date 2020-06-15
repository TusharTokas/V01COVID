package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



import com.example.myapplication.Fragment.CountryFrag;
import com.example.myapplication.Fragment.HomeFrag;
import com.example.myapplication.Fragment.IndiaFrag;
import com.example.myapplication.Fragment.SymptomsFrag;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    TextView t1,t2,t3;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    CollapsingToolbarLayout collapsingToolbarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        toolbarSetup();
        bottomSetup();
        getDataAPI();
    }

    private void bottomSetup() {
        bottomNavigationView.setItemIconTintList(null);
bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                Fragment homeFrag = new HomeFrag();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransactio = fragmentManager.beginTransaction();
                fragmentTransactio.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransactio.replace(R.id.container, homeFrag).commit();
                break;
            case R.id.India:
                Toast.makeText(getApplicationContext(), "India", Toast.LENGTH_LONG).show();
                Fragment indiaFrag = new IndiaFrag();
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.replace(R.id.container, indiaFrag).commit();
                break;
            case R.id.AllCountry:
                Toast.makeText(getApplicationContext(), "AllCountry", Toast.LENGTH_LONG).show();
                Fragment countryFrag = new CountryFrag();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.replace(R.id.container, countryFrag).commit();
                break;
            case R.id.Symptoms:
                Toast.makeText(getApplicationContext(), "Symptoms", Toast.LENGTH_LONG).show();
                Fragment Sypt = new SymptomsFrag();
                FragmentManager fam = getSupportFragmentManager();
                FragmentTransaction fat = fam.beginTransaction();
                fat.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fat.replace(R.id.container, Sypt).commit();
                break;


        }








        return false;
    }
});



    }

    private void getDataAPI() {




    }



    private void toolbarSetup() {

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Menu button Clicked",Toast.LENGTH_LONG ).show();
            }
        });

    }


    private void viewInit() {

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
toolbar=findViewById(R.id.toolbar);
bottomNavigationView=findViewById(R.id.bottom_menu);
collapsingToolbarLayout=findViewById(R.id.collLayout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Fragment homeFrag = new HomeFrag();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactio = fragmentManager.beginTransaction();
        fragmentTransactio.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransactio.replace(R.id.container, homeFrag).commit();
    }
}
