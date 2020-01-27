package com.swap.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Status extends Fragment {
    private ListView statusListView;
    private FloatingActionButton uploadStatusButton;

    private List<String> statusUploader;
    private List<String> statusTime;
    private List<Integer> statusPics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status_fragment, container, false);

        statusListView = view.findViewById(R.id.statusListView);

        statusUploader = new ArrayList<>();
        statusUploader.add("Rohan Patki");
        statusUploader.add("Harshad Pate");
        statusUploader.add("Suraj Patil");
        statusUploader.add("Sachin Murge");
        statusUploader.add("Shital Nalawade");
        statusUploader.add("Preeti Achary");
        statusUploader.add("Akshay Kulkarni");

        statusTime = new ArrayList<>();
        statusTime.add("1 min ago");
        statusTime.add("2 min ago");
        statusTime.add("3 min ago");
        statusTime.add("4 min ago");
        statusTime.add("5 min ago");
        statusTime.add("6 min ago");
        statusTime.add("7 min ago");

        statusPics = new ArrayList<>();
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);
        statusPics.add(R.drawable.rohan);

        StatusAdapter statusAdapter = new StatusAdapter();
        statusListView.setAdapter(statusAdapter);

        uploadStatusButton = view.findViewById(R.id.floatStatus);
        uploadStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Upload Status", Toast.LENGTH_SHORT).show();
            }
        });

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

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                break;
            case R.id.privacy:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class StatusAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return statusUploader.size();
        }

        @Override
        public Object getItem(int position) {
            return statusUploader.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CircleImageView circleImageView;
            TextView title, message;

            View view = getLayoutInflater().inflate(R.layout.status_layout, parent, false);

            circleImageView = view.findViewById(R.id.statusImage);
            circleImageView.setImageResource(statusPics.get(position));

            title = view.findViewById(R.id.statusTitle);
            title.setText(statusUploader.get(position));

            message = view.findViewById(R.id.statusTime);
            message.setText(statusTime.get(position));

            return view;
        }
    }
}
