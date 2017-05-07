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
 * Water Activity Class allows user to choose a radio button of a sign
 * and see the description of it
 */
public class WaterActivity extends AppCompatActivity {

    TextView head;
    TextView body;
    RadioButton piscesButton, cancerButton, scorpioButton;
    Button backButton;
    SignInfo info;
    ImageView water;


    /**
     * Adds the back button method to its cooresponding button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


        body = (TextView)findViewById(R.id.waterBody);
        body.setEnabled(false);
        piscesButton = (RadioButton) findViewById(R.id.piscesRadio);
        cancerButton = (RadioButton) findViewById(R.id.cancerRadio);
        scorpioButton = (RadioButton) findViewById(R.id.scorpioRadio);

        water = (ImageView) findViewById(R.id.waterPic);
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
     * Implements radio buttons which will either give information on Pisces,
     * Cancer, or Scorpio signs
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
            case R.id.piscesRadio:
                if(checked) {

                    body.setText(info.pisBody());
                    water.setImageResource(R.mipmap.pisces_sign);



                    cancerButton.setChecked(false);
                    scorpioButton.setChecked(false);

                    Toast.makeText(WaterActivity.this,
                            "Erm", Toast.LENGTH_SHORT).show();




                }
                else
                {

                    body.setEnabled(false);


                }
                break;

            case R.id.cancerRadio:
                if(checked) {

                    body.setText(info.cancerBody());
                    water.setImageResource(R.mipmap.cancer_sign);



                    piscesButton.setChecked(false);
                    scorpioButton.setChecked(false);

                    Toast.makeText(WaterActivity.this,
                            "Meh", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;
            case R.id.scorpioRadio:
                if(checked) {

                    body.setText(info.scorpioBody());
                    water.setImageResource(R.mipmap.scorpio_sign);



                    piscesButton.setChecked(false);
                    cancerButton.setChecked(false);

                    Toast.makeText(WaterActivity.this,
                            "Yikes", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;




        }


    }
}
