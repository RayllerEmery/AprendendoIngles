package com.example.user.aprendaingls.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.aprendaingls.Fragment.BichosFragment;
import com.example.user.aprendaingls.Fragment.NumerosFragment;
import com.example.user.aprendaingls.Fragment.VogaisFragment;
import com.example.user.aprendaingls.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Bichos", BichosFragment.class)
                .add("Números", NumerosFragment.class)
                .add("Vogais", VogaisFragment.class)
                .create()
        );

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        smartTabLayout = findViewById(R.id.viewpagertab);
        smartTabLayout.setViewPager(viewPager);
    }
}
