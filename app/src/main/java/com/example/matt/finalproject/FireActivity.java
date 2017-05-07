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
 * Fire Activity Class allows user to choose a radio button of a sign
 * and see the description of it
 */
public class FireActivity extends AppCompatActivity {
    TextView head;
    TextView body;
    RadioButton ariesButton, leoButton, sagButton;
    Button backButton;
    SignInfo info;
    ImageView fire;

    /**
     * Adds the back button method to its cooresponding button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        body = (TextView)findViewById(R.id.fireBody);
        body.setEnabled(false);
        ariesButton = (RadioButton) findViewById(R.id.radioAries);
        leoButton = (RadioButton) findViewById(R.id.radioLeo);
        sagButton = (RadioButton) findViewById(R.id.radioSag);
        fire = (ImageView) findViewById(R.id.firePic);

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
     * Implements radio buttons which will either give information on Aries,
     * Leo, or Sagittarius signs
     *
     * Gets information from the Sign Info class
     *
     * Also adds toast pop-up messages
     * @param view
     */
    public void onRadioClick(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.radioAries:
                if(checked) {
                    body.setText(info.ariesBody());
                    fire.setImageResource(R.mipmap.aries_sign);

                    leoButton.setChecked(false);
                    sagButton.setChecked(false);

                    Toast.makeText(FireActivity.this,
                            "Sure?", Toast.LENGTH_SHORT).show();




                }
                else
                {

                    body.setEnabled(false);


                }
                break;

            case R.id.radioLeo:
                if(checked) {
                    body.setText(info.leoBody());
                    fire.setImageResource(R.mipmap.leo_sign);

                    ariesButton.setChecked(false);
                    sagButton.setChecked(false);

                    Toast.makeText(FireActivity.this,
                            "Like", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;

            case R.id.radioSag:
                if(checked) {
                    body.setText(info.sagBody());
                    fire.setImageResource(R.mipmap.sag_info);

                    ariesButton.setChecked(false);
                    leoButton.setChecked(false);

                    Toast.makeText(FireActivity.this,
                            "Sometimes", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    body.setEnabled(false);


                }
                break;




        }


    }
}

