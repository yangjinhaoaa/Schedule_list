package com.example.schedule_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int flag = 0;
    int i = 0;

    private TextView TextView[] = new TextView[7];
    String tv[] = new String[]{"tv[1]", "tv[2]", "tv[3]", "tv[4]", "tv[5]", "tv[6]", "tv[7]"};


    private EditText input;
    private Context mContext;
    private SharedHelper sh;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {

        TextView[0] = (TextView) findViewById(R.id.TextView1_1);
        TextView[1] = (TextView) findViewById(R.id.TextView1_2);
        TextView[2] = (TextView) findViewById(R.id.TextView1_3);
        TextView[3] = (TextView) findViewById(R.id.TextView1_4);
        TextView[4] = (TextView) findViewById(R.id.TextView1_5);
        TextView[5] = (TextView) findViewById(R.id.TextView1_6);
        TextView[6] = (TextView) findViewById(R.id.TextView1_7);




        input = (EditText) findViewById(R.id.input);

        //设置监听器
        for(i=0;i<7;i++) {
            TextView[i].setOnClickListener(this);
        }
/*        TextView[0].setOnClickListener(this);
        TextView[1].setOnClickListener(this);*/

        //形成文件协助对象sh
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);

        //加载所有数据到activity
        for (i = 0; i < 7; i++) {
            TextView[i].setText(sh.read(tv[i]));
        }
    }

    void firstck(int i){
        input.setBackgroundColor(0xff0066cc);
        input.setFocusable(true);
        input.setFocusableInTouchMode(true);
        input.requestFocus();
        input.setVisibility(input.VISIBLE);
        TextView[i].setBackgroundColor(0xffcc9999);
        input.setText(TextView[i].getText());
        TextView[i].setText("");
    }
    void secoundck(int i){
        input.setFocusable(false);
        input.setVisibility(input.INVISIBLE);
        TextView[i].setText(input.getText());//input传到textview中,
        //实现保存到Sharedpreferences
        sh.save(tv[i], input.getText().toString());
        TextView[i].setBackgroundColor(0xff4EE29F);

    }
    @Override
    //实现点击功能
    public void onClick(View v) {



        switch (v.getId()) {
            case R.id.TextView1_1:
                i = 0;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_2:
                i = 1;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_3:
                i=2;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_4:
                i=3;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_5:
                i=4;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_6:
                i=5;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_7:
                i=6;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;


        }
    }
}
