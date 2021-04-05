package com.kpi.Lab;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentSendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onSendResult(String result) {
        ResultFragment fragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
        if (fragment != null)
            fragment.setSelectedItem(result);
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();
        resultFragment = new ResultFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.inputFragment, inputFragment);
        fragmentTransaction.replace(R.id.resultFragment, resultFragment);
        fragmentTransaction.commit();

        final Button button = (Button) findViewById(R.id.resultButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) inputFragment.getView().findViewById(R.id.questionField))
                        .getText().toString();
                int answerId = ((RadioGroup) inputFragment.getView().findViewById(R.id.
                        answerRadioGroup)).getCheckedRadioButtonId();

                if(answerId != -1){
                    String answer = ((RadioButton) inputFragment.getView().findViewById(answerId)).
                            getText().toString();
                    if (question.equals("")) {
                        ((TextView) resultFragment.getView().findViewById(R.id.result))
                                .setText("Your question is empty!");
                    }
                    else{
                        String text = "Your answer for question: \n" + question + "\nIs "
                                + answer;
                        ((TextView) resultFragment.getView().findViewById(R.id.result))
                                .setText(text);
                    }
                }
                else{
                    ((TextView) resultFragment.getView().findViewById(R.id.result)).setText("Your"+
                            " checkbox is empty!");
                }
            }
        });*/
}


