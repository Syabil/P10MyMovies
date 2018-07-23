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
        moviePos = intentReceived.getIntExtra("movieIdPos", 0);
        String movieObject = intentReceived.getStringExtra("MovieObject");

        String[] movieArr = movieObject.split(",");
        Calendar date = Calendar.getInstance();
        date.set(Integer.parseInt(movieArr[4]),Integer.parseInt(movieArr[5]),Integer.parseInt(movieArr[6]));
        Movie movie = new Movie(movieArr[0], movieArr[1], movieArr[2], movieArr[3], date, movieArr[7], movieArr[8],Float.parseFloat(movieArr[9]));

        String rating = movie.getRated();
        String ratingID = "rating_" + rating;
        int drawableResourceId = this.getResources().getIdentifier(ratingID, "drawable", this.getPackageName());
        ivRating.setImageResource(drawableResourceId);
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear() + " - ");
        tvGenre.setText(movie.getGenre());
        tvDescription.setText(movie.getDescription());
        tvWatchedOn.setText("Watched on: " + movie.getWatchedOnString());
        tvInTheather.setText("In Theater: " + movie.getIn_theather());
        rbRating.setRating(movie.getRating());
    }
}
