package esir.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(this.getLocalClassName(),"requestCode : " + requestCode + " resultCode : " + resultCode);
        Log.i(this.getLocalClassName(), data.getExtras().getString("newBookCreatedTitle"));
    }

    protected void redirectToCreateActivity(View view) {
        Intent intent = new Intent(ListActivity.this, CreateActivity.class);
        ListActivity.this.startActivityForResult(intent, 2);
    }

}
