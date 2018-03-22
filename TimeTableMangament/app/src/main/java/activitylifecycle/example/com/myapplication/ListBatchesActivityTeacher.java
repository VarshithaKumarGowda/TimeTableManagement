package activitylifecycle.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import junit.framework.Test;

import java.util.TreeSet;

public class ListBatchesActivityTeacher extends Activity {

    ListView listBatches;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listbatchesteacher);
    }

    @Override
    public void onStart() {
        super.onStart();
        listBatches  = (ListView) this.findViewById(R.id.listBatches);
        BatchesAdapterTeacher adapter  = new BatchesAdapterTeacher(this);
        listBatches.setAdapter(adapter);
    }

    public void addBatch(View v) {
        Intent intent = new Intent(this, AddBatchActivity.class);
        startActivity(intent);
    }

    public void gototest(View v)
    {
        Intent intent1 = new Intent(this, TestActivity.class);
        startActivity(intent1);
    }

    public void addnot(View v)
    {
        Intent intent1 = new Intent(this, NotifyActivity.class);
        startActivity(intent1);
    }


}