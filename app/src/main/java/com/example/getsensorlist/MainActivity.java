package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTxtSensors;
    SensorManager sensorManager;
    List<Sensor> sensorList;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
        button = findViewById(R.id.retrieve_sensors_btn);
        //mTxtSensors.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); //가져온다
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        mTxtSensors.append("(# Sensors: " + sensorList.size() + ")\n\n");

        for(Sensor sensor : sensorList) {
            mTxtSensors.append("Sensor name: " + sensor.getName() + "\n");
            mTxtSensors.append("Sensor type: " + sensor.getType() + "\n\n");
        }
    }
}