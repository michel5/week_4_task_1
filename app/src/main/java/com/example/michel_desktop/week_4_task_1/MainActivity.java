package com.example.michel_desktop.week_4_task_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.michel_desktop.week_4_task_1.recyclerVieuw.StorgeModelAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //list
    private List<StorgeSaveModel> mStorgeModel;

    //app database model
    public static AppDatabase db;

    //recyclervieuw
    public RecyclerView recyclerView;

    public MainActivity() {
        this.mStorgeModel = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //maak app database een instance van
        db = AppDatabase.getInstance(this);

        //save button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputField.class);
                startActivity(intent);
            }
        });

        List<StorgeSaveModel> tempArrayList =
                db.storgeModelDOA().getAllStorgeModel();

        for (int i = 0; i < tempArrayList.size(); i++) {
            final StorgeSaveModel SSM = tempArrayList.get(i);

            //maak het object opnieuw aan
            mStorgeModel.add(SSM);
        }

        final List<StorgeSaveModel> mStorgeModel = db.storgeModelDOA().getAllStorgeModel();


        //maak de recyclervieuw aan
        RecyclerView mGeoRecyclerView = findViewById(R.id.rec_vieuw);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);


        //mLayout manager naar recyclervieuw manager
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final StorgeModelAdapter mAdapter = new StorgeModelAdapter(this, mStorgeModel);
        mGeoRecyclerView.setAdapter(mAdapter);



        //toch helper
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
            new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                        target) {
                    return false;
                }

                //Called when a user swipes left or right on a ViewHolder
                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                    //Get the index corresponding to the selected position
                    int position = (viewHolder.getAdapterPosition());

                    //maak storge save model aan
                    db.storgeModelDOA().deleteReminders((StorgeSaveModel) mStorgeModel.get(position));

                    //remove position
                    mStorgeModel.remove(position);

                    mAdapter.notifyItemRemoved(position);
                }
            };
        

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
