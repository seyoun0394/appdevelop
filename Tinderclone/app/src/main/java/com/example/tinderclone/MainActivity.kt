package com.example.tinderclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //implement the onFlingListener
        public class MyActivity extends Activity {
            ...

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                ...

                //add the view via xml or programmatically
                SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

                al = new ArrayList<String>();
                al.add("php");
                al.add("c");
                al.add("python");
                al.add("java");

                //choose your favorite adapter
                arrayAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.helloText, al );

                //set the listener and the adapter
                flingContainer.setAdapter(arrayAdapter);
                flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
                    @Override
                    public void removeFirstObjectInAdapter() {
                        // this is the simplest way to delete an object from the Adapter (/AdapterView)
                        Log.d("LIST", "removed object!");
                        al.remove(0);
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onLeftCardExit(Object dataObject) {
                        //Do something on the left!
                        //You also have access to the original object.
                        //If you want to use it just cast it (String) dataObject
                        Toast.makeText(MyActivity.this, "Left!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRightCardExit(Object dataObject) {
                        Toast.makeText(MyActivity.this, "Right!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdapterAboutToEmpty(int itemsInAdapter) {
                        // Ask for more data here
                        al.add("XML ".concat(String.valueOf(i)));
                        arrayAdapter.notifyDataSetChanged();
                        Log.d("LIST", "notified");
                        i++;
                    }
                });

                // Optionally add an OnItemClickListener
                flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClicked(int itemPosition, Object dataObject) {
                        makeToast(MyActivity.this, "Clicked!");
                    }
                });
            }
        }