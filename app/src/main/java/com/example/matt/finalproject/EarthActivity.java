package com.example.matt.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Earth Activity Class allows user to choose a radio button of a sign
 * and see the description of it
 */
public class EarthActivity extends AppCompatActivity {

    TextView head;
    TextView body;
    RadioButton taurusButton, virgoButton, capButton;
    Button backButton;
    SignInfo info;
    ImageView earth;

    /**
     * Adds the back button method to its cooresponding button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth);

        body = (TextView)findViewById(R.id.earthbody);
        body.setEnabled(false);
        taurusButton = (RadioButton) findViewById(R.id.taurusRadio);
        virgoButton = (RadioButton) findViewById(R.id.virgoRadio);
        capButton = (RadioButton) findViewById(R.id.capRadio);
        earth = (ImageView) findViewById(R.id.earthPic);

        info = new SignInfo();

        backButton();
    }

    /**
     * Button allows user to back to the main screen
     */
    private void backButton() {
        // Set up the button to add a new fish using a seperate activity
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add fish activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(detailActIntent);


            }
        });
    }

    /**
     * Implements radio buttons which will either give information on Taurus,
     * Virgo, or Capricorn signs
     *
     * Gets information from the Sign Info class
     *
     * Also adds toast pop-up messages
     *
     * @param view
     */
    public void onRadioClick(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.taurusRadio:
                if(checked) {

                    body.setText(info.taurusBody());
                    earth.setImageResource(R.mipmap.taurus_sign);

                    capButton.setChecked(false);
                    virgoButton.setChecked(false);

                    Toast.makeText(EarthActivity.this,
                            "Um", Toast.LENGTH_SHORT).show();




                }
                else
                {

                    body.setEnabled(false);


                }
                break;

            case R.id.virgoRadio:
                if(checked) {

                    body.setText(info.virgoBody());
                    earth.setImageResource(R.mipmap.virgo_sign);


                    taurusButton.setChecked(false);
                    capButton.setChecked(false);

                    Toast.makeText(EarthActivity.this,
                            "Ok...", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;
            case R.id.capRadio:
                if(checked) {

                    body.setText(info.capBody());
                    earth.setImageResource(R.mipmap.cap_sign);

                    taurusButton.setChecked(false);
                    virgoButton.setChecked(false);

                    Toast.makeText(EarthActivity.this,
                            "Ha!", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;




        }


    }
}
