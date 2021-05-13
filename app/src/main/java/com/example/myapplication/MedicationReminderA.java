package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MedicationReminderA extends AppCompatActivity {
private TextView mTextView;
int i = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_reminder);

        mTextView =  findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button_timepicker_m);//아침 약 알림 시간 변경
        button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
                DialogFragment timePicker = new TimePickerF_a();
                timePicker.show(getSupportFragmentManager(), "time picker_1");
                }

                });

                Button buttonCancelAlarm = findViewById(R.id.button_cancel);
                buttonCancelAlarm.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v) {
               // cancelAlarm();
                }
                });
        }

/*
private void updateTimeText(Calendar c){
        //String timeText = "Alarm set for : ";
        String timeText = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime()); //DateFormat.SHORT 03:33PM 형식

        mTextView.setText(timeText);
        }
private void updateTimeText2(Calendar c){
        //String timeText = "Alarm set for : ";
        String timeText = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime()); //DateFormat.SHORT 03:33PM 형식

        mTextView.setText(timeText);
}

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.putExtra("type", i);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i++, intent, 0);//request++ :  HoUtils.createID()

        if(c.before((Calendar.getInstance()))){
        c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 1*60*1000 ,  pendingIntent);

        }

private void cancelAlarm(){
        int i =1;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i++, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
        }*/

        }