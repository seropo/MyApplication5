package com.nwebtekno.sewaapps.myapplication.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nwebtekno.sewaapps.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextInputEditText eusername,epassword;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eusername=((TextInputEditText)this.findViewById(R.id.eusername));
        epassword=((TextInputEditText)this.findViewById(R.id.epass));
        btnSubmit=((Button)this.findViewById(R.id.btnSubmit));
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case (int)R.id.btnSubmit:
                if(eusername.getText().toString().equals("")){
                    eusername.setError("Please Input Username");
                }else if(epassword.getText().toString().equals("")){
                    epassword.setError("Please Input Password");
                }else{
                    startActivity(new Intent(MainActivity.this,HomeActvity.class));
                }
                break;
        }
    }
}
