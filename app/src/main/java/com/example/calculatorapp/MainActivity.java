package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


enum Operator
{

    Add("+"){
        @Override
        public double execute(double f, double n) {
            return f+n;
        }
    },

    Division("-"){
        @Override
        public double execute(double f, double n) {
            return f-n;
        }
    },
    Extract("*"){
        @Override
        public double execute(double f, double n) {
            return f*n;
        }
    },

    Div("/"){
        @Override
        public double execute(double f, double n) {
            return f/n;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator=operator;
    }

    public abstract  double execute(double f, double n);

    @Override public String toString() {
        return operator;
    }
}
public class MainActivity extends AppCompatActivity {
    private EditText firstNumber,secondNumber,result;


    private void MakeOperationByClickListener(Button button, final Operator operator){
        button.setOnClickListener(new View.OnClickListener() {
            String fnt=firstNumber.getText().toString();
            String snt=secondNumber.getText().toString();
            @Override
            public void onClick(View v) {
                if(firstNumber.toString().equals("") || secondNumber.toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter some numbers",Toast.LENGTH_SHORT)
                            .show();
                }

                else{
                    double fn=Double.parseDouble(fnt);
                    double sn=Double.parseDouble(snt);

                    double r=operator.execute(fn,sn);

                    result.setText(String.valueOf(r));

                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.toplama);
        Button division = (Button) findViewById(R.id.cikarma);
        Button extract = (Button) findViewById(R.id.carpma);
        Button div = (Button) findViewById(R.id.bolme);

        firstNumber=(EditText)findViewById(R.id.ilk_sayi_metin);
        secondNumber=(EditText)findViewById(R.id.ikinci_sayi_text);
        result=(EditText)findViewById(R.id.sonuc_metin);

        MakeOperationByClickListener(add,Operator.Add);
        MakeOperationByClickListener(division,Operator.Division);
        MakeOperationByClickListener(extract,Operator.Extract);
        MakeOperationByClickListener(div,Operator.Div);
    }
}
