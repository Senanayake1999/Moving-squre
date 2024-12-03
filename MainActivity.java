package com.example.tapthesquare;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView timerText, scoreText;
    private Button squareButton;
    private int score = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timerText);
        scoreText = findViewById(R.id.scoreText);
        squareButton = findViewById(R.id.squareButton);

        // Start Game Timer
        new CountDownTimer(30000, 1000) { // 30 seconds countdown
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                squareButton.setEnabled(false); // Disable button after timer ends
                timerText.setText("Time's Up!");
            }
        }.start();

        // Handle Button Clicks
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreText.setText("Score: " + score);
                moveSquare(); // Move the square to a new position
            }
        });
    }

    // Move the square to a random position
    private void moveSquare() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) squareButton.getLayoutParams();
        params.leftMargin = random.nextInt(800); // Random horizontal position
        params.topMargin = random.nextInt(1200); // Random vertical position
        squareButton.setLayoutParams(params);
    }
}
