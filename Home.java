package com.example.contactapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.RealmResults;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    private String USERNAME = null;
    TextView username, email, phone, age;
    public Home(String USERNAME){
        this.USERNAME = USERNAME;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        age = view.findViewById(R.id.age);
        setDetails();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setDetails() {
        RealmResults<Contact_Model> results = MainActivity.realm.where(Contact_Model.class).findAll();
        for (Contact_Model i : results) {
            if (USERNAME.equalsIgnoreCase(i.getName().toString()) && USERNAME != null) {
                username.setText(i.getName().toString());
                email.setText(i.getEmail().toString());
                phone.setText(String.valueOf(i.getPhone()));
                age.setText(String.valueOf(i.getAge()));
            }
        }
    }

    public void Login(View view){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

//    public void update(View view){
//        RealmResults<Contact_Model> results = MainActivity.realm.where(Contact_Model.class).equalTo("name", USERNAME).findAll();
//        for (Contact_Model i : results) {
//            i.setName(username.getText().toString());
//            i.setPhone(Integer.parseInt(phone.getText().toString()));
//            i.setAge(Integer.parseInt(age.getText().toString()));
//            username.setText(username.getText().toString());
//            phone.setText(phone.getText().toString());
//            age.setText(age.getText().toString());
//        }
//    }
}
