package activitylifecycle.example.com.myapplication;



import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Toast;

public class NotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notmain);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar)
    }



    public void write_date(View v)
    {
        String cd = "try1.txt";
        // Toast.makeText(this,cd, Toast.LENGTH_LONG).show();
        //String filenamesent = (cd).concat(classid);
        //Toast.makeText(this,filenamesent, Toast.LENGTH_LONG).show();
        Intent i =new Intent(NotifyActivity.this,Create_not.class);
        i.putExtra("filen",cd);
        startActivity(i);
    }
    public  void  read_date(View v)
    {
        String cd = "try1.txt";
        //Toast.makeText(this,cd, Toast.LENGTH_LONG).show();
        //String filenamesent = (cd).concat(classid);
        //Toast.makeText(this,filenamesent, Toast.LENGTH_LONG).show();
        Intent i =new Intent(NotifyActivity.this,Read_not.class);
        i.putExtra("filen",cd);
        startActivity(i);

    }
}
