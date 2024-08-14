package com.example.average;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int[] arr=new int[5];
    EditText et;
    TextView tv;
    int i=0;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("SetTextI18n")
    public void average(View view) {
        et=findViewById(R.id.edt);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);
        if(i<5) {
            int no = Integer.parseInt(et.getText().toString());
            arr[i] = no;
            i++;
            et.setText("");

        }else if(i==5){
            et.setVisibility(View.INVISIBLE);
            btn.setText("Calculate Average");
            tv.setText("Average Will Appear Here");
            i++;
        }
        else {
            calculateAvg(arr,tv);
        }


    }

    @SuppressLint("SetTextI18n")
    private void calculateAvg(int[] arr, TextView tv) {
        int sum=0;
        for (int j : arr) {
            sum += j;
        }
        int avgVal=sum/ arr.length;
        tv.setText("Average :"+avgVal);

    }


}