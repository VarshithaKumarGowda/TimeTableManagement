package activitylifecycle.example.com.myapplication;

import android.icu.text.SimpleDateFormat;

//import java.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Read_not extends AppCompatActivity {

    private  String pass_file;
    private  TextView data;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_not);
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            pass_file = extras.getString("filen");
            //   Toast.makeText(this,pass_str, Toast.LENGTH_LONG).show();
        }
    }

    public void read_date(View v)
    {
        data = (TextView) this.findViewById(R.id.remark);
        StringBuffer stringBuffer = new StringBuffer();
        String val = " ";
        try {
            FileInputStream fileInputStream = openFileInput(pass_file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int flag=0;
            Calendar c = Calendar.getInstance();
            // System.out.println("Current time => " + c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c.getTime());
            String[]  datesep = formattedDate.split("-");
            String makeme = "";
            for(int i=0;flag==0;i++)
            {
                String mesa = bufferedReader.readLine();
                if(mesa==null)
                    flag = 1;
                else {
                    //stringBuffer.append(mesa + "\n");
                    val = mesa.toString();
                    //Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
                    String fullString = val;
                    String[] partString = fullString.split(" ");
                    String[] partString1 = partString[0].split("-");
                    //Toast.makeText(getApplicationContext(), datesep[0]+" " +partString1[0], Toast.LENGTH_LONG).show();
                    if ((datesep[0]).equals(partString1[0])){
                        getApplicationContext();
                        // data.setText(val);
                        stringBuffer.append(mesa + "\n");
                    }

                }
                //  Toast.makeText(getApplicationContext(), mesa, Toast.LENGTH_LONG).show();
            }
            String hu = stringBuffer.toString();
            data.setText(hu);
            //Toast.makeText(getApplicationContext(), stringBuffer, Toast.LENGTH_LONG).show();
           /* val = stringBuffer.toString();
            data.setText(val);
            String CurrentString = val;
            String[] separated = CurrentString.split("-");
            Toast.makeText(getApplicationContext(), "read "+separated[0], Toast.LENGTH_LONG).show();
            Calendar c = Calendar.getInstance();
           // System.out.println("Current time => " + c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c.getTime());
            String[]  datesep = formattedDate.split("-");
            Toast.makeText(getApplicationContext(), "today "+ datesep[0], Toast.LENGTH_LONG).show();
            if(datesep[0] == separated[0])
                Toast.makeText(getApplicationContext(), "We match", Toast.LENGTH_LONG).show();*/


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
