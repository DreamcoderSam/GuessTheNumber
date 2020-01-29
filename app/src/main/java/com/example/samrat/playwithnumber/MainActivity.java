package com.example.samrat.playwithnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText userNmuber;
    Button guesNumber;
    int AppNumber, usergivennumber, uscore=0;
    // For Hint
    Button userHint;
    TextView userShowHint;

    // For Score
    TextView userScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // App Random number 1-10
        Random rand = new Random();
        AppNumber = rand.nextInt(10) + 1;

        userNmuber = findViewById(R.id.userInput);
        guesNumber = findViewById(R.id.play);
        // For hint
        userHint = findViewById(R.id.hint);
        userShowHint = findViewById(R.id.showhint);

        // For Score
        userScore = findViewById(R.id.score);

        guesNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userShowHint.setText(""); // Clear the Hint

               String userInNumber = userNmuber.getText().toString();
               // Convert user number String to Integer
                try {
                    usergivennumber = Integer.parseInt(userInNumber);
                }catch(Exception e){
                    // friendly error to the user: field is incorrect
                }
                //usergivennumber = Integer.parseInt(userInNumber);

                //Logic implementation
                if (usergivennumber<=0){
                    Toast.makeText(MainActivity.this, "Please input a Valid Number", Toast.LENGTH_SHORT).show();
                }
                else if (usergivennumber<AppNumber){
                    Toast.makeText(MainActivity.this, "Please input Higher Number", Toast.LENGTH_SHORT).show();
                }
                else if(usergivennumber>AppNumber){
                    Toast.makeText(MainActivity.this, "Please input Lower Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Congrats! You Win", Toast.LENGTH_SHORT).show();
                    userNmuber.setText(""); // Clear the input field

                   // Score Count
                    uscore = uscore+10;
                    String showuscore = String.valueOf(uscore);
                    userScore.setText(showuscore);

                    // Random number generation again
                    Random rand = new Random();
                    AppNumber = rand.nextInt(10) + 1;
                }
            }
        });
        // For Hint
        userHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minushint = AppNumber -1;
                String hintAppNumber = String.valueOf(minushint);
                userShowHint.setText("Your App Number is "+hintAppNumber+"+ 1. Try Now.");

            }
        });

    }
}
