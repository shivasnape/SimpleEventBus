package com.snape.shivichu.sampleeventbus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.snape.shivichu.sampleeventbus.R;
import com.snape.shivichu.sampleeventbus.model.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);

    }

    public void clickMe(View v){
        EventBus.getDefault().postSticky(new MessageEvent(name.getText().toString(),email.getText().toString()));
        Intent intent = new Intent(this,NextActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
