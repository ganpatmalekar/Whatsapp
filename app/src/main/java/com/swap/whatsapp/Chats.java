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

public class Chats extends Fragment {

    private ListView listView;
    private FloatingActionButton actionButton;

    private List<String> chatUsers;
    private List<String> chatMessages;
    private List<Integer> chatPics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);

        listView = view.findViewById(R.id.chatListView);

        chatUsers = new ArrayList<>();
        chatUsers.add("Rohan Patki");
        chatUsers.add("Harshad Pate");
        chatUsers.add("Suraj Patil");
        chatUsers.add("Sachin Murge");
        chatUsers.add("Shital Nalawade");
        chatUsers.add("Preeti Achary");
        chatUsers.add("Akshay Kulkarni");

        chatMessages = new ArrayList<>();
        chatMessages.add("A message from Rohan Patki");
        chatMessages.add("A message from Harshad Pate");
        chatMessages.add("A message from Suraj Patil");
        chatMessages.add("A message from Sachin Murge");
        chatMessages.add("A message from Shital Nalawade");
        chatMessages.add("A message from Preeti Achary");
        chatMessages.add("A message from Akshay Kulkarni");

        chatPics = new ArrayList<>();
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);
        chatPics.add(R.drawable.rohan);

        ChatAdapter chatAdapter = new ChatAdapter();
        listView.setAdapter(chatAdapter);

        actionButton = view.findViewById(R.id.floatChat);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Open Chats", Toast.LENGTH_SHORT).show();
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
        menu.findItem(R.id.privacy).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newGroup:
                break;
            case R.id.newBroadcast:
                break;
            case R.id.whatWeb:
                break;
            case R.id.starredMsg:
                break;
            case R.id.settings:
                break;
            case R.id.search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ChatAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return chatUsers.size();
        }

        @Override
        public Object getItem(int position) {
            return chatUsers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CircleImageView imageView;
            TextView title, message;

            View view = getLayoutInflater().inflate(R.layout.chat_layout, parent, false);

            imageView = view.findViewById(R.id.chatImage);
            imageView.setImageResource(chatPics.get(position));

            title = view.findViewById(R.id.chatTitle);
            title.setText(chatUsers.get(position));

            message = view.findViewById(R.id.chatMsg);
            message.setText(chatMessages.get(position));

            return view;
        }
    }
}
