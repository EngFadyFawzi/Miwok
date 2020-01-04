package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity
{
    private WordAdapter wordAdapter;
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_list );
        
        // create a list of words
        final ArrayList< Word > words = new ArrayList< Word >();
        words.add( new Word( "red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red ) );
        words.add( new Word( "mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow ) );
        words.add( new Word( "dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow ) );
        words.add( new Word( "green", "chokokki", R.drawable.color_green, R.raw.color_green ) );
        words.add( new Word( "brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown ) );
        words.add( new Word( "gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray ) );
        words.add( new Word( "black", "kululli", R.drawable.color_black, R.raw.color_black ) );
        words.add( new Word( "white", "kelelli", R.drawable.color_white, R.raw.color_white ) );
        
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        wordAdapter = new WordAdapter( this, words, R.color.category_colors );
        
        // Find the {@link ListView) object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        // in the word_list.xml layout file.
        ListView listView = findViewById( R.id.list_view );
        
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list of words.
        listView.setAdapter( wordAdapter );
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
        
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        wordAdapter.releaseMediaPlayer();
    }
}