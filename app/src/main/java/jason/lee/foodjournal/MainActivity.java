package jason.lee.foodjournal;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import jason.lee.foodjournal.commands.LaunchEntryActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initializeCalendarView() {
        CalendarView cv = (CalendarView) findViewById(R.id.main_calendar);
        cv.setDate(System.currentTimeMillis());
        cv.setMaxDate(System.currentTimeMillis() + (24 * 60 * 60 * 1000)); // Set Tomorrow as the last changeable day
        cv.setSelectedWeekBackgroundColor(Color.WHITE);
        cv.setShowWeekNumber(false);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("MainActivity", String.format("Today is %d/%d/%d", month, dayOfMonth, year));
                new LaunchEntryActivity(MainActivity.this, month, dayOfMonth, year).execute();
            }
        });
    }
}
