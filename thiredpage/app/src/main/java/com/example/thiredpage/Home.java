package com.example.thiredpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    TextView username123;
    TextView email123;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        SharedPreferences sharedPreferences=getSharedPreferences("mypre",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        String name=sharedPreferences.getString("name","");
        String email=sharedPreferences.getString("email","");

//        frameLayout
        frameLayout=findViewById(R.id.frame);
        ChangeFragment(new homefragement());

//        header section edit
        navigationView=findViewById(R.id.navview);
        View heade=navigationView.getHeaderView(0);
        username123=heade.findViewById(R.id.usernameqwe);
        email123=heade.findViewById(R.id.emaile3);
        username123.setText(""+name);
        email123.setText(""+email);


//        drawar layout
        toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        ChangeFragment(new homefragement());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.share:
                        ChangeFragment(new Sharefragment());
                        Toast.makeText(Home.this, "This is the share page", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.setings:
                        ChangeFragment(new SetingsFragment());
                        Toast.makeText(Home.this, "This is the setings page", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contact:
                        ChangeFragment(new ContactFragment());
                        Toast.makeText(Home.this, "This is the contact page", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.about:
                        ChangeFragment(new aboutFragment());
                        Toast.makeText(Home.this, "This is the about page", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:

                SharedPreferences sharedPreferences;
                sharedPreferences=getSharedPreferences("mypre",MODE_PRIVATE);
                SharedPreferences.Editor edit=sharedPreferences.edit();
                edit.clear();
                edit.commit();
                Intent intent=new Intent(Home.this,Login.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ChangeFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(this)
                .setTitle("Do You Want To Quit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();

    }

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link aboutFragment#newInstance} factory method to
     * create an instance of this fragment.
     */
    public static class aboutFragment extends Fragment {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public aboutFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment aboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static aboutFragment newInstance(String param1, String param2) {
            aboutFragment fragment = new aboutFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_about, container, false);
        }
    }
}
