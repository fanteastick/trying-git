package com.example.ella_incognito.gradecalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    EditText currentGrade;
    EditText wantedGrade;
    EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentGrade = (EditText) findViewById(R.id.current_grade);
        wantedGrade = (EditText) findViewById(R.id.desired_grade);
        weight = (EditText) findViewById(R.id.weight);

        double numCurrent = Double.valueOf(currentGrade.getText().toString());
        double numWanted = Double.valueOf(wantedGrade.getText().toString());
        double numWeight = Double.valueOf(weight.getText().toString());
        double neededGrade = (numWanted - (1-numWeight)(numCurrent))/numWeight;
        Toast.makeText(MainActivity.this, "Hello " + neededGrade, Toast.LENGTH_LONG);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
