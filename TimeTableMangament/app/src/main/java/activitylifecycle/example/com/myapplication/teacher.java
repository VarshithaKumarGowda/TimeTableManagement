package activitylifecycle.example.com.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class teacher extends Activity {

    private EditText Name;
    private EditText Password;
    private Button SignIn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher);

        Name = (EditText)findViewById(R.id.AdminName);
        Password = (EditText)findViewById(R.id.AdminPass);
        SignIn = (Button)findViewById(R.id.sin);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    public void admin_home(View v)
    {
        Intent i=new Intent(this,Admin_homeActivity.class);
        finish();
        startActivity(i);
    }

    private  void validate(String userN, String userP)
    {
        if ((userN.equals("Varshitha")) && (userP.equals("admin"))){
            Intent intent = new Intent(this, Admin_homeActivity.class);
            startActivity(intent);
        } else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

}