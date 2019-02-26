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

        Toast.makeText(this, "Successfully created book!", Toast.LENGTH_SHORT)
                .setGravity(Gravity.BOTTOM, 0, 15)
                .show();

        Intent data = new Intent();
        EditText mEdit = findViewById(R.id.titleEditText);
        data.putExtra("newBookCreatedTitle", mEdit.getText().toString());
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
