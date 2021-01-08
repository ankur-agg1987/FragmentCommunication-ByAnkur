package com.example.fragmentcommunication_byankur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.MyFragmentAListener, FragmentB.MyFragmentBListener{

    private FragmentA fa;
    private FragmentB fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fa = new FragmentA();
        fb = new FragmentB();

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.containerA, fa);
        ft.replace(R.id.containerB, fb);

        ft.commit();

    }

    @Override
    public void onInputASent(CharSequence c) {
        fb.updateEditTextofFragmentB(c);
    }

    @Override
    public void onInputBSent(CharSequence c) {
        fa.updateEditTextofFragmentA(c);
    }
}