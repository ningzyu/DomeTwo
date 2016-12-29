package com.example.zm.text3.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.util.JudgeUrl;

public class Activity16 extends BaseActivity {
    private LinearLayout layout;
    private EditText edit;
    private Button btn;
    private String Path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_16);
        initToolBar(getIntent().getStringExtra("string"), true);
        initView();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Path=edit.getText().toString();
                Log.i("Aaaaaaaaaaaaaaaaaaaaaa",Path+"-----编辑框--");
                JudgeUrl.Judge(Activity16.this,edit.getText().toString());
            }
        });

    }

    private void initView() {
        layout= (LinearLayout) findViewById(R.id.a16_layout);
        edit= (EditText) findViewById(R.id.a16_edit);
        btn= (Button) findViewById(R.id.a16_btn);

    }
}
