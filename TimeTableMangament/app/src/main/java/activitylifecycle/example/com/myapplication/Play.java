package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;


public class Play extends Activity implements
            TextToSpeech.OnInitListener {
        /** Called when the activity is first created. */
        private  Button btnSpeak;
        private TextToSpeech tts;
    private String pass_str;
      //  private EditText txtText;
       // private TextView textView;
    public static final String TAG = "YOUR-TAG-NAME";
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle extras = getIntent().getExtras();
            if(extras!=null) {
                pass_str = extras.getString("red");
              //   Toast.makeText(this,pass_str, Toast.LENGTH_LONG).show();
            }
            // Log.i(TAG, "hello Play class");
            setContentView(R.layout.play);
            tts = new TextToSpeech(this, this);
            //txtText = (EditText) findViewById(R.id.txtText);
            //textView = (TextView) findViewById(R.id.textView);
            // textView.setVisibility(View.GONE);
            // button on click event
        }

        /*public void writeMessage(View view)
        {
            String message = txtText.getText().toString();
            // String message = "hi";
            String file_name ="hello_txt";
            try {
                FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                fileOutputStream.write(message.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_LONG).show();
                // txtText.setText("");
            }
            catch(FileNotFoundException e)
            {
                // e.printStackTrace();
            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
*/
        public void readMessage(View view)
        {
            try {
                Log.i("info", "entered in try");
                //  Toast.makeText(getApplicationContext(), "hygnkdjcnikdjncjasdnvosundevsedrjvnuzsoednz", Toast.LENGTH_LONG).show();
                String message = "hello";
                FileInputStream fileInputStream = openFileInput("try.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                int flag=0;
                for(int i=0;flag==0;i++)
                {
                    String mesa = bufferedReader.readLine();
                    if(mesa==null)
                        flag = 1;
                    else
                        stringBuffer.append(mesa+"\n");
                   // Toast.makeText(getApplicationContext(), mesa, Toast.LENGTH_LONG).show();
                }

          /* String  messa = bufferedReader.readLine();
            Toast.makeText(getApplicationContext(), messa, Toast.LENGTH_LONG).show();
            String  messa2 = bufferedReader.readLine();
            Toast.makeText(getApplicationContext(), messa2, Toast.LENGTH_LONG).show();
            String  messa3 = bufferedr` `Reader.readLine();
            Toast.makeText(getApplicationContext(), messa3, Toast.LENGTH_LONG).show();
            String  messa4 = bufferedReader.readLine();
            Toast.makeText(getApplicationContext(), messa4, Toast.LENGTH_LONG).show();

            if(messa4!=null)
                Toast.makeText(getApplicationContext(),"is null", Toast.LENGTH_LONG).show();*/

            /*while((message = bufferedReader.readLine())!=null)
            {
                //stringBuffer.append(message+"\n");
                 Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Log.i("info", "in while");
            }
            Toast.makeText(getApplicationContext(), "opened file", Toast.LENGTH_LONG).show();
               textView.setText(stringBuffer.toString());
           // fileInputStream.close();*/
                //  textView.setText(message.toString());
             //   textView.setText(stringBuffer.toString());
               // textView.setVisibility(View.VISIBLE);

            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            catch (IOException e) {
                Toast.makeText(getApplicationContext(),"IO exception",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
        @Override
        public void onDestroy() {
            // Don't forget to shutdown!
            if (tts != null) {
                tts.stop();
                tts.shutdown();
            }
            super.onDestroy();
        }

        @Override
        public void onInit(int status) {


            if (status == TextToSpeech.SUCCESS) {

                int result = tts.setLanguage(Locale.US);

                // tts.setPitch(5); // set pitch level

                // tts.setSpeechRate(2); // set speech speed rate

                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Language is not supported");
                } else {
                   // btnSpeak.setEnabled(true);
                    speakOut();
                }

            } else {
                Log.e("TTS", "Initilization Failed");
            }

        }

        private void speakOut() {

           //String value = txtText.getText().toString();
           tts.speak(pass_str, TextToSpeech.QUEUE_FLUSH, null);
          //  Toast.makeText(this,pass_str ,Toast.LENGTH_LONG).show();
        }

    }
