package com.example.instagramclonehomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class SignUpFragment extends Fragment {

    AppCompatEditText editTextUserName, editTextEmailAdress, editTextPassword;
    AppCompatButton buttonSignUp;
    SQLiteDatabase db;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        editTextUserName = view.findViewById(R.id.editTextUserName);
        editTextEmailAdress = view.findViewById(R.id.editTextEmailAdress);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);

        try {
            db = requireContext().openOrCreateDatabase("Login", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person(id INTEGER PRIMARY KEY, userName VARCHAR, emailAdress VARCHAR, password VARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString();
                String emailAdress = editTextEmailAdress.getText().toString();
                String password = editTextPassword.getText().toString();
                Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();

                ContentValues values = new ContentValues();
                values.put("userName", userName);
                values.put("emailAdress", emailAdress);
                values.put("password", password);
                db.insert("person", null, values);

                editTextUserName.setText("");
                editTextEmailAdress.setText("");
                editTextPassword.setText("");

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_signUpFragment_to_loginFragment);
            }
        });

        Cursor cursor = db.rawQuery("SELECT * FROM person", null);
        int id = cursor.getColumnIndex("id");
        int userName = cursor.getColumnIndex("userName");
        int emailAdress = cursor.getColumnIndex("emailAdress");
        int password = cursor.getColumnIndex("password");
        while (cursor.moveToNext()) {
            Log.d("SignUpFragment", "id: " + id + ", userName: " + userName + ", emailAdress: " + emailAdress + ", password: " + password);
        }
        cursor.close();

        return view;
    }
}