package jason.lee.foodjournal.commands;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import jason.lee.foodjournal.EntryActivity;

/**
 * Created by Jason on 10/31/2017.
 */

public class LaunchEntryActivity {
    public static final String DATE_KEY = "date";
    private Activity activity;
    private int month, day, year;

    public LaunchEntryActivity(Activity activity, int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void execute() {
        Intent intent = new Intent(activity, EntryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATE_KEY, month + "/" + day + "/" + year);
        activity.startActivity(intent);
    }
}
