package activitylifecycle.example.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Create_not extends AppCompatActivity {
    private EditText txtDate;
    private String pass_file;
    private EditText txtRemark;
    private String d1;
    private  String r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createn);
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            pass_file = extras.getString("filen");
            //   Toast.makeText(this,pass_str, Toast.LENGTH_LONG).show();
        }
    }
    public void write(View v) {

        txtDate = (EditText) this.findViewById(R.id.editdate1);
        txtRemark = (EditText) this.findViewById(R.id.editremarks1);
        d1 = txtDate.getText().toString();
        r1 = txtRemark.getText().toString();

        if (d1.equals("") || r1.equals("")) {
            Toast.makeText(Create_not.this, "Dont leave the fields bank", Toast.LENGTH_LONG).show();
        } else {

            // if(r1.equals("")||d1.equals(""))
            //{
            // Toast.makeText(getApplicationContext(),"Enter valid inputs",Toast.LENGTH_LONG).show();
            //}
            //else {
            try {
                FileOutputStream fileOutputStream = openFileOutput(pass_file, MODE_APPEND);
                fileOutputStream.write((d1).getBytes());
                fileOutputStream.write((" ").getBytes());
                //Toast.makeText(getApplicationContext(),d1,Toast.LENGTH_LONG).show();
                fileOutputStream.write((r1).getBytes());
                fileOutputStream.write("\n\r".getBytes());
                // Toast.makeText(getApplicationContext(),r1,Toast.LENGTH_LONG).show();
                fileOutputStream.close();


                Toast.makeText(getApplicationContext(), "Message saved", Toast.LENGTH_LONG).show();
                // txtText.setText("");
            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(), "File not found", Toast.LENGTH_LONG).show();
                // e.printStackTrace();
            } catch (IOException e) {
                // e.printStackTrace();
            }
            //}

        }
    }
    public void read(View v)
    {
        StringBuffer stringBuffer = new StringBuffer();
        String val ="";
        try {
            FileInputStream fileInputStream = openFileInput(pass_file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int flag=0;
            for(int i=0;flag==0;i++)
            {
                String mesa = bufferedReader.readLine();
                if(mesa==null)
                    flag = 1;
                else
                    stringBuffer.append(mesa+"\n");
                //Toast.makeText(getApplicationContext(), mesa, Toast.LENGTH_LONG).show();
            }
            //Toast.makeText(getApplicationContext(), stringBuffer, Toast.LENGTH_LONG).show();
            val = stringBuffer.toString();
            //Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();



        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(),"IO exception",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
