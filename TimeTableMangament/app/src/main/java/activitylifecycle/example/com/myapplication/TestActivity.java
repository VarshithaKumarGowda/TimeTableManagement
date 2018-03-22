package activitylifecycle.example.com.myapplication;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import junit.framework.Test;

public class TestActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage);
    }
    public void log_out(View v)
    {

        Intent i = new Intent(this,Attendance_homePage.class);
        finish();
        startActivity(i);
    }
    public void manage_stud(View v)
    {
        Intent i = new Intent(this,ManageActivity.class);
        finish();
        startActivity(i);
    }
    public void mark_att(View v)
    {
        Intent i = new Intent(this,AttendanceActivity.class);
        startActivity(i);
    }
    public void view_att(View v)
    {
        Intent i = new Intent(this,ViewActivity.class);
        startActivity(i);
    }

    public void classes_bacthes(View v)
    {
        Intent i = new Intent(this, ListBatchesActivityTeacher.class);
        startActivity(i);;

    }

}