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

public class UpdateData extends AppCompatActivity {

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

        //haal SSM op
        final StorgeSaveModel SSM = (StorgeSaveModel) getIntent().getSerializableExtra("ssm");

        //update edit
        titleVieuw.setText(SSM.getTitel());
        platFormVieuw.setText(SSM.getPlatform());
        notieVieuw.setText(SSM.getNotie());


        //soinnter
        final Spinner dropdown = findViewById(R.id.status_id_spinner);
        String[] items;

        //kijk wat de huidige status is zodat je weet hoe de volgende van de spinner moet zijn
        if("waits to play".equals(SSM.getStatus())){
            items = new String[]{"waits to play", "playing", "stalled"};
        } else if("playing".equals(SSM.getStatus())){
            items = new String[]{"playing", "waits to play", "stalled"};
        } else {
            items = new String[]{"stalled", "waits to play", "playing"};
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //fap button
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String TITLE =
                        titleVieuw.getText().toString();
                final String NOTIES = notieVieuw.getText().toString();
                final String PLATFORM = platFormVieuw.getText().toString();

                SSM.setNotie(notieVieuw.getText().toString());
                SSM.setPlatform(platFormVieuw.getText().toString());
                SSM.setTitel(titleVieuw.getText().toString());
                SSM.setStatus(dropdown.getSelectedItem().toString());

                AppDatabase.getInstance(UpdateData.this).storgeModelDOA().updateReminders(SSM);

                //roep het volgende scherm op
                Intent intent = new Intent(UpdateData.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
