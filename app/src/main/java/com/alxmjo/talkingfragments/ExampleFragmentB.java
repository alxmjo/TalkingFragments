package com.alxmjo.talkingfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragmentB extends Fragment {

    TextView textView;
    String message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString("EXTRA_STRING");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.b_fragment_example, container, false);
        textView = (TextView) view.findViewById(R.id.display_message_text_view);
        textView.setText(message);
        return view;
    }
}
