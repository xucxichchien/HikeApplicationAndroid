package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    String num;
    String operator;

    TextView mathView, resultView;

    MaterialButton buttonC, buttonLeftBracket, buttonRightBracket,
    buttonDivision, button8, button5, button6, buttonMultiply,
    button9, button10, button11, buttonMinus, button13, button14,
    button15, buttonPlus, button17, button18, button19, buttonEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultView = findViewById(R.id.resultView);
        mathView = findViewById(R.id.mathView);

        assignId(buttonC, R.id.buttonC);
        assignId(buttonLeftBracket, R.id.buttonLeftBracket);
        assignId(buttonRightBracket, R.id.buttonRightBracket);
        assignId(buttonDivision, R.id.buttonDivision);
        assignId(button8, R.id.button8);
        assignId(button5, R.id.button5);
        assignId(button6, R.id.button6);
        assignId(buttonMultiply, R.id.buttonMultiply);
        assignId(button9, R.id.button9);
        assignId(button10, R.id.button10);
        assignId(button11, R.id.button11);
        assignId(buttonMinus, R.id.buttonMinus);
        assignId(button13, R.id.button13);
        assignId(button14, R.id.button14);
        assignId(button15, R.id.button15);
        assignId(buttonPlus, R.id.buttonPlus);
        assignId(button17, R.id.button17);
        assignId(button18, R.id.button18);
        assignId(button19, R.id.button19);
        assignId(buttonEqual, R.id.buttonEqual);
    }

    void assignId (MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;

        String buttontext = button.getText().toString();
        String Calculation = mathView.getText().toString();

        if(buttontext.equals("AC")){
            mathView.setText("");
            resultView.setText("");
            return;
        }
        if(buttontext.equals("=")){
            mathView.setText(resultView.getText());
            return;
        }
        if(buttontext.equals("C")){
            Calculation = Calculation.substring(0, Calculation.length()-1);S

        } else {
            Calculation = Calculation + buttontext;
        }

        mathView.setText(Calculation);

        String Result = getResult(Calculation);
        if(!Result.equals("Error")){
            resultView.setText(Result);
        }
    }
    String getResult (String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
           String Result = context.evaluateString(scriptable,data, "Javascript", 1, null).toString();
           return Result;
        }catch(Exception e){
            return "Error";
        }

    }
}