package com.example.asus_pc.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tvAccelerometer;
    TextView tvMagentic;
    TextView tvLight;
    TextView tvOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获得SensorManager对象
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 注册加速度传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST);
        // 注册磁场传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_FASTEST);
        // 注册光线传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_FASTEST);
        // 注册方向传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_FASTEST);
        tvAccelerometer = (TextView) findViewById(R.id.tvAccelerometer);
        tvMagentic = (TextView) findViewById(R.id.tvMagentic);
        tvLight = (TextView) findViewById(R.id.tvLight);
        tvOrientation = (TextView) findViewById(R.id.tvOrientation);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // 通过getType方法获得当前传回数据的传感器类型
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER: // 处理加速度传感器传回的数据
                String accelerometer = "加速度\n" + "X：" + event.values[0] + "\n"
                        + "Y:" + event.values[1] + "\n" + "Z:" + event.values[2]
                        + "\n";
                tvAccelerometer.setText(accelerometer);
                break;
            case Sensor.TYPE_LIGHT: // 处理光线传感器传回的数据
                tvLight.setText("亮度：" + event.values[0]);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD: // 处理磁场传感器传回的数据
                String magentic = "磁场\n" + "X：" + event.values[0] + "\n" + "Y:"
                        + event.values[1] + "\n" + "Z:" + event.values[2] + "\n";
                tvMagentic.setText(magentic);
                break;
            case Sensor.TYPE_ORIENTATION: // 处理方向传感器传回的数据
                String orientation = "方向\n" + "X：" + event.values[0] + "\n" + "Y:"
                        + event.values[1] + "\n" + "Z:" + event.values[2] + "\n";
                tvOrientation.setText(orientation);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
