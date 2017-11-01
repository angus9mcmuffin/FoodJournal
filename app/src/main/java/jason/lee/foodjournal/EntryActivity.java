package jason.lee.foodjournal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jason.lee.foodjournal.commands.LaunchEntryActivity;

public class EntryActivity extends Activity {
    private int month, day, year;
    private int entryNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        String selectedDate = (String) getIntent().getSerializableExtra(LaunchEntryActivity.DATE_KEY);
        if (selectedDate != null) {
            String[] splitDate = selectedDate.split("/");
            month = Integer.valueOf(splitDate[0]);
            day = Integer.valueOf(splitDate[1]);
            year = Integer.valueOf(splitDate[2]);
        }

        displayEntry();
    }

    private void displayEntry() {
        String date = month + "/" + day + "/" + year;
        ((TextView) findViewById(R.id.selected_date)).setText(date);
        File entryFolder = new File(this.getFilesDir() + date + "/");
        File[] folderChildren = entryFolder.listFiles();
        TextView tv = new TextView(this);

        if (folderChildren.length == 0) {
            tv.setText("Entry not found");
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(folderChildren[entryNumber]));
                String sb = new String();
                while ((sb = bufferedReader.readLine()) != null) {
                    tv.append(sb + "\n");
                }
            } catch (FileNotFoundException e) {
                Log.e("entry", "not found");
            } catch (IOException e) {}

        }

        tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ((ViewGroup) getWindow().getDecorView()).addView(tv);
    }
}
