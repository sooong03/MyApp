package kr.anima.xd.s.myapp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.entries.inventory.InventoryFragment;
import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.cloud.CloudFragment;
import kr.anima.xd.s.myapp.entries.dashboard.DashboardFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_cloud:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new CloudFragment(MainActivity.this)).commit();

                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new DashboardFragment(MainActivity.this)).commit();

                    return true;
                case R.id.navigation_inventory:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new InventoryFragment(MainActivity.this)).commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
    }



}
