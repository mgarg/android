package com.example.testAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class testActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView result = (TextView) findViewById(R.id.result_box);
                EditText type = (EditText) findViewById(R.id.unit_type);
                EditText unit1 = (EditText) findViewById(R.id.unit1);
                EditText value1 = (EditText) findViewById(R.id.value1);
                EditText unit2 = (EditText) findViewById(R.id.unit2);
                Convert c = new Convert();
                c.init();
                String t = type.getText().toString();
                String u1 = unit1.getText().toString();
                String v1 = value1.getText().toString();
                double v2 = Double.parseDouble(v1);
                String u2 = unit2.getText().toString();
                double res = c.convert(t,u1,v2,u2);
                result.setText(Double.toString(res));
            }
        });


    }
}
