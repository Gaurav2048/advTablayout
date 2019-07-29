package com.example.advtablayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.advtablayout.Fragment.FirstFragment;
import com.example.advtablayout.Fragment.SecondFragment;

public class NextActivity extends AppCompatActivity implements DataInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        startFragmentTransition(new FirstFragment());


    }

    public void startFragmentTransition(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }


    @Override
    public void getMessage(String message) {
        if(message.equals("fistFragment")){
            startFragmentTransition(new FirstFragment());
        }else if(message.equals("secondFragment")){
            startFragmentTransition(new SecondFragment());
        }
    }
}
