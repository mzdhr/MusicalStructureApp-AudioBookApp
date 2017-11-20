package com.mzdhr.musicalstructureapp_audiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    private static final String TAG = PlayerActivity.class.getSimpleName();
    // Views
    private Button mLibraryButton;
    private TextView mBookTitleTextView;
    private TextView mDurationTextView;
    private ImageView mBookCoverImageView;

    // objects
    private boolean isPlaying;
    private String mBookTitle;
    private String mBookDuration;
    private int mBookCoverID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        setTitle(new String("PlayerActivity"));
        findViews();

        // Getting data from the intent
        Intent intent = getIntent();
        // Determine is this intent comes from "Now Playing" button, or the user clicks on book in the list.
        isPlaying = intent.getBooleanExtra(Constants.NOW_PLAYING, false);
        if (isPlaying){
            // show current playing audiobook - we assume the user playing "Invisible book".
            mBookTitle = "Invisible";
            mBookDuration = "90:41";
            mBookCoverID = R.drawable.invisible;
        } else {
            // play this clicked book
            mBookTitle = intent.getStringExtra(Constants.BOOK_TITLE);
            mBookDuration = intent.getStringExtra(Constants.BOOK_DURATION);
            mBookCoverID = intent.getIntExtra(Constants.BOOK_COVER, 0);
        }

        // Setting data to the views
        mBookTitleTextView.setText(mBookTitle);
        mDurationTextView.setText(mBookDuration);
        mBookCoverImageView.setImageResource(mBookCoverID);

        // Setting click listener to "Library" button
        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void findViews() {
        mLibraryButton = (Button) findViewById(R.id.library_button_view);
        mBookTitleTextView = (TextView) findViewById(R.id.book_title_text_view);
        mDurationTextView = (TextView) findViewById(R.id.duration_text_view);
        mBookCoverImageView = (ImageView) findViewById(R.id.book_cover_image_view);
    }
}
