package com.kyrostechnologies.template.recipe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kyrostechnologies.template.recipe.ActivityMain;
import com.kyrostechnologies.template.recipe.ActivityRecipeDetails;
import com.kyrostechnologies.template.recipe.R;
import com.kyrostechnologies.template.recipe.adapter.RecipeGridAdapter;
import com.kyrostechnologies.template.recipe.data.Constant;
import com.kyrostechnologies.template.recipe.data.Tools;
import com.kyrostechnologies.template.recipe.model.Recipe;

public class FavoritesFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private RecipeGridAdapter mAdapter;
    private LinearLayout lyt_notfound;
    private SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorites, null);
        // activate fragment menu
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        lyt_notfound = (LinearLayout) view.findViewById(R.id.lyt_notfound);
        LinearLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Tools.getGridSpanCount(getActivity()));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecipeGridAdapter(getActivity(), Constant.getItemFavorites(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RecipeGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Recipe obj, int position) {
                ActivityRecipeDetails.navigate((ActivityMain) getActivity(), v.findViewById(R.id.image), obj);
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setIconified(false);
        searchView.setQueryHint("Search ic_launcher...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                try {
                    mAdapter.getFilter().filter(s);
                } catch (Exception e) {
                }
                return true;
            }
        });
        // Detect SearchView icon clicks
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setItemsVisibility(menu, searchItem, false);
            }
        });

        // Detect SearchView close
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                setItemsVisibility(menu, searchItem, true);
                return false;
            }
        });
        searchView.onActionViewCollapsed();
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Snackbar.make(view, item.getTitle() + " clicked", Snackbar.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void setItemsVisibility(Menu menu, MenuItem exception, boolean visible) {
        for (int i=0; i<menu.size(); ++i) {
            MenuItem item = menu.getItem(i);
            if (item != exception) item.setVisible(visible);
        }
    }
}
