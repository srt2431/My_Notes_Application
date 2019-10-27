package com.example.insert_update_delete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText fullname, email_T,phone_T;
RadioGroup myRadioGroup;
RadioButton mySelectedRadioButton3;
RadioButton mySelectedRadioButton;
RadioButton mySelectedRadioButton1;
Button btnenter_data;
     String Value;
    MyDatabaseConnection database;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname=findViewById(R.id.fullName);
        email_T=findViewById(R.id.email);
        phone_T=findViewById(R.id.phone);

        myRadioGroup=findViewById(R.id.r);
        mySelectedRadioButton=findViewById(R.id.r1);
        mySelectedRadioButton1=findViewById(R.id.r2);
         id  = myRadioGroup.getCheckedRadioButtonId();
         mySelectedRadioButton3=findViewById(id);
         btnenter_data=findViewById(R.id.button);
         database = new MyDatabaseConnection(this);
         addData();
       /* validation();*/

            }

    public void onClick(View v) {
        Value =
                ((RadioButton) findViewById(myRadioGroup.getCheckedRadioButtonId()))
                        .getText().toString();



        /*if(Value.matches(""))
        {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            Log.d("QAOD", "Gender is Null");
        }
        else
        {
            Log.d("QAOD", "Gender is Selected");
        }*/

        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                // Toast.makeText(getBaseContext(), value, Toast.LENGTH_SHORT).show();
            }


        });
    }
    public void addData() {
                btnenter_data.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {

                        boolean isInserted = database.insertdata(fullname.getText().toString(),
                                email_T.getText().toString(), phone_T.getText().toString(),Value);
                              if(fullname.getText().toString().trim().equals("")){
                /*Toast.makeText(MainActivity.this,"Enter full name",Toast.LENGTH_LONG).show();*/
                              }
                        if(fullname.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter full name",Toast.LENGTH_LONG).show();
                        }
                       else if(email_T.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Email",Toast.LENGTH_LONG).show();}

                        else if(phone_T.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Phone",Toast.LENGTH_LONG).show();}

                        else if (myRadioGroup.getCheckedRadioButtonId() == -1)
                        {
                            Toast.makeText(MainActivity.this,"Select gender",Toast.LENGTH_SHORT).show();
                        }

                       /*else if(Value.trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Select Gender",Toast.LENGTH_LONG).show();}*/

                          else if (isInserted==true ) {

                            Intent intent = new Intent(MainActivity.this,Home.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(MainActivity.this, "Data insertion Failed", Toast.LENGTH_LONG).show();
                    }
                });
            }
          /*  public void validation(){
                btnenter_data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(fullname.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter full name",Toast.LENGTH_LONG).show();
                        }
                       *//* if(email_T.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Email",Toast.LENGTH_LONG).show();}
                        if(phone_T.getText().toString().trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Phone",Toast.LENGTH_LONG).show();}*//*
                       *//* if(Value.trim().equals("")){
                            Toast.makeText(MainActivity.this,"Enter Select Gender",Toast.LENGTH_LONG).show();*//*
                       // }
                    }
                });



            }*/

        }

