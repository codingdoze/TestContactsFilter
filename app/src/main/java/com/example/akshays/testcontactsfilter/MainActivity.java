package com.example.akshays.testcontactsfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    // CustomRecyclerView Adapter
    CustomRecylerAdapter adapter;

    // Search EditText
     EditText inputSearch;

    // ArrayList for Recyclerview
    private List<ContactsList> contactlists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

//data to be populated in recyclerview
        prepareContactList();

        //To update recyclerview list on text change in edittext
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                filter(cs.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable text) {

                // filter your list from your input

                // TODO Auto-generated method stub
            }
        });


    }

//Method
    void filter(String text) {
        List<ContactsList> temp = new ArrayList();
        for (ContactsList d : contactlists) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getNames().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.updateList(temp);
    }


    private void prepareContactList() {

        ContactsList list = new ContactsList("Kartikey Singh");
        contactlists.add(list);

        ContactsList list1 = new ContactsList("Vaibahav Sukhi");
        contactlists.add(list1);

        ContactsList list2 = new ContactsList("Abha Java");
        contactlists.add(list2);

        ContactsList list3 = new ContactsList("Sudarashan Shetty");
        contactlists.add(list3);

        ContactsList list4 = new ContactsList("Anuradha Shetty");
        contactlists.add(list4);

        ContactsList list5 = new ContactsList("Ujwala");
        contactlists.add(list5);

        ContactsList list6 = new ContactsList("Gaurav Agam");
        contactlists.add(list6);

        ContactsList list7 = new ContactsList("Nullpointer Exception");
        contactlists.add(list7);

        ContactsList list8 = new ContactsList("Nullpointer");
        contactlists.add(list8);

        ContactsList list9 = new ContactsList("Neurolinx");
        contactlists.add(list9);

        ContactsList list10 = new ContactsList("Hadoop");
        contactlists.add(list10);
        adapter = new CustomRecylerAdapter(contactlists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }


}
