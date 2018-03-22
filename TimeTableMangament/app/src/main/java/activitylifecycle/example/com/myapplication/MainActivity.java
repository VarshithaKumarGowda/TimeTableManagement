package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


            // Get The Refference Of Buttons
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);

                Button buttonStart = (Button)findViewById(R.id.student);
                // Register the onClick listener with the implementation above
                buttonStart.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        Intent i =  new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                    }
                });

                Button buttonStop = (Button)findViewById(R.id.buttonSignUP);
                // Register the onClick listener with the implementation above
                buttonStop.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        Intent i =  new Intent(getApplicationContext(), Attendance_homePage.class);
                        startActivity(i);
                    }
                });
            }
    public void register(View v)
    {
        Intent i = new Intent(this,Register_adminActivity.class);
        startActivity(i);
    }



    }

