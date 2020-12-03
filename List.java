package com.example.contactapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link List.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link List#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List extends Fragment {

    private String USERNAME = null;
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    ListView lv;
    String[] arr;

    ListView myListView;
    java.util.List<UserInfo> myUserList = new ArrayList<UserInfo>();
    String[] myMovies = {"A", "B", "C", "D", "A1", "B1", "C1", "D1", "A2", "B2", "C2", "D2", "A3", "B3", "C3", "D3", "A", "B", "C", "D", "A1", "B1", "C1", "D1", "A2", "B2", "C2", "D2", "A3", "B3", "C3", "D3"};


    public List(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
//        itemList = new ArrayList<String>();
//        lv = view.findViewById(R.id.list);
//        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getStringArrayList());
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                arr[position] = String.valueOf(100);
//                adapter.notifyDataSetChanged();
//            }
////            @Override
////            public void onClick(View v) {
////                itemList[p]
////            }
//        });



        myListView = view.findViewById(R.id.list);

        myUserList.add(new UserInfo("Jason Statham", 19213453, R.drawable.jason));
        myUserList.add(new UserInfo("Vin Deisel", 12782793, R.drawable.vin));
        myUserList.add(new UserInfo("Tom Cruis", 41273842, R.drawable.tom));
        myUserList.add(new UserInfo("Robert Damm", 32198372,  R.drawable.robert));
        myUserList.add(new UserInfo("Arnold Schez", 36493372,  R.drawable.arnold));
        myUserList.add(new UserInfo("Henry Cavil", 32198934,  R.drawable.cavill));
//        myUserList.add(new UserInfo("Chris John", 28394372, R.drawable.chris));
//        myUserList.add(new UserInfo("Matt Demon", 83920348, R.drawable.damon));
//        myUserList.add(new UserInfo("The Rock", 81234590,  R.drawable.rock));
//        myUserList.add(new UserInfo("Will Smith", 94000394,  R.drawable.will));

        ///ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout.c, myMovies);

        MyCustomAdapter myAdapter = new MyCustomAdapter(view.getContext(), myUserList);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

//                System.out.println("Display Index "+ i);
//
//                String valueUserClicked = myMovies[i];
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setMessage("Add to Favourite List?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Favourite.insert_fav(myUserList.get(i));
                                Favourite.updateList();
                                dialog.dismiss();
                                dialog.cancel();
                            }
                        });
                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
//                System.out.println("Value from User  "+ valueUserClicked);

//                Intent newScreen = new Intent(getApplicationContext(), ListViewDetails.class);
//
//                newScreen.putExtra("value", valueUserClicked);
//
//                startActivity(newScreen);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private String[] getStringArrayList() {
        arr = new String[10];
        for(int i = 0;i<10;i++) {
            arr[i] = String.valueOf(i);
        }
        return arr;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
