package sg.edu.rp.c346.id21033869.mymovienew;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvGenre;
    TextView tvYear;
    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spRating;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.textViewTitle);
        tvGenre = findViewById(R.id.textViewGenre);
        tvYear = findViewById(R.id.textViewYear);
        etTitle = findViewById(R.id.editTextTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spRating = findViewById(R.id.spinnerRate);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShow = findViewById(R.id.buttonShow);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerRate);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Rating_List, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ArrayList<Movies> movieList = new ArrayList<>();

        //@Override
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = movieList.size() + 1;
                String title = etTitle.getText().toString();
                String genre = etGenre.getText().toString();
                String strYear = etYear.getText().toString();
                String actualRating = "";
                int year = Integer.parseInt(strYear);

                if (spRating.equals("G")) {
                    actualRating = "G";
                } else if (spRating.equals("PG")) {
                    actualRating = "PG";
                } else if (spRating.equals("PG13")) {
                    actualRating = "PG13";
                } else if (spRating.equals("NC16")) {
                    actualRating = "NC16";
                } else if (spRating.equals("M18")) {
                    actualRating = "M18";
                } else {
                    actualRating = "R21";
                }

                int preSize = movieList.size();

                movieList.add(new Movies(id, title, genre, year, actualRating));

                if (movieList.size() == preSize) {
                    System.out.println("Movie not added");
                } else {
                    System.out.println("Movie added");
                }
            }
        });

        //@Override
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ShowMovies.class);
                startActivity(i);
            }
        });
    }
}