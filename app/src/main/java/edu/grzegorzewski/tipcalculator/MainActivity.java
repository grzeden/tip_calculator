package edu.grzegorzewski.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create EditText and Button objects variables and initialize them to screen widgets.
        final EditText mealCost = (EditText) findViewById(R.id.editText1);
        final EditText taxPercentage = (EditText) findViewById(R.id.editText2);
        final EditText tipPercentage = (EditText) findViewById(R.id.editText3);
        final EditText mealTotalCost = (EditText) findViewById(R.id.editText4);
        Button calculateButton = (Button) findViewById(R.id.button1);

        // Calculate button listener.
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the input fields are populated.
                if (!mealCost.getText().toString().isEmpty()
                        & !taxPercentage.getText().toString().isEmpty()
                        & !tipPercentage.getText().toString().isEmpty()){

                    try {
                        // Calculate the total meal cost, including tip and tax.
                        double calculation = Double.parseDouble(mealCost.getText().toString())
                                + (Double.parseDouble(taxPercentage.getText().toString()) + Double.parseDouble(tipPercentage.getText().toString())
                                * (Double.parseDouble(mealCost.getText().toString())
                                / 100));
                        // Set the total meal cost field.
                        mealTotalCost.setText(String.valueOf(calculation));
                    }
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
