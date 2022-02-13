package com.example.descubraonumero;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final static int MAX_RANDOM = 100;
    EditText tip;
    EditText hiddenTxtValue;
    EditText value;
    int answer = generateRandomNumber(MAX_RANDOM);
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tip = findViewById(R.id.txtTip);
        hiddenTxtValue = findViewById(R.id.edtHiddenValue);
        value = findViewById(R.id.edtValue);
    }

    public void sendBtnClick(View v){
        int playerAnswer = Integer.parseInt(value.getText().toString());
        if (playerAnswer == answer){
            hiddenTxtValue.setText("CONGRATULATIONS");
            tip.setText("Play again??");
            mp = MediaPlayer.create(MainActivity.this,R.raw.correct);
            mp.start();
        } else {
            hiddenTxtValue.setText("WRONG");
            mp = MediaPlayer.create(MainActivity.this, R.raw.error);
            mp.start();

            if (playerAnswer < answer){
                tip.setText("the correct value is biggen than " + playerAnswer);
            }else {
                tip.setText("The correct value is smaller than " + playerAnswer);
            }
            value.setText("");
            value.requestFocus();
        }
    }

    public void newBtnClick(View v){
        tip.setText("the value is between 1 and "+ MAX_RANDOM);
        hiddenTxtValue.setText("?");
        value.setText("");
        value.requestFocus();
        answer = generateRandomNumber(MAX_RANDOM);
    }

    public int generateRandomNumber(int num){
        Random generateNum = new Random();
        return generateNum.nextInt(num);
    }

}