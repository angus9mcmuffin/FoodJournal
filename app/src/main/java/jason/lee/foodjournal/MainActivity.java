package jason.lee.foodjournal;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView cv = (CalendarView) findViewById(R.id.main_calendar);
        cv.setDate(System.currentTimeMillis());
        cv.setMaxDate(System.currentTimeMillis() + (24 * 60 * 60 * 1000)); // Set Tomorrow as the last changeable day
        cv.setSelectedWeekBackgroundColor(Color.WHITE);
        cv.setShowWeekNumber(false);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, String.format("Today is %d/%d/%d", month, dayOfMonth, year), Toast.LENGTH_SHORT).show();
                new LaunchEntryActivity().execute();
            }
        });
    }
}
