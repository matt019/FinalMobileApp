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

import static com.example.matt.finalproject.R.id.airPic;

/**
 * Air Activity Class allows user to choose a radio button of a sign
 * and see the description of it
 */
public class AirActivity extends AppCompatActivity {
    TextView head;
    TextView body;
    RadioButton gemButton, libButton, aquaButton;
    Button backButton;
    SignInfo info;
    ImageView air;


    /**
     * Adds the back button method to its cooresponding button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);

        body = (TextView)findViewById(R.id.airbody);
        body.setEnabled(false);
        gemButton = (RadioButton) findViewById(R.id.geminiRadio);
        libButton = (RadioButton) findViewById(R.id.libraRadio);
        aquaButton = (RadioButton) findViewById(R.id.aquaRadio);
        air = (ImageView) findViewById(R.id.airPic);

        info = new SignInfo();



        backButton();



    }

    /**
     * Button allows user to back to the main screen
     */
    protected void backButton() {
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
     * Implements radio buttons which will either give information on Gemini,
     * Libra, or Aquarius signs.
     *
     * Gets information from the Sign Info class
     *
     * Also adds toast pop-up messages
     *
     * @param view
     */
    public  void onRadioClick(View view)
    {

        boolean checked = ((RadioButton) view).isChecked();
            switch (view.getId())
            {
                case R.id.geminiRadio:
                    if(checked) {

                        body.setText(info.gemBody());
                        air.setImageResource(R.mipmap.gem_sign);


                        libButton.setChecked(false);
                        aquaButton.setChecked(false);

                        Toast.makeText(AirActivity.this,
                                "Nah", Toast.LENGTH_SHORT).show();




                    }
                    else
                    {

                        body.setEnabled(false);


                    }
                    break;

                case R.id.libraRadio:
                    if(checked) {

                        body.setText(info.libraBody());
                        air.setImageResource(R.mipmap.libra_sign);

                        gemButton.setChecked(false);
                        aquaButton.setChecked(false);

                        Toast.makeText(AirActivity.this,
                                "YES!", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {

                        body.setEnabled(false);


                    }
                    break;
                case R.id.aquaRadio:
                    if(checked) {

                        body.setText(info.aquaBody());
                        air.setImageResource(R.mipmap.aqua_sign);


                        gemButton.setChecked(false);
                        libButton.setChecked(false);
                        Toast.makeText(AirActivity.this,
                                "Sure", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {

                        body.setEnabled(false);


                    }
                    break;




            }


    }
}





