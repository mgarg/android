package com.example.testAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class testActivity extends Activity {
    private Convert converter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button b = (Button) findViewById(R.id.button);
        converter = new Convert();

        ArrayList<String> cats = new ArrayList<String>(converter.getCategoryList());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cats);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner categoryList = (Spinner) findViewById(R.id.categoryList);
        categoryList.setAdapter(arrayAdapter);

        final Activity baseActivityClass = this;
        categoryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                   String cat = (String) adapterView.getItemAtPosition(i);
                   ArrayList<String> units = new ArrayList<String>(converter.getUnitList(cat));
                   ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(baseActivityClass, android.R.layout.simple_spinner_item, units);
                   arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   final Spinner unitList1 = (Spinner) findViewById(R.id.unitList1);
                   unitList1.setAdapter(arrayAdapter2);
                   final Spinner unitList2 = (Spinner) findViewById(R.id.unitList2);
                   unitList2.setAdapter(arrayAdapter2);
               }

               @Override
               public void onNothingSelected(AdapterView<?> adapterView) {

               }
           });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView result = (TextView) findViewById(R.id.result_box);
                String t = getSelectedItem(R.id.categoryList);
                //Spinner unit1 = (Spinner) findViewById(R.id.unitList1);
                String u1 = getSelectedItem(R.id.unitList1);
                EditText value1 = (EditText) findViewById(R.id.value1);
                String u2 = getSelectedItem(R.id.unitList2);
                String v1 = value1.getText().toString();
                double v2 = Double.parseDouble(v1);
                double res = converter.convert(t, u1, v2, u2);
                result.setText(Double.toString(res));
            }
        });


    }

    private String getSelectedItem(int spinnerId) {
        Spinner type = (Spinner) findViewById(spinnerId);
        return (String) type.getSelectedItem();
    }
}
