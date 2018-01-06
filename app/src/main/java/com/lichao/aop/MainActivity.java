package com.lichao.aop;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟功能：用户行为统计
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lichao";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 摇一摇的模块
     * AOP方式
     * @param view
     */
    @BehaviorTrace(value = "摇一摇", type = 1)
    public void mShake(View view) {
        SystemClock.sleep(3000);
        Log.i(TAG,"  摇到一个嫩模：  约不约");
    }

    /**
     * 语音的模块
     * OOP方式
     * @param view
     */
    public void mAudio(View view) {
        long begin=System.currentTimeMillis();

        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG,"  美女  睡不着   热不热");
        }
        Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis() - begin) + "ms");
    }

    /**
     * 摇一摇的模块
     * OOP方式
     * @param view
     */
    public void mText(View view) {
        //统计用户行为 的逻辑
        Log.i(TAG, "文字：  使用时间：   "+simpleDateFormat.format(new Date()));
        long begin = System.currentTimeMillis();
        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG,"  热   我们去18");
        }
        Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis() - begin) + "ms");
    }
}
