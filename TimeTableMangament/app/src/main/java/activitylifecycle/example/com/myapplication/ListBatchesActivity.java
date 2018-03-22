package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListBatchesActivity extends Activity {

	ListView listBatches;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listbatches);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		listBatches  = (ListView) this.findViewById(R.id.listBatches);
		BatchesAdapter adapter  = new BatchesAdapter(this);
		listBatches.setAdapter(adapter);
	}
	
	public void addBatch(View v) {
		Intent intent = new Intent(this, AddBatchActivity.class);
		startActivity(intent);
	}
	public void readnot(View v)
	{
		Intent intent1 = new Intent(this, NotifyActivityStudent.class);
		startActivity(intent1);
	}

	public void backtohomeactivity(View v)
	{
		Intent intent2 = new Intent(this, HomeActivity.class);
		startActivity(intent2);
	}
	
	
}
