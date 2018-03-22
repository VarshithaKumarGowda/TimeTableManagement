package activitylifecycle.example.com.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class ClassSchedulerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmain);
        DBHelper dbhelper = new DBHelper(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.close();
        Toast.makeText(ClassSchedulerActivity.this, "In class scheduler", Toast.LENGTH_LONG).show();

         Intent intent = new Intent( ClassSchedulerActivity.this,ListBatchesActivity.class);
        startActivity(intent);

    }
}