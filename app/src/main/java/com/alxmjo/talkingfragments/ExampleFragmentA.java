package com.alxmjo.talkingfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ExampleFragmentA extends Fragment {

    private EditText messageEditText;
    private Button sendTextButton;
    private String message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Views and onClickListeners are created and returned from the onCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_fragment_example, container, false);

        messageEditText = (EditText) view.findViewById(R.id.enter_message_edit_text);
        sendTextButton = (Button) view.findViewById(R.id.send_text_button);
        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = messageEditText.getText().toString();
                sendTextToFragment(message);
            }
        });

        return view;
    }

    private void sendTextToFragment(String string) {
        Fragment fragment = new ExampleFragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_STRING", string);
        fragment.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment) // Replace current fragment with new fragment
                .addToBackStack(null) // Make back button return to this fragment
                .commit();
    }
}