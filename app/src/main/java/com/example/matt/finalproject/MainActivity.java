package com.example.matt.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main activity class displays the menu the user opens to. It allows
 * them to choose between four different buttons types of signs, or create/sign into a firebase
 * account. Whichever button they choose will take them to a different screen
 */


public class MainActivity extends AppCompatActivity {


    Button airButton, waterButton, earthButton, fireButton, signInButton;

    /**
     * Adds the methods to their cooresponding buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        airButton();
        waterButton();
        earthButton();
        fireButton();
        SignInButton();




    }


    /**
     * Adds functionality to Air button and brings user to new screen
     */
    private void airButton() {
        // Set up the button to add a new fish using a seperate activity
        airButton = (Button) findViewById(R.id.airButton);
        airButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), AirActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });
    }

    /**
     * Adds functionality to Water button and brings user to new screen
     */
    private void waterButton() {
        // Set up the button to add a new fish using a seperate activity
        waterButton = (Button) findViewById(R.id.waterButton);
        waterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), WaterActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });
    }

    /**
     * Adds functionality to Earth button and brings user to new screen
     */
    private void earthButton() {
        // Set up the button to add a new fish using a seperate activity
        earthButton = (Button) findViewById(R.id.earthButton);
        earthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), EarthActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });
    }

    /**
     * Adds functionality to Fire button and brings user to new screen
     */
    private void fireButton() {
        // Set up the button to add a new fish using a seperate activity
        fireButton = (Button) findViewById(R.id.fireButton);
        fireButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), FireActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });
    }
    /**
     * Adds functionality to Sign button and brings user to new screen
     */
    protected void SignInButton() {
        // Set up the button to add a new fish using a seperate activity

        signInButton = (Button) findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), FirebaseActivity.class);
                finish();
                startActivity(detailActIntent);
            }
        });
    }
}

