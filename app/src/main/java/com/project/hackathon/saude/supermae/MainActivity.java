package com.project.hackathon.saude.supermae;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.hackathon.saude.supermae.adapter.FotoCustomAdapter;
import com.project.hackathon.saude.supermae.model.Foto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Properties
    private ViewPager mViewPager;
    private FloatingActionButton fabReuniao;
    private FloatingActionButton fabUser;
    static SectionsPagerAdapter mSectionsPagerAdapter;
    static int selectedTab;
    DrawerLayout drawer;


    //Dados do membro Logado
    private ImageView headerUserImage;
    private TextView headerUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET control
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //seta o herder do menu lateral
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View navHeaderView = navView.inflateHeaderView(R.layout.nav_header_main);
        headerUserName = (TextView) navHeaderView.findViewById(R.id.nav_header_main_tv_nome);
        headerUserImage = (ImageView) navHeaderView.findViewById(R.id.nav_header_main_iv_logo);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    //    protected void onResume() {
    //        super.onResume();
    //        mViewPager.setCurrentItem((selectedTab != 1) ? selectedTab : 1);
    //    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sugestoes) {
//            Intent i = new Intent(this, SugestoesActivity.class);
//            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.configuracoes) {
//            Intent i = new Intent(this, ConfiguracoesActivity.class);
//            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }

        @Override
        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
            super.onViewStateRestored(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_menu, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_foto, container, false);

                    RecyclerView recyclerView;
                    FotoCustomAdapter adapter;
                    List<Foto> fotoList;

                    recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(mLayoutManager);
                    fotoList = new ArrayList<>();

                    fotoList.add(new Foto("1", "Meu primeiro mês", "1", R.drawable.mae1));
                    fotoList.add(new Foto("1", "Meu segundo mês", "1", R.drawable.mae2));
                    fotoList.add(new Foto("1", "Meu terceiro mês", "1", R.drawable.mae3));
                    fotoList.add(new Foto("1", "Meu quarto mês", "1", R.drawable.mae4));

                    adapter = new FotoCustomAdapter(getActivity(), fotoList);
                    recyclerView.setAdapter(adapter);

                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_ranking, container, false);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_menu, container, false);
                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MENU";
                case 1:
                    return "FOTOS";
                case 2:
                    return "RANKING";
            }
            return null;
        }
    }

}

