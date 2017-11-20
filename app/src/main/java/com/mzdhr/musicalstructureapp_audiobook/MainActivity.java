package com.mzdhr.musicalstructureapp_audiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // Views
    private Button mNowPlayingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        // Create demo books
        final ArrayList<Audiobook> audiobooks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            audiobooks.add(new Audiobook("Invisible", "James Patterson", "2016", R.drawable.invisible, "90:41"));
            audiobooks.add(new Audiobook("The Art Of War", "Steven Pressfield", "2011", R.drawable.thwwarofart, "110:00"));
            audiobooks.add(new Audiobook("Obstacle Is The Way", "Ryan Holiday", "2016", R.drawable.obstacle, "40:81"));
            audiobooks.add(new Audiobook("Switch", "Dan Health", "2010", R.drawable.switchh, "20:31"));
        }

        // Create custom adapter and attached it to the GridView list
        AudiobookAdapter audiobookAdapter = new AudiobookAdapter(this, audiobooks);
        GridView list = (GridView) findViewById(R.id.list);
        list.setAdapter(audiobookAdapter);

        // Setting click listener to each items in the GridView list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creating intent and putting inside it information for the selected item, that retrieved from demo books data array list.
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra(Constants.NOW_PLAYING, false);
                intent.putExtra(Constants.BOOK_TITLE, audiobooks.get(position).getTitle());
                intent.putExtra(Constants.BOOK_DURATION, audiobooks.get(position).getDuration());
                intent.putExtra(Constants.BOOK_COVER, audiobooks.get(position).getImageResourceId());
                startActivity(intent);
            }
        });

        // Setting click listener to the button "Now Playing"
        mNowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra(Constants.NOW_PLAYING, true);
                startActivity(intent);
            }
        });

    }

    private void findViews() {
        mNowPlayingButton = (Button) findViewById(R.id.now_playing_button_view);
    }


}
