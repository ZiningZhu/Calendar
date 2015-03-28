package com.example.ziningzhu.hackwestern;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


public class MonthViewActivity extends ActionBarActivity {
    public int firstDayThisMonthIsDay = 0;

    private int getFirstDayThisMonthIsDay(int day_of_week, int day_of_month) {
        // 1 means Sunday.7 means Saturday.
        return (day_of_month % 7 + day_of_week) % 7 + 1;
    }
    TextView days[];
    // When put into use, this should be the system time;
    // Since we are only dealing with a demonstrating month,
    // A magic number is plausible here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_view);
        Calendar c = Calendar.getInstance();
        days = new TextView[31];
        firstDayThisMonthIsDay = getFirstDayThisMonthIsDay(c.get(Calendar.DAY_OF_WEEK), c.get(Calendar.DAY_OF_MONTH));

        days[0] = (TextView)findViewById(R.id.day2);
        days[1] = (TextView)findViewById(R.id.day3);
        days[2] = (TextView)findViewById(R.id.day4);
        days[3] = (TextView)findViewById(R.id.day5);
        days[4] = (TextView)findViewById(R.id.day6);
        days[5] = (TextView)findViewById(R.id.day7);
        days[6] = (TextView)findViewById(R.id.day8);
        days[7] = (TextView)findViewById(R.id.day9);
        days[8] = (TextView)findViewById(R.id.day10);
        days[9] = (TextView)findViewById(R.id.day11);
        days[10] = (TextView)findViewById(R.id.day12);
        days[11] = (TextView)findViewById(R.id.day13);
        days[12] = (TextView)findViewById(R.id.day14);
        days[13] = (TextView)findViewById(R.id.day15);
        days[14] = (TextView)findViewById(R.id.day16);
        days[15] = (TextView)findViewById(R.id.day17);
        days[16] = (TextView)findViewById(R.id.day18);
        days[17] = (TextView)findViewById(R.id.day19);
        days[18] = (TextView)findViewById(R.id.day20);
        days[19] = (TextView)findViewById(R.id.day21);
        days[20] = (TextView)findViewById(R.id.day22);
        days[21] = (TextView)findViewById(R.id.day23);
        days[22] = (TextView)findViewById(R.id.day24);
        days[23] = (TextView)findViewById(R.id.day25);
        days[24] = (TextView)findViewById(R.id.day26);
        days[25] = (TextView)findViewById(R.id.day27);
        days[26] = (TextView)findViewById(R.id.day28);
        days[27] = (TextView)findViewById(R.id.day29);
        days[28] = (TextView)findViewById(R.id.day30);
        days[29] = (TextView)findViewById(R.id.day31);
        days[30] = (TextView)findViewById(R.id.day32);

        for(int i = 0; i < 30; ++i) {
            days[i].setText(String.format("%d", i));
            final int finali = i;
            days[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MonthViewActivity.this, DayViewActivity.this);
                    intent.putExtra("DATE", finali);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_month_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
