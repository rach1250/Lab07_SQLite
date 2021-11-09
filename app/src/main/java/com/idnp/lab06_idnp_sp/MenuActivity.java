package com.idnp.lab06_idnp_sp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.idnp.lab06_idnp_sp.databinding.ActivityMenuBinding;
import com.idnp.lab06_idnp_sp.ui.home.HomeFragment;
import com.idnp.lab06_idnp_sp.ui.map.DashboardFragment;
import com.idnp.lab06_idnp_sp.ui.profile.NotificationsFragment;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_menu);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            Fragment selectedFragmnet = null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedFragmnet = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragmnet = new DashboardFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragmnet = new NotificationsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
            return true;
        }
    };
}