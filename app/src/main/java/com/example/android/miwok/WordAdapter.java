package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 11/10/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mcolorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words , int colorResourceId){

        super(context, 0, words);

        mcolorResourceId = colorResourceId;
    };
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            //inflates the new listitemview by using the list_view xml file
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        //getItem is a method of ArrayAdapter class
        Word currentWord= getItem(position);



        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        //referenced to the vertical Linear layout in the horizontal defined in the list_view Xml
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), mcolorResourceId);
        //set this color to the text container view
        textContainer.setBackgroundColor(color);


        //sets the image view in the list item view if the image is available
        ImageView imageView = (ImageView)  listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()){
        //
        imageView.setImageResource(currentWord.getimageResourceId());
        imageView.setVisibility(View.VISIBLE);}
        else{
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
