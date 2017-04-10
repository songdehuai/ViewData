package com.songdehuai.viewdata;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.songdehuai.viewdata.viewmodel.ButtonM;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Realm realm;
    LinearLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    List<ButtonM> buttonMList;

    void init() {
        mainView = (LinearLayout) findViewById(R.id.main_view);
        buttonMList = new ArrayList<>();
        realm = Realm.getDefaultInstance();
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm.beginTransaction();
                ButtonM buttonM = realm.createObject(ButtonM.class);
                buttonM.setTEXT("测试按钮001");
                buttonM.setBG_COLOR("ffffff");
                buttonM.setTEXT_SIZE("16");
                buttonM.setALIGN("center");
                realm.commitTransaction();

                RealmResults<ButtonM> buttonMList = realm.where(ButtonM.class)
                        .findAll();

                String text = buttonMList.get(0).getTEXT();

                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                initButtonM(buttonMList);
            }
        });
    }


    void initButtonM(final List<ButtonM> buttonMList) {
        for (int i = 0; i < buttonMList.size(); i++) {
            Button btnTemp = new Button(getApplicationContext());
            btnTemp.setText(buttonMList.get(i).getTEXT());
            btnTemp.setTextSize(Float.parseFloat(buttonMList.get(i).getTEXT_SIZE()));
            switch (buttonMList.get(i).getALIGN()) {
                case "center":
                    btnTemp.setGravity(Gravity.CENTER);
                    break;
                case "left":
                    btnTemp.setGravity(Gravity.LEFT);
                    break;
                case "right":
                    btnTemp.setGravity(Gravity.RIGHT);
                    break;
            }
            final int finalI = i;
            btnTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), buttonMList.get(finalI).getTEXT(), Toast.LENGTH_SHORT).show();
                }
            });
            //   btnTemp.setBackgroundColor(Color.parseColor("#" + buttonMList.get(i).getBG_COLOR()));
            mainView.addView(btnTemp);
        }
    }
}
