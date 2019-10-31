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

    private TextView TextView[] = new TextView[49];
    String tv[] = new String[]{"tv[1]", "tv[2]", "tv[3]", "tv[4]", "tv[5]", "tv[6]", "tv[7]", "tv[8]", "tv[9]", "tv[10]", "tv[11]", "tv[12]", "tv[13]", "tv[14]", "tv[15]", "tv[16]", "tv[17]", "tv[18]", "tv[19]", "tv[20]", "tv[21]", "tv[22]", "tv[23]", "tv[24]", "tv[25]", "tv[26]", "tv[27]", "tv[28]", "tv[29]", "tv[30]", "tv[31]", "tv[32]", "tv[33]", "tv[34]", "tv[35]", "tv[36]", "tv[37]", "tv[38]", "tv[39]", "tv[40]", "tv[41]", "tv[42]", "tv[43]", "tv[44]", "tv[45]", "tv[46]", "tv[47]", "tv[48]", "tv[49]"};


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
        TextView[7] = (TextView) findViewById(R.id.TextView2_1);
        TextView[8] = (TextView) findViewById(R.id.TextView2_2);
        TextView[9] = (TextView) findViewById(R.id.TextView2_3);
        TextView[10] = (TextView) findViewById(R.id.TextView2_4);
        TextView[11] = (TextView) findViewById(R.id.TextView2_5);
        TextView[12] = (TextView) findViewById(R.id.TextView2_6);
        TextView[13] = (TextView) findViewById(R.id.TextView2_7);
        TextView[14] = (TextView) findViewById(R.id.TextView3_1);
        TextView[15] = (TextView) findViewById(R.id.TextView3_2);
        TextView[16] = (TextView) findViewById(R.id.TextView3_3);
        TextView[17] = (TextView) findViewById(R.id.TextView3_4);
        TextView[18] = (TextView) findViewById(R.id.TextView3_5);
        TextView[19] = (TextView) findViewById(R.id.TextView3_6);
        TextView[20] = (TextView) findViewById(R.id.TextView3_7);
        TextView[21] = (TextView) findViewById(R.id.TextView4_1);
        TextView[22] = (TextView) findViewById(R.id.TextView4_2);
        TextView[23] = (TextView) findViewById(R.id.TextView4_3);
        TextView[24] = (TextView) findViewById(R.id.TextView4_4);
        TextView[25] = (TextView) findViewById(R.id.TextView4_5);
        TextView[26] = (TextView) findViewById(R.id.TextView4_6);
        TextView[27] = (TextView) findViewById(R.id.TextView4_7);
        TextView[28] = (TextView) findViewById(R.id.TextView5_1);
        TextView[29] = (TextView) findViewById(R.id.TextView5_2);
        TextView[30] = (TextView) findViewById(R.id.TextView5_3);
        TextView[31] = (TextView) findViewById(R.id.TextView5_4);
        TextView[32] = (TextView) findViewById(R.id.TextView5_5);
        TextView[33] = (TextView) findViewById(R.id.TextView5_6);
        TextView[34] = (TextView) findViewById(R.id.TextView5_7);
        TextView[35] = (TextView) findViewById(R.id.TextView6_1);
        TextView[36] = (TextView) findViewById(R.id.TextView6_2);
        TextView[37] = (TextView) findViewById(R.id.TextView6_3);
        TextView[38] = (TextView) findViewById(R.id.TextView6_4);
        TextView[39] = (TextView) findViewById(R.id.TextView6_5);
        TextView[40] = (TextView) findViewById(R.id.TextView6_6);
        TextView[41] = (TextView) findViewById(R.id.TextView6_7);
        TextView[42] = (TextView) findViewById(R.id.TextView7_1);
        TextView[43] = (TextView) findViewById(R.id.TextView7_2);
        TextView[44] = (TextView) findViewById(R.id.TextView7_3);
        TextView[45] = (TextView) findViewById(R.id.TextView7_4);
        TextView[46] = (TextView) findViewById(R.id.TextView7_5);
        TextView[47] = (TextView) findViewById(R.id.TextView7_6);
        TextView[48] = (TextView) findViewById(R.id.TextView7_7);


        input = (EditText) findViewById(R.id.input);

        //设置监听器
        for (i = 0; i < 49; i++) {
            TextView[i].setOnClickListener(this);
        }
/*        TextView[0].setOnClickListener(this);
        TextView[1].setOnClickListener(this);*/

        //形成文件协助对象sh
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);

        //加载所有数据到activity
        for (i = 0; i < 49; i++) {
            TextView[i].setText(sh.read(tv[i]));
        }
    }

    void firstck(int i) {
        input.setBackgroundColor(0xff0066cc);
        input.setFocusable(true);
        input.setFocusableInTouchMode(true);
        input.requestFocus();
        input.setVisibility(input.VISIBLE);
        TextView[i].setBackgroundColor(0xffcc9999);
        input.setText(TextView[i].getText());
        TextView[i].setText("");
    }

    void secoundck(int i) {
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
                i = 2;
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
                i = 3;
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
                i = 4;
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
                i = 5;
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
                i = 6;
                if (flag == 0) {
                    //第一次点击
                    firstck(i);
                } else if (flag == 1) {
                    //第二次点击
                    secoundck(i);
                }
                flag = (flag + 1) % 2;//其余得到循环执行上面2个不同的功能
                break;
            case R.id.TextView2_1:
                i = 7;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_2:
                i = 8;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_3:
                i = 9;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_4:
                i = 10;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_5:
                i = 11;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_6:
                i = 12;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView2_7:
                i = 13;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_1:
                i = 14;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_2:
                i = 15;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_3:
                i = 16;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_4:
                i = 17;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_5:
                i = 18;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_6:
                i = 19;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView3_7:
                i = 20;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_1:
                i = 21;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_2:
                i = 22;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_3:
                i = 23;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_4:
                i = 24;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_5:
                i = 25;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_6:
                i = 26;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView4_7:
                i = 27;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_1:
                i = 28;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_2:
                i = 29;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_3:
                i = 30;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_4:
                i = 31;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_5:
                i = 32;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_6:
                i = 33;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView5_7:
                i = 34;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_1:
                i = 35;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_2:
                i = 36;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_3:
                i = 37;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_4:
                i = 38;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_5:
                i = 39;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_6:
                i = 40;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView6_7:
                i = 41;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_1:
                i = 42;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_2:
                i = 43;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_3:
                i = 44;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_4:
                i = 45;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_5:
                i = 46;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_6:
                i = 47;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.TextView7_7:
                i = 48;
                if (flag == 0) {
                    firstck(i);
                } else if (flag == 1) {
                    secoundck(i);
                }
                flag = (flag + 1) % 2;
                break;


        }
    }
}
