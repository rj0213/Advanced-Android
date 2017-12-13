package com.android.example.wordlistsql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = EditWordActivity.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditWordText;
    private WordListOpenHelper mDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        mEditWordText = (EditText) findViewById(R.id.search_word);
        mTextView = (TextView) findViewById(R.id.search_result);
        mDB = new WordListOpenHelper(this);
    }

    public void showResult(View view){
        String word = mEditWordText.getText().toString();
        mTextView.setText("Result for " + word + ":\n\n");

        // Search for the word in the database.
        Cursor cursor = mDB.search(word);

        // Only process a non-null cursor with rows.
        if (cursor != null & cursor.getCount() > 0) {
            // You must move the cursor to the first item.
            cursor.moveToFirst();
            int index;
            String result;
            // Iterate over the cursor, while there are entries.
            do {
                // Don't guess at the column index.
                // Get the index for the named column.
                index = cursor.getColumnIndex(WordListOpenHelper.KEY_WORD);
                // Get the value from the column for the current cursor.
                result = cursor.getString(index);
                // Add result to what's already in the text view.
                mTextView.append(result + "\n");
            } while (cursor.moveToNext()); // Returns true or false
            cursor.close();
        } // You should add some handling of null case. Right now, nothing happens.
    }
}
