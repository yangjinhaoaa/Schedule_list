package com.example.schedule_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int flag = 0;
    private TextView TextView1_1;
    private TextView TextView1_2;
    private TextView TextView1_3;
    private TextView TextView1_4;
    private TextView TextView1_5;
    private TextView TextView1_6;
    private TextView TextView1_7;
    private EditText input;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        TextView1_1 = (TextView) findViewById(R.id.TextView1_1);
        TextView1_2 = (TextView) findViewById(R.id.TextView1_2);
        TextView1_3 = (TextView) findViewById(R.id.TextView1_3);
        TextView1_4 = (TextView) findViewById(R.id.TextView1_4);
        TextView1_5 = (TextView) findViewById(R.id.TextView1_5);
        TextView1_6 = (TextView) findViewById(R.id.TextView1_6);
        TextView1_7 = (TextView) findViewById(R.id.TextView1_7);
        input = (EditText) findViewById(R.id.input);

        //设置监听器
        TextView1_1.setOnClickListener(this);
        TextView1_2.setOnClickListener(this);
        TextView1_3.setOnClickListener(this);
        TextView1_4.setOnClickListener(this);
        TextView1_5.setOnClickListener(this);
        TextView1_6.setOnClickListener(this);
        TextView1_7.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TextView1_1:
                if (flag == 0) {
                    input.setBackgroundColor(0xff0066cc);
                    input.setFocusable(true);
                    input.setFocusableInTouchMode(true);
                    input.requestFocus();
                    input.setVisibility(input.VISIBLE);
                    TextView1_1.setBackgroundColor(0xffcc9999);
                    input.setText(TextView1_1.getText());
                    TextView1_1.setText("");



                } else if (flag == 1) {
                    input.setFocusable(false);
                    input.setVisibility(input.INVISIBLE);
                    TextView1_1.setText(input.getText());//input传到textview中,
                    //实现保存到Sharedpreferences


                    TextView1_1.setBackgroundColor(0xff4EE29F);


                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_2:
                if (flag == 0) {
                    input.setBackgroundColor(0xff0066cc);
                    input.setFocusable(true);
                    input.setFocusableInTouchMode(true);
                    input.requestFocus();
                    input.setVisibility(input.VISIBLE);
                    TextView1_2.setBackgroundColor(0xffcc9999);
                    input.setText(TextView1_2.getText());
                    TextView1_2.setText("");


                } else if (flag == 1) {
                    input.setFocusable(false);
                    input.setVisibility(input.INVISIBLE);
                    TextView1_2.setText(input.getText());
                    TextView1_2.setBackgroundColor(0xff4EE29F);

                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_3:
                if (flag == 0) {
                    input.setBackgroundColor(0xff0066cc);
                    input.setFocusable(true);
                    input.setFocusableInTouchMode(true);
                    input.requestFocus();
                    input.setVisibility(input.VISIBLE);
                    TextView1_3.setBackgroundColor(0xffcc9999);
                    input.setText(TextView1_3.getText());
                    TextView1_3.setText("");


                } else if (flag == 1) {
                    input.setFocusable(false);
                    input.setVisibility(input.INVISIBLE);
                    TextView1_3.setText(input.getText());
                    TextView1_3.setBackgroundColor(0xff4EE29F);

                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
        }
    }
}
//public class MainActivity extends AppCompatActivity {
//
//    final TextView TextView1_1 = findViewById(R.id.TextView1_1);
//    final EditText input1 = findViewById(R.id.input);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //button.setBackgroundResource(R.drawable.ic_launcher_foreground);
//
//
//
//        TextView1_1.setOnClickListener(new View.OnClickListener(){
//
//            //@Override
//            int flag = 0;
//            public void onClick(View v) {
//
//                if(flag==0){
//                    input1.setBackgroundColor(0xff0066cc);
//                    input1.setFocusable(true);
//                    input1.setFocusableInTouchMode(true);
//                    input1.requestFocus();
//                    input1.setVisibility(input1.VISIBLE);
//                    TextView1_1.setBackgroundColor(0xffcc9999);
//                    input1.setText(TextView1_1.getText());
//                    TextView1_1.setText("");
//
//
//                }else if(flag==1){
//                    input1.setFocusable(false);
//                    input1.setVisibility(input1.INVISIBLE);
//                    TextView1_1.setText(input1.getText());
//                    TextView1_1.setBackgroundColor(0xff4EE29F);
//
//                }
//
//                flag=(flag+1)%2;//其余得到循环执行上面3个不同的功能
//
//            }
//
//        });
//
//
////        TextView1_1.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                // Code here executes on main thread after user presses button
////                input1.setBackgroundColor(0x99CC66);
////                input1.setText("please input message in here");
////                TextView1_1.setOnClickListener(new View.OnClickListener() {
////                    public void onClick(View v) {
////                        // Code here executes on main thread after user presses button
////                        input1.setBackgroundColor(0x00FFCC99);
////                        TextView1_1.setText(input1.getText());
////                        input1.setTextColor(0x00FFFFFF);
////
////                    }
////                });
////            }
////        });
//    }
//}
//
