package tn.itskills.android.numbers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ResultFragment.OnResultListener{

    private EditText mIMinEditText, mIMaxEditText;
    private ResultFragment mResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mIMinEditText = (EditText) findViewById(R.id.number_min_edittext);
        mIMaxEditText = (EditText) findViewById(R.id.number_max_edittext);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iMin = Integer.parseInt(mIMinEditText.getText().toString());
                int iMax = Integer.parseInt(mIMaxEditText.getText().toString());
                calculate(iMin, iMax);
            }
        });
    }

    private void calculate(int pIMin, int pIMax) {

        String mResult = "";

        int i = pIMin;
        while (i < pIMax) {
            if (checkMultiple(i, 3)){
                Log.i("TEST", "calculate: i = H");
                mResult += "H \n";
            }
            if (checkMultiple(i, 5)){
                Log.i("TEST", "calculate: i = S");
                mResult += "S \n";
            }
            if (!checkMultiple(i, 3) && !checkMultiple(i, 5)) {
                Log.i("TEST", "calculate: i = "+i);
                mResult += i+" \n";
            }

            i++;
        }

        showTemrOfUseDialog(mResult);
    }

    public void showTemrOfUseDialog(String pResult) {

        mResultFragment = ResultFragment.newInstance(this, pResult);
        mResultFragment.show(getFragmentManager(), "dialog");

    }

    private boolean checkMultiple(int pInumber, int pImultip) {
        boolean rBIsMultip = false;
        if (pInumber % pImultip == 0) {
            rBIsMultip = true;
        }
        return rBIsMultip;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAccept() {
        mResultFragment.dismiss();

    }
}
