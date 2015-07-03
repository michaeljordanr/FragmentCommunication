package com.example.michael.fragmentcommunication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TextFragment extends Fragment implements View.OnClickListener {

    private EditText edtText;
    private Button btnInverter;

    private OnInvertListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof OnInvertListener)){
            throw new RuntimeException("A activity deve implementar a interface TextFragment.OnInvertListener");
        }

        listener = (OnInvertListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        edtText = (EditText) view.findViewById(R.id.edt_texto);

        btnInverter = (Button) view.findViewById(R.id.btn_inverter);
        btnInverter.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
        {
            String texto = edtText.getText().toString();
            listener.onInvert(texto);
        }
    }

    public interface OnInvertListener {
        public void onInvert(String text);
    }
}
