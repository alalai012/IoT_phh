package com.example.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerF_a extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private AlarmManager mAlarmManager;
    private Activity mactivity;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {//아침시간 입력 받아 TimePickerDialog
        mAlarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        mactivity = getActivity();//호출 액티비티를 불러오는거 맞나?
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getContext(), this, hour, minute,DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        updateTimeText(calendar);
        Intent intent = new Intent(getContext(), MainActivity.class); //test
        /*Intent intent = new Intent(getContext(), AlertReceiver.class);
        intent.getIntExtra("id",1);*/
        PendingIntent operation = PendingIntent.getActivity(getContext(), 0, intent,0);
        mAlarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),operation);
    }
    public void updateTimeText(Calendar c){
        String timeText = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT).format(c.getTime()); //DateFormat.SHORT 03:33PM 형식
        TextView mTextView = getActivity().findViewById(R.id.textView);
        mTextView.setText(timeText);
    }
}
