package it.polimi.manguste;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigationrail.NavigationRailView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.IllegalFormatCodePointException;

import it.polimi.manguste.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        NavigationRailView navRailView = findViewById(R.id.nav_rail_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_dashboard, R.id.navigation_analysis, R.id.navigation_shop)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);

        if (isTablet) {
            // For tablet
            if (navRailView != null) {
                NavigationUI.setupWithNavController(navRailView, navController);
            }
        } else {
            // For phone
            if (bottomNavView != null) {
                NavigationUI.setupWithNavController(bottomNavView, navController);
            }
        }

        // Sets the StatusBar to transparent and the BottomNavBar selector color to light/dark green
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            if (isTablet) {
                navRailView.setItemActiveIndicatorColor(ColorStateList.valueOf(Color.parseColor("#92D769")));

            } else {
                bottomNavView.setItemActiveIndicatorColor(ColorStateList.valueOf(Color.parseColor("#92D769")));
            }
        } else {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            if (isTablet) {
                navRailView.setItemActiveIndicatorColor(ColorStateList.valueOf(Color.parseColor("#385f1c")));
            } else {
                bottomNavView.setItemActiveIndicatorColor(ColorStateList.valueOf(Color.parseColor("#385f1c")));
            }
        }
    }

}