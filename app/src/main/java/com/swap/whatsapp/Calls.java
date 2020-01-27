package com.swap.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Calls extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calls_fragment, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflate menu
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
        setMenuVisibility(menu);
    }

    public void setMenuVisibility(Menu menu) {
        menu.findItem(R.id.newGroup).setVisible(false);
        menu.findItem(R.id.newBroadcast).setVisible(false);
        menu.findItem(R.id.whatWeb).setVisible(false);
        menu.findItem(R.id.starredMsg).setVisible(false);
        menu.findItem(R.id.search).setVisible(false);
        menu.findItem(R.id.privacy).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
