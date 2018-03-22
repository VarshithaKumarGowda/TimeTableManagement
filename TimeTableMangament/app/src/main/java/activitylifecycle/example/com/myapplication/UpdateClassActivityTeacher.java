package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateClassActivityTeacher extends Activity {
	private static final int TIME_DIALOG = 1;
	private static final int CANCEL_ALERT_DIALOG = 2;
	private static final int DELETE_ALERT_DIALOG = 3;
//	private static final int RECORD_ALERT_DIALOG = 4;

	private int day, month, year, hours, mins;
	private TextView textClassDate, textClassTime, textBatchCode;
	private EditText editPeriod,editRemarks, editTopics;
   private Button btnRecord, btnPlay , btnStudent;
	private String classid;
	private String batchid;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
         setContentView(R.layout.updateclassteacher);


		textClassDate = (TextView) this.findViewById(R.id.textClassDate);
		textClassTime = (TextView) this.findViewById(R.id.textClassTime);

		textBatchCode = (TextView) this.findViewById(R.id.textBatchCode);
		editPeriod = (EditText) this.findViewById(R.id.editPeriod) ;
		editTopics = (EditText) this.findViewById(R.id.editTopics) ;
		editRemarks = (EditText) this.findViewById(R.id.editRemarks) ;
		
		// get details from database
		classid = getIntent().getStringExtra("classid");

	    Class clas = Database.getClass(this, classid);
		if ( clas == null)
		{
			// error 
		}
		else
		{
			batchid = clas.getBatchCode();
			textBatchCode.setText( clas.getBatchCode());
			textClassDate.setText( clas.getClassDate());
			textClassTime.setText( clas.getClassTime());
			setTimeToStartTime(clas.getClassTime());
			editPeriod.setText( clas.getPeriod());
			editTopics.setText( clas.getTopics());
			editRemarks.setText( clas.getRemarks());
		}


		btnRecord=(Button)findViewById(R.id.btnRecord);
		btnPlay=(Button)findViewById(R.id.btnPlay);


        // Set OnClick Listener on SignUp button

      /*  btnSpeak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


              //  String readme = "hello";
               // Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();

                /// Create Intent for SignUpActivity  and Start The Activity

                Intent i=new Intent(UpdateClassActivity.this,Play.class);
                startActivity(i);
            }
        }); */
    }


	private void setTimeToStartTime(String starttime) {
		String[] parts = starttime.split(":");
		hours = Integer.parseInt( parts[0]);
		mins = Integer.parseInt( parts[1]);
	}

	public void updateClass(View v) {
		 boolean done = Database.updateClass(this,
				  classid,
				  textClassTime.getText().toString(),
				  editPeriod.getText().toString(),
				  editTopics.getText().toString(),
				  editRemarks.getText().toString());
		 
		 if ( done )
			 Toast.makeText(this,"Updated class successfully!", Toast.LENGTH_LONG).show();
		 else
			 Toast.makeText(this,"Sorry! Could not update class!", Toast.LENGTH_LONG).show();
	}
	public void student_manage(View v) {

		//Toast.makeText(this,filenamesent, Toast.LENGTH_LONG).show();
		Intent i =new Intent(UpdateClassActivityTeacher.this,StudentMainActivity.class);
		startActivity(i);
	}

	public void speech_to_text(View v)
	{
		/*String val = "";
		String message = "writing";
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
		Toast.makeText(this,classid ,Toast.LENGTH_LONG).show();*/
		String cd = batchid;
		Toast.makeText(this,cd, Toast.LENGTH_LONG).show();
		String filenamesent = (cd).concat(classid);
		Toast.makeText(this,filenamesent, Toast.LENGTH_LONG).show();
		Intent i =new Intent(UpdateClassActivityTeacher.this,Record.class);
		startActivity(i);
	}
	public void text_to_speech(View v)
	{
		String val = "";
		/*String message = "Ayushi Agrawal";
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
		}*/
		StringBuffer stringBuffer = new StringBuffer();
		try {
				//  Toast.makeText(getApplicationContext(), "hygnkdjcnikdjncjasdnvosundevsedrjvnuzsoednz", Toast.LENGTH_LONG).show();
				String message1 = "hello";
				FileInputStream fileInputStream = openFileInput("try.txt");
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
		Intent i=new Intent(UpdateClassActivityTeacher.this,Play.class);
		//
		 i.putExtra("red",val);
		startActivity(i);
		}

		@Override
		public void onDestroy() {
		// Don't forget to s
		//String readme = "hi";
		//Toast.makeText(this,"txt2speech", Toast.LENGTH_LONG).show();

		/// Create Intent for SignUpActivity  and Start The Activity


			super.onDestroy();
	}
	public void deleteClass(View v) {
		this.showDialog(DELETE_ALERT_DIALOG);
	}
	
	public void cancelClass(View v) {
		this.showDialog(CANCEL_ALERT_DIALOG);
	}

	public void showTimePicker(View v) {
		showDialog(TIME_DIALOG);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		super.onCreateDialog(id);

		switch (id) {
		 case TIME_DIALOG:
			return new TimePickerDialog(this, timeSetListener, hours,mins, false);
  	     case CANCEL_ALERT_DIALOG:
				return getCancelAlertDialog();
  	     case DELETE_ALERT_DIALOG:
				return getDeleteAlertDialog();
		}
		return null;
	}
	
	private TimePickerDialog.OnTimeSetListener timeSetListener =
			   new TimePickerDialog.OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker arg0, int pHours, int  pMins) {
					  hours = pHours;
					  mins = pMins;
					  updateTimeDisplay();
				}
	 
	};
	
		
	private void updateTimeDisplay() {
		// Month is 0 based so add 1
		textClassTime.setText(String.format("%02d:%02d", hours,mins));
	}
	
	
	public Dialog getDeleteAlertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to delete current class?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								
								 boolean done = Database.deleteClass(UpdateClassActivityTeacher.this, classid);
								 
								 if ( done ) {
									 Toast.makeText(UpdateClassActivityTeacher.this,"Deleted Class Successfully!", Toast.LENGTH_LONG).show();
									 UpdateClassActivityTeacher.this.finish();
								 }
								 else
									 Toast.makeText(UpdateClassActivityTeacher.this,"Sorry! Could not delete class!", Toast.LENGTH_LONG).show();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		return builder.create();
	}
	
	
	public Dialog getCancelAlertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to delete current class and add another class?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								 boolean done = Database.cancelClass(UpdateClassActivityTeacher.this, textBatchCode.getText().toString(), classid);
								 if ( done ) {
									 Toast.makeText(UpdateClassActivityTeacher.this,"Cancelled current class and added new class successfully!", Toast.LENGTH_LONG).show();
									 UpdateClassActivityTeacher.this.finish();
								 }
								 else
									 Toast.makeText(UpdateClassActivityTeacher.this,"Sorry! Could not cancel class!", Toast.LENGTH_LONG).show();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		return builder.create();
	}
	}
	

