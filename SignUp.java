package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class SignUp extends AppCompatActivity {

    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        Realm.init(this);
        realm = MainActivity.realm;
    }

    public void createNewUser(View view){
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.password);
        EditText phone = findViewById(R.id.phone);
        EditText age = findViewById(R.id.age);
        boolean flag = false;
        if(!username.getText().toString().equalsIgnoreCase("") &&
                !email.getText().toString().equalsIgnoreCase("") &&
                !pass.getText().toString().equalsIgnoreCase("") &&
                !phone.getText().toString().equalsIgnoreCase("") &&
                !age.getText().toString().equalsIgnoreCase("")) {
            realm.beginTransaction();
            Contact_Model contact = realm.createObject(Contact_Model.class);
            contact.setName(username.getText().toString());
            contact.setEmail(email.getText().toString());
            contact.setPassword(pass.getText().toString());
            contact.setPhone(Integer.parseInt(phone.getText().toString()));
            contact.setAge(Integer.parseInt(age.getText().toString()));
            realm.commitTransaction();
//            Toast.makeText(this, "Database Created.", Toast.LENGTH_LONG);
        }
        else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Invalid Credentails.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void Login(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
