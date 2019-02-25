package esir.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getLocalClassName(), "Log info from MainActivity");
    }

    protected void redirectToCreateActivity(View view) {
        Intent intent = new Intent(MainActivity.this, CreateActivity.class);
        MainActivity.this.startActivity(intent);
    }

    protected void redirectToListActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        MainActivity.this.startActivity(intent);
    }
}
