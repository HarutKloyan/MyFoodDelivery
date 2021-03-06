package com.example.myfooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.myfooddelivery.MenuItemsActivies.AddressActivity;
import com.example.myfooddelivery.MenuItemsActivies.Credit_cardActivity;
import com.example.myfooddelivery.MenuItemsActivies.HistoryActivity;
import com.example.myfooddelivery.MenuItemsActivies.NotificationsActivity;
import com.example.myfooddelivery.MenuItemsActivies.SupportActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.List;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      getSupportActionBar().hide();
        Init();
    }
    private void Init(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.menu_nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.notifications);

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else

        {
            super.onBackPressed();
        }
    }

    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter =
                new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.notifications:
                Intent intent = new Intent(this, NotificationsActivity.class);
                startActivity(intent);
                break;
            case R.id.credit_card:
                Intent intent1 = new Intent(this, Credit_cardActivity.class);
                startActivity(intent1);
                break;
            case R.id.purchase_history:
                Intent intent2 = new Intent(this, HistoryActivity.class);
                startActivity(intent2);
                break;
            case R.id.address:
                Intent intent3 = new Intent(this, AddressActivity.class);
                startActivity(intent3);
                break;
            case R.id.support:
                Intent intent4 = new Intent(this, SupportActivity.class);
                startActivity(intent4);
                break;
            case R.id.settings:
                Intent intent5 = new Intent(this, ProfileSettingsActivity.class);
                startActivity(intent5);
                break;

        }

        return true;

    }
}
