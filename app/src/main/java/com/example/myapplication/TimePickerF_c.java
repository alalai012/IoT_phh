package com.example.myapplication;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerF_c extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {//점심시간 입력 받아 TimePickerDialog
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                (TimePickerDialog.OnTimeSetListener) getActivity(),
                hour, minute, DateFormat.is24HourFormat(getActivity()));

    }
}