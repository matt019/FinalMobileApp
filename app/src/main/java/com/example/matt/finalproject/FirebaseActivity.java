package com.example.matt.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * Firebase Activity class allows user to sign up or
 * sign in to Firebase
 */
public class FirebaseActivity extends AppCompatActivity {

    TextView textViewStatus;
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignIn;
    Button buttonCreateLogin;
    Button buttonSignOut;
    Button backButton;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    final String Text = "Authentication failed";

    /**
     * Method sets up the mAuth method and adds functionality
     * to the back button, sign in/out, and create account buttons.
     * It also logs whether or not a user has
     * signed in or out
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        editTextEmail = (EditText) findViewById(R.id.txtEmail);
        editTextPassword = (EditText) findViewById(R.id.txtPass);
        buttonSignIn = (Button) findViewById(R.id.signInButton);
        buttonCreateLogin = (Button) findViewById(R.id.createButton);
        buttonSignOut = (Button) findViewById(R.id.signOutButton);
        backButton = (Button) findViewById(R.id.backButton);

        mAuth = FirebaseAuth.getInstance();
        final String TAG = "";

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });



        mAuthListener = new FirebaseAuth.AuthStateListener() {



            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
          /*
        This method creates a button that allows the user to sign in
         */
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Log.d("CIS3334", "normal login "); // main login
                signIn(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                editTextEmail.setText("");
                editTextPassword.setText("");

            }
        });



        /*
        This method creates a button that allows the user to create an account
         */
        buttonCreateLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.d("CIS3334", "Create Account "); // button to create an account
                createAccount(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                buttonSignIn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Log.d("CIS3334", "normal login "); // main login
                        signIn(editTextEmail.getText().toString(), editTextPassword.getText().toString());

                    }
                });
                editTextEmail.setText("");
                editTextPassword.setText("");

            }
        });


        /*
        This method creates a button that allows the user to sign out
         */
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.d("CIS3334", "Logging out - signOut "); //button to logout
                signOut();
                editTextEmail.setText("");
                editTextPassword.setText("");
            }
        });


    }

    /*
       This method works at the beginning of an event
        */
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    /*
        This method stops an event
         */
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /*
        This method allows the user to sign in
         */
    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful()); // Generic status message

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            textViewStatus.setText(Text);
                            //Toast.makeText(MainActivity.this, "Authentication failed.",
                            //Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }


    /*
       This method adds functionality to the sign in button
        */
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful()); //Sign in with email

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            //Log.w(TAG, "signInWithEmail", task.getException()); //Sign in with email
                            textViewStatus.setText(Text);
                            //Toast.makeText(MainActivity.this, "Authentication failed.",
                            //Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    /*
       This method lets the user sign out
        */
    private void signOut() {
        mAuth.signOut();

    }


    }












