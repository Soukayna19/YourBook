package android.com.yourbookk;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    FrameLayout frame;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pageView);

       // tab = findViewById(R.id.tab);
        /*
        frame=findViewById(R.id.frame);
        TabItem tab1 = tabLayout.findViewById(R.id.home);
        TabItem tab2 = tabLayout.findViewById(R.id.promotion);
        //tab.setScrollPosition(1,0,true);
        fragment = new home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new home();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
            }
        });
        */

        tabLayout.setupWithViewPager(viewPager);
        Adapter adapter=new Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new home(),"home");
        adapter.addFragment(new promotion(),"promotion");
        adapter.addFragment(new islamique(),"islam");
        adapter.addFragment(new cuisine(),"cuisine");
        adapter.addFragment(new physique(),"physique");
        adapter.addFragment(new Chimie(),"chimie");
        adapter.addFragment(new math(),"mathématique");
        adapter.addFragment(new informatique(),"informatique");
        adapter.addFragment(new arab(),"arabe");

        viewPager.setAdapter(adapter);

        //*/
    }

}
