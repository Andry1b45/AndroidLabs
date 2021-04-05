package com.kpi.Lab;

import android.content.Context;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class InputFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    interface OnFragmentSendDataListener {
        void onSendResult(String result);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment_layout, container, false);
        Button resultButton = view.findViewById(R.id.resultButton);

        resultButton.setOnClickListener(v -> {
            EditText question = view.findViewById(R.id.questionField);
            if (question.getText().toString().isEmpty())
                message("Your question is empty");
            else {
                RadioGroup answerRadioGroup = view.findViewById(R.id.answerRadioGroup);
                int answerId = answerRadioGroup.getCheckedRadioButtonId();
                String questionStr = question.getText().toString();
                if (answerId == -1) {
                    message( "Please, select answer");
                    fragmentSendDataListener.onSendResult("Please, select answer");
                } else {
                    String answer = "";
                    if(answerId == R.id.yesRadioButton){
                        answer = "yes";
                    }
                    else if(answerId == R.id.noRadioButton){
                        answer = "no";
                    }

                    String result = "Answer for question: " + questionStr + " is: " + answer;
                    fragmentSendDataListener.onSendResult(result);
                }
            }
        });
        return view;
    }


    private void message(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }



}
