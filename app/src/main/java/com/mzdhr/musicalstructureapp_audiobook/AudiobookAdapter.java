package com.mzdhr.musicalstructureapp_audiobook;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mohammad on 11/19/17.
 */

public class AudiobookAdapter  extends ArrayAdapter<Audiobook>{

    public AudiobookAdapter(@NonNull Context context, @NonNull List<Audiobook> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Getting the object located at this position in the list
        Audiobook currentAudiobook = getItem(position);

        // Find Views
        ImageView bookCoverImageView = (ImageView) listItemView.findViewById(R.id.book_cover_image_view);
        TextView bookTitleTextView = (TextView) listItemView.findViewById(R.id.book_title_text_view);
        TextView bookAuthorTextView = (TextView) listItemView.findViewById(R.id.book_author_text_view);
        TextView bookYearTextView = (TextView) listItemView.findViewById(R.id.book_year_text_view);

        // Setting values
        bookCoverImageView.setImageResource(currentAudiobook.getImageResourceId());
        bookTitleTextView.setText(currentAudiobook.getTitle());
        bookAuthorTextView.setText(currentAudiobook.getAuthor());
        bookYearTextView.setText(currentAudiobook.getYear());

        return listItemView;
    }

}
