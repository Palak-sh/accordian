package com.example.accordian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> mList;
    private RecAdapter adapter;
    public NestedAdapter a;
    public RecyclerView nestedrecyclerView;
    public CheckBox checkbox;
    public List<String> list = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context;

        recyclerView = findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      /*  View v = getLayoutInflater().inflate(R.layout.item_movie,null,false);
        checkbox = v.findViewById(R.id.chkbx);*/

        RecyclerView nestedRecyclerView = findViewById(R.id.child_rv);
        /*nestedrecyclerView.setHasFixedSize(true);
        nestedrecyclerView.setLayoutManager(new LinearLayoutManager(this));*/


        mList = new ArrayList<>();
        setClickListener();

        //list1
        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Sorcerrors stone");
        nestedList1.add("Chamber of Secrets ");
        nestedList1.add("Prisoner of Askaban");
        nestedList1.add("Goblet of fire");
        nestedList1.add("Deathly hallos part 1");
        nestedList1.add("Deathly Hallows Part 2");
        nestedList1.add("Cursed Child");


        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("Captain America");
        nestedList2.add("Iron man 1");
        nestedList2.add("Iron man 2");
        nestedList2.add("Captain Marvel");
        nestedList2.add("Thor");
        nestedList2.add("Doctor Strange");
        nestedList2.add("Spider man");
        nestedList2.add("Multiverse");

        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("Dhoom 1");
        nestedList3.add("Dhoom 2");
        nestedList3.add("Dhoom 3");


        List<String> nestedList4 = new ArrayList<>();
        nestedList4.add("Season 1");
        nestedList4.add("Season 2");
        nestedList4.add("Season 3");
        nestedList4.add("Season 4");
        nestedList4.add("Season 5");
        nestedList4.add("Season 6");
        nestedList4.add("Season 7");
        nestedList4.add("Season 8");

        List<String> nestedList5 = new ArrayList<>();
        nestedList5.add("Season 1");
        nestedList5.add("Season 2");
        nestedList5.add("Season 3");
        nestedList5.add("Season 4");


        List<String> nestedList6 = new ArrayList<>();
        nestedList6.add("Drishyam 1");
        nestedList6.add("Drishyam 2");


        List<String> nestedList7 = new ArrayList<>();
        nestedList7.add("SOTY 1");
        nestedList7.add("SOTY 2");
       // a = new NestedAdapter(this,list);
      //  nestedrecyclerView.setAdapter(a);

        mList.add(new Movie(nestedList1, "Harry Potter"));
        mList.add(new Movie(nestedList2, "Marvel"));
        mList.add(new Movie(nestedList3, "Dhoom"));
        mList.add(new Movie(nestedList4, "Vampire Diaries"));
        mList.add(new Movie(nestedList5, "Stranger Things"));
        mList.add(new Movie(nestedList6, "Drishyam"));
        mList.add(new Movie(nestedList7, "Student of the year"));

        adapter = new RecAdapter(this, mList);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromposition = viewHolder.getAdapterPosition();
            int toposition = target.getAdapterPosition();

            Collections.swap(mList, fromposition, toposition);
            recyclerView.getAdapter().notifyItemMoved(fromposition, toposition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    private void setClickListener() {
        EditText moviename = findViewById(R.id.moviename);
        Button btnadd = findViewById(R.id.btnadd);

/*if(!(checkbox.isChecked()))*/{
                    btnadd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String movie = moviename.getText().toString();
                            mList.add(new Movie(movie));
                            adapter.notifyItemInserted(mList.size() - 1);
                            recyclerView.scrollToPosition(mList.size() - 1);


                        }
                    });
                }/*else {
    btnadd.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String movie = moviename.getText().toString();
            List<String> nestedList = new ArrayList<>();
            nestedList.add(movie);


            a.notifyItemInserted(list.size() - 1);
            nestedrecyclerView.scrollToPosition(list.size() - 1);
                }
            });
}*/
    }
}




