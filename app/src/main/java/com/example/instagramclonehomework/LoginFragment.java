package com.example.instagramclonehomework;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {

    AppCompatEditText emailAdress, password;
    AppCompatButton btnSignUp, buttonLogin;
    SQLiteDatabase db;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        emailAdress = view.findViewById(R.id.emailAdress);
        password = view.findViewById(R.id.password);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        btnSignUp = view.findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_loginFragment_to_signUpFragment);
            }
        });

        try {
            db = requireContext().openOrCreateDatabase("Login", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person(id INTEGER PRIMARY KEY, userName VARCHAR, emailAdress VARCHAR, password VARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textViewEmailAdress = emailAdress.getText().toString();
                String textViewPassword = password.getText().toString();

                Cursor cursor = db.rawQuery("SELECT * FROM person WHERE emailAdress=? AND password=?", new String[]{textViewEmailAdress, textViewPassword});
                if (cursor.moveToFirst()) {
                    Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_loginFragment_to_homeFragment);
                } else {
                    Toast.makeText(getContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });

        return view;
    }
}