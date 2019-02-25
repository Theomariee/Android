package esir.tp1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        /** Second way to create action on a click of the createBookButton
         Button createBook = (Button) findViewById(R.id.createBookButton);
         createBook.setOnClickListener(createBook(findViewById(blabla)));
         **/
    }


    protected void createBook(View view) {
        Log.i(this.getLocalClassName(), "createBook method successfully called after createBookButton has been clicked on");
        Context context = getApplicationContext();
        CharSequence text = "Successfully created book!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 15);

        toast.show();
        Intent data = new Intent(this, ListActivity.class);
        EditText mEdit = findViewById(R.id.titleEditText);
        data.putExtra("newBookCreatedTitle", mEdit.getText().toString());
        this.setResult(Activity.RESULT_OK, data);
        this.finish();
    }
}
