package com.example.michel_desktop.week_4_task_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InputField extends AppCompatActivity {
    //app database model
    public static AppDatabase db2;

    //text vieuw
    TextView titleVieuw;
    TextView platFormVieuw;
    TextView notieVieuw;
    TextView datum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_field);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.save_id);

        titleVieuw = findViewById(R.id.tittle_id);
        platFormVieuw = findViewById(R.id.platform_id);
        notieVieuw = findViewById(R.id.notes_id);
        datum = findViewById(R.id.datum_vieuw_id);

        //maak app database een instance van
        db2 = AppDatabase.getInstance(this);

        final Spinner dropdown = findViewById(R.id.status_id_spinner);
        String[] items = new String[]{"waits to play", "playing", "stalled"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //haal de datum op
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = sdf.format(c.getTime());

                final String TITLE =
                        titleVieuw.getText().toString();
                final String NOTIES = notieVieuw.getText().toString();
                final String PLATFORM = platFormVieuw.getText().toString();

                //model
                final StorgeSaveModel SVM = new StorgeSaveModel(TITLE, PLATFORM, NOTIES,
                        dropdown.getSelectedItem().toString(), strDate);

                AppDatabase.getInstance(InputField.this).storgeModelDOA().insertReminders(SVM);

                //roep het volgende scherm op
                Intent intent = new Intent(InputField.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
