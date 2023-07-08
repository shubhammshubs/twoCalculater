package com.example.twocalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button buttonBirthDate;
    private TextView textViewBirthDate;
    private Button buttonBirthDate2;
    private TextView textViewBirthDate2;
    private Button buttonSubmit;
    private TextView textViewResult;

    private int selectedYear, selectedMonth, selectedDay;
    private int selectedYear2, selectedMonth2, selectedDay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonBirthDate = findViewById(R.id.buttonBirthDate);
        textViewBirthDate = findViewById(R.id.textViewBirthDate);
        buttonBirthDate2 = findViewById(R.id.buttonBirthDate2);
        textViewBirthDate2 = findViewById(R.id.textViewBirthDate2);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);


        //        Birth Date selection
        buttonBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                selectedYear = calendar.get(Calendar.YEAR);
                selectedMonth = calendar.get(Calendar.MONTH);
                selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                selectedYear = year;
                                selectedMonth = monthOfYear;
                                selectedDay = dayOfMonth;
                                textViewBirthDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, selectedYear, selectedMonth, selectedDay);
                datePickerDialog.show();
            }
        });
        //        Birth Date selection 2
        buttonBirthDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                selectedYear2 = calendar.get(Calendar.YEAR);
                selectedMonth2 = calendar.get(Calendar.MONTH);
                selectedDay2 = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                selectedYear2 = year;
                                selectedMonth2 = monthOfYear;
                                selectedDay2 = dayOfMonth;
                                textViewBirthDate2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, selectedYear2, selectedMonth2, selectedDay2);
                datePickerDialog.show();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String string1 = textViewBirthDate.getText().toString();
//                String string2 = textViewBirthDate2.getText().toString();
//
//                int number1 = Integer.parseInt(string1);
//                int number2 = Integer.parseInt(string2);
//                int result = number1 - number2;
////                String result = string1  string2;
//                String ans = String.valueOf(result);
//                textViewResult.setText(ans);

                Calendar textViewBirthDate = Calendar.getInstance();
                textViewBirthDate.set(selectedYear, selectedMonth, selectedDay);

                Calendar textViewBirthDate2 = Calendar.getInstance();
                textViewBirthDate2.set(selectedYear2, selectedMonth2, selectedDay2);
                long differenceInMillis = Math.abs(textViewBirthDate.getTimeInMillis() - textViewBirthDate2.getTimeInMillis());

                long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);

                textViewResult.setText("Difference in days: " + differenceInDays);
            }
        });
    }
}