package com.kafwapteam.smartchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int presCounter = 0;
    private int maxPresCounter = 4;
    private String[] key = {"A", "R", "T", "C"};
    private String textAns = "CAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key = shuffle(key);

        for (String keys : key) {
            createView((LinearLayout) findViewById(R.id.llAnsChoice), keys, (EditText) findViewById(R.id.etShowAns));
        }
    }

    private void createView(LinearLayout viewParent, final String keys, final EditText ansView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.leftMargin = 20;

        final TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.backgroundpink));
        textView.setTextColor(this.getResources().getColor(R.color.cyan));
        textView.setGravity(Gravity.CENTER);
        textView.setText(keys);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter<maxPresCounter){
                    if (presCounter == 0){
                        ansView.setText("");

                        ansView.setText(ansView.getText().toString() + keys);
                    }
                }
            }
        });
    }

    private String[] shuffle(String[] key) {
        Random random = new Random();
        for (int i = key.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String val = key[index];
            key[index] = key[i];
            key[i] = val;
        }
        return key;
    }
}
