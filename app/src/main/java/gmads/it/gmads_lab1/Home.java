package gmads.it.gmads_lab1;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.support.design.widget.TabLayout;


import com.arlib.floatingsearchview.FloatingSearchView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import gmads.it.gmads_lab1.fragments.Home_1;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        //SearchView mSearchView = (SearchView) findViewById(R.id.searchView); // initiate a search view
        //mSearchView.attachNavigationDrawerToMenuButton(findViewById(R.id.drawer_layout));
        //mSearchView.setIconifiedByDefault(false);  // set the default or resting state of the search field

       // recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initCollapsingToolbar();
        /*bookList = new ArrayList<>();
        adapter = new BookAdapter(this, bookList);*/

        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(adapter);
//
        ViewPager pager= findViewById(R.id.viewPager);
        FragmentViewPagerAdapter vpadapter= new FragmentViewPagerAdapter(getSupportFragmentManager());
        vpadapter.addFragment(new Home_1());
        vpadapter.addFragment(new Home_1());
        pager.setAdapter(vpadapter);
        TabLayout tableLayout= findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(pager);
        tableLayout.getTabAt(0).setText("Tab1");
        tableLayout.getTabAt(1).setText("Tab2");


//
        //era per mettere foto libri nell appbar, ma l'abbiamo messa come sfondo per ora
        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Override
    public boolean onQueryTextSubmit(String query) {
        // do something on text submit
        //parte la query di gogo
        return false;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

     /*mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
        @Override
        public void onSearchTextChanged(String oldQuery, final String newQuery) {

            //get suggestions based on newQuery

            //pass them on to the search view
            mSearchView.swapSuggestions(newSuggestions);
        }
    });*/

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

}
class FragmentViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    public FragmentViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
