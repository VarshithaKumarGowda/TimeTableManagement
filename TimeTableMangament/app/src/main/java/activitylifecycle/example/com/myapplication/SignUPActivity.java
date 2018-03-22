package activitylifecycle.example.com.myapplication;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity
{
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Intent intentSignUP=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intentSignUP);
                }
            }
        });
    }

    public void existinguser(View v)
    {
            final Dialog dialog = new Dialog(SignUPActivity.this);
            dialog.setContentView(R.layout.login);
            dialog.setTitle("Login");

            // get the Refferences of views
            final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
            final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

            Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

            // Set On ClickListener
            btnSignIn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    // get The User name and Password
                    String userName=editTextUserName.getText().toString();
                    String password=editTextPassword.getText().toString();

                    // fetch the Password form database for respective user name
                    String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                    // check if the Stored password matches with  Password entered by user
                    if(password.equals(storedPassword))
                    {
                        Toast.makeText(SignUPActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        Intent i = new Intent(SignUPActivity.this, ClassSchedulerActivity.class);
                        startActivity(i);

                    }
                    else
                    {
                        Toast.makeText(SignUPActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    }
                }
            });

            dialog.show();
        }

    public void exit(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);;

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
