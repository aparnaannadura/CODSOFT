package com.example.quoteapp;

        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butup;
    private TextView txt;
    private ImageView img;
    private int CurrentIndex = 0;
    private quote[] questionBank = new quote[]{
            new quote(R.string.my_quote1,true),
            new quote(R.string.my_quote2,true),
            new quote(R.string.my_quote3,false),
            new quote(R.string.my_quote4,false),
            new quote(R.string.my_quote5,true)
    };
    private Integer images[] = {R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butup = findViewById(R.id.butup);
        txt = findViewById(R.id.txt);
        img = findViewById(R.id.img);
        img.setImageResource(images[CurrentIndex]);
        butup.setOnClickListener(this);
           }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v == butup) {
            checkAns(false);
            CurrentIndex++;
            updateQue();
        }
    }

    private void updateQue() {
        if (CurrentIndex < questionBank.length) {
            txt.setText(questionBank[CurrentIndex].getAnsId());
            img.setImageResource(images[CurrentIndex]);
        } else {
            txt.setText("Thanks for Watching");
            butup.setVisibility(View.GONE);
            img.setVisibility(View.GONE);
        }
    }



    private static int correctCount = 0;

    private void checkAns(boolean uans) {
        if (CurrentIndex < questionBank.length) {
            boolean isTrue = questionBank[CurrentIndex].isAns();
            if (uans == isTrue) {
                correctCount++;
            }
        }
    }
}


