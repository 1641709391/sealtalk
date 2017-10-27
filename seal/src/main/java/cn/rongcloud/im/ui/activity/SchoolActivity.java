package cn.rongcloud.im.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.rongcloud.im.R;

/**
 * Created by 皓旭 on 2017/9/20.
 */

public class SchoolActivity extends BaseActivity {
    private Button roundBtn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        setTitle("学校");
        roundBtn10= (Button) findViewById(R.id.roundBtn10);
        roundBtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SchoolActivity.this,JianzhiActivity.class);
                startActivity(intent);
            }
        });
    }
}

