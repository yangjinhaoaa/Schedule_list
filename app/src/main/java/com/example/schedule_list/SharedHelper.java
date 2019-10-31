//文件协助类,完成文件读写功能
package com.example.schedule_list;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SharedHelper {
    private Context mContext;
    public SharedHelper(){
    }

    public SharedHelper(Context mContext){
        this.mContext = mContext;
    }

    //定义保存数据的方法
    public void save(String name,String data) {
        SharedPreferences sp =mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();
        editor.putString(name,data);
        editor.commit();
    }

    public String read(String name){
        SharedPreferences sp =mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        return sp.getString(name,"");
    }
    /*
    public Map<String,String> read(){
        Map<String,String> data = new HashMap<String,String>();
        SharedPreferences sp =mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        data.put("classname",sp.getString("classname",""));
        //add new line in here data.put("")
        return data;
    }*/
}
