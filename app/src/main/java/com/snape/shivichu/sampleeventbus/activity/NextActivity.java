package com.snape.shivichu.sampleeventbus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.snape.shivichu.sampleeventbus.R;
import com.snape.shivichu.sampleeventbus.model.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * *created by Shivichu 02-03-2019
 **/


public class NextActivity extends AppCompatActivity {
    TextView text,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        text = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        text.setText(event.getName());
        email.setText(event.getEmail());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
