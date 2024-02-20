package com.example.kunnu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butn;
    private Button buty;
    private TextView txtq;
    private ImageView img;
    private int CurrentIndex = 0;
    private question[] questionBank = new question[]{
            new question(R.string.my_question1,true),
            new question(R.string.my_question2,true),
            new question(R.string.my_question3,true),
            new question(R.string.my_question4,true),
            new question(R.string.my_question5,true)
    };
    private Integer images[] = {R.mipmap.p1,R.mipmap.p2,R.mipmap.p3,R.mipmap.p4,R.mipmap.p5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butn = findViewById(R.id.butn);
        buty = findViewById(R.id.buty);
        txtq = findViewById(R.id.txtq);
        img  = findViewById(R.id.img);
        img.setImageResource(images[CurrentIndex]);
        butn.setOnClickListener(this);
        buty.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v == butn) {
            checkAns(false);
            updateQue();
        } else if (v == buty) {
            checkAns(true);
            updateQue();
        }
    }

    private void updateQue() {
        if (CurrentIndex < questionBank.length - 1) {
            CurrentIndex++; // Update index after displaying the question
            txtq.setText(questionBank[CurrentIndex].getAnsId());
            img.setImageResource(images[CurrentIndex]);
        } else {
            txtq.setText("Total Correct Ans : " + correctCount);
            buty.setVisibility(View.GONE);
            butn.setVisibility(View.GONE);
            img.setVisibility(View.GONE);
        }
    }

    private static int correctCount = 0;

    private void checkAns(boolean uans) {
        boolean isTrue = questionBank[CurrentIndex].isAns();
        if (uans == isTrue) {
            correctCount++;
        }
    }
}
