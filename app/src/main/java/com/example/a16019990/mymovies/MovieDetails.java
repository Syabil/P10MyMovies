package com.example.a16019990.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MovieDetails extends AppCompatActivity {
    ImageView ivRating;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatchedOn;
    TextView tvInTheather;
    RatingBar rbRating;
    int moviePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);

        ivRating = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchedOn = findViewById(R.id.textViewWatched);
        tvInTheather = findViewById(R.id.textViewTheater);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        Movie movieReal = (Movie) intentReceived.getSerializableExtra("movie");

        String rating = movieReal.getRated();
        String ratingID = "rating_" + rating;
        int drawableResourceId = this.getResources().getIdentifier(ratingID, "drawable", this.getPackageName());
        ivRating.setImageResource(drawableResourceId);
        tvTitle.setText(movieReal.getTitle());
        tvYear.setText(movieReal.getYear() + " - ");
        tvGenre.setText(movieReal.getGenre());
        tvDescription.setText(movieReal.getDescription());
        tvWatchedOn.setText("Watched on: " + movieReal.getWatchedOnString());
        tvInTheather.setText("In Theater: " + movieReal.getIn_theather());
        rbRating.setRating(movieReal.getRating());
    }
}
