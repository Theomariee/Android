package esir.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    protected void redirectToCreateActivity(View view) {
        Intent intent = new Intent(ListActivity.this, CreateActivity.class);
        ListActivity.this.startActivity(intent);
    }
}
