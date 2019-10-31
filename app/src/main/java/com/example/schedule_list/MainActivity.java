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
    private TextView TextView[] = new TextView[8];
    String tv[] = new String[]{"", "tv[1]", "tv[2]", "tv[1]", "tv[2]", "tv[1]", "tv[2]", "tv[1]"};


    private EditText input;
    private Context mContext;
    private SharedHelper sh;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        TextView[1] = (TextView) findViewById(R.id.TextView1_1);
        TextView[2] = (TextView) findViewById(R.id.TextView1_2);


        input = (EditText) findViewById(R.id.input);

        //设置监听器
        TextView[1].setOnClickListener(this);
        TextView[2].setOnClickListener(this);


        //形成文件协助对象sh
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);

        //加载所有数据到activity
        for (i = 1; i <= 2; i++) {
            TextView[i].setText(sh.read(tv[i]));
        }
    }


    @Override
    //实现点击功能
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TextView1_1:
                i = 1;
                if (flag == 0) {
                    //第一次点击
                    input.setBackgroundColor(0xff0066cc);
                    input.setFocusable(true);
                    input.setFocusableInTouchMode(true);
                    input.requestFocus();
                    input.setVisibility(input.VISIBLE);
                    TextView[i].setBackgroundColor(0xffcc9999);
                    input.setText(TextView[i].getText());
                    TextView[i].setText("");
                } else if (flag == 1) {
                    //第二次点击
                    input.setFocusable(false);
                    input.setVisibility(input.INVISIBLE);
                    TextView[i].setText(input.getText());//input传到textview中,
                    //实现保存到Sharedpreferences
                    sh.save(tv[i], input.getText().toString());
                    TextView[i].setBackgroundColor(0xff4EE29F);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView1_2:
                i = 2;
                if (flag == 0) {
                    //第一次点击
                    input.setBackgroundColor(0xff0066cc);
                    input.setFocusable(true);
                    input.setFocusableInTouchMode(true);
                    input.requestFocus();
                    input.setVisibility(input.VISIBLE);
                    TextView[i].setBackgroundColor(0xffcc9999);
                    input.setText(TextView[i].getText());
                    TextView[i].setText("");
                } else if (flag == 1) {
                    //第二次点击
                    input.setFocusable(false);
                    input.setVisibility(input.INVISIBLE);
                    TextView[i].setText(input.getText());//input传到textview中,
                    //实现保存到Sharedpreferences
                    sh.save(tv[i], input.getText().toString());
                    TextView[i].setBackgroundColor(0xff4EE29F);


                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
        }
    }
}
