
package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Locale;

public class Record extends Activity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        Log.i("info","hi");

        // hide the action bar
      //  getActionBar().hide();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //speech_to_text();
                promptSpeechInput();
            }
        });

    }

    /**
     * Showing google speech input dialog
     * */
    public void speech_to_text()
    {
        String val = "";
        String message = "Reading";
        // String message = "hi";
        String file_name ="hello_txt";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
            //Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_LONG).show();
            // txtText.setText("");
        }
        catch(FileNotFoundException e)
        {
            // e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        }

       // Toast.makeText(this,"speech to text", Toast.LENGTH_LONG).show();
       // Intent i =new Intent(Record.this,.class);
        // startActivity(i);
    }
    private void promptSpeechInput() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        Log.i("info","promptSpeechInput");
        try {

            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    String s = txtSpeechInput.getText().toString();
                      Toast.makeText(this,s, Toast.LENGTH_LONG).show();

                    Log.i("info",s);

                        String FILENAME = "try.txt";
                       // String string = "hello world!";

                   writeToFile(s);
                    Log.i("info"," done file");

                }
                break;
            }

        }
    }
    public void writeToFile(String data)
    {
        // Get the directory for the user's public pictures directory.

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("try.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            //  Toast.makeText(this,"written to file", Toast.LENGTH_LONG).show();

        }
        catch (IOException e) {
            Log.e("info", "File write failed: " + e.toString());
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
