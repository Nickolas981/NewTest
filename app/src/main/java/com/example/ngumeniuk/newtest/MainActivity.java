package com.example.ngumeniuk.newtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.ngumeniuk.newtest.vrFragment.ui.VrFragment;
import com.example.ngumeniuk.newtest.zipFragment.ui.ZipFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private FragmentManager fragmentManager;

    private VrFragment vrFragment;
    private ZipFragment zipFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                changeFragment(zipFragment);
                return true;
            case R.id.navigation_dashboard:
                changeFragment(vrFragment);
                return true;
            case R.id.navigation_notifications:
                return false;
        }
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        loadRetainFragments();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null)
            navigation.setSelectedItemId(R.id.navigation_dashboard);
        checkPermissions();
    }

    private void checkPermissions() {
        if( ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    123);
        }
        if( ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    123);
        }
    }

    private void changeFragment(VrFragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment).hide(zipFragment);
        fragmentTransaction.commit();
    }

    private void changeFragment(ZipFragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment).hide(vrFragment);
        fragmentTransaction.commit();
    }

    private void loadRetainFragments() {
        vrFragment = (VrFragment) fragmentManager.findFragmentByTag("vr");
        zipFragment = (ZipFragment) fragmentManager.findFragmentByTag("zip");

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (vrFragment == null) {
            vrFragment = VrFragment.newInstance();
            fragmentTransaction.add(R.id.container, vrFragment, "vr");
        }
        if (zipFragment == null) {
            zipFragment = ZipFragment.newInstance();
            fragmentTransaction.add(R.id.container, zipFragment, "zip");
        }
        fragmentTransaction.commit();
    }

}
