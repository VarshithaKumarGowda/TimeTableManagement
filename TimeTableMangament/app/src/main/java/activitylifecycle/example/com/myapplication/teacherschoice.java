package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by VarshithaKumarGowda on 16-03-2018.
 */

public class teacherschoice extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacherchoice);


        Button classbtn = (Button)findViewById(R.id.classes);
        // Register the onClick listener with the implementation above
        classbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i =  new Intent(teacherschoice.this, MainActivity.class);
                startActivity(i);
            }
        });

        Button managebtn = (Button)findViewById(R.id.manage);
        // Register the onClick listener with the implementation above
        managebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i =  new Intent(teacherschoice.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}
