package com.example.michael.fragmentcommunication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements TextFragment.OnInvertListener {

    private ResultFragment resultFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFrag = (ResultFragment) getFragmentManager().findFragmentById(R.id.frag_result);
    }

    @Override
    public void onInvert(String text) {
        resultFrag.invert(text);
    }
}
