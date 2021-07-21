package kr.hs.emirim.w2034.project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView imgV = findViewById(R.id.imgv);
        TextView text1 = findViewById(R.id.text_result1);
        TextView text2 = findViewById(R.id.text_result2);
        Intent intent = getIntent();
        double w = intent.getDoubleExtra("weight", 0);
        double h = intent.getDoubleExtra("height", 0);
        double bmi = w / Math.pow((h/100),2);

        String bmiStr = "";
        int imgSrcId = 0;

        if(bmi < 18.5){
            bmiStr = "저체중";
            imgSrcId = R.drawable.bmi1;
        }else if(bmi < 24.9){
            bmiStr = "정상";
            imgSrcId = R.drawable.bmi2;
        }else if(bmi < 29.9){
            bmiStr = "과체중";
            imgSrcId = R.drawable.bmi3;
        }else if(bmi < 34.9){
            bmiStr = "비만";
            imgSrcId = R.drawable.bmi4;
        }else{
            bmiStr = "고도비만";
            imgSrcId = R.drawable.bmi5;
        }
        imgV.setImageResource(imgSrcId);
        text1.setText(bmiStr + "체중");
    }
}