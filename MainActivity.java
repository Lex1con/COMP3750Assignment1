package edu.uwi.sta.assignment1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView)findViewById(R.id.menu_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("itemid", position);
                if(position==0){
                    Intent i = new Intent(MainActivity.this, UIActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==1){
                    Intent i = new Intent(MainActivity.this, LayoutActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==2){
                    Intent i = new Intent(MainActivity.this, DialogsActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==3){
                    Intent i = new Intent(MainActivity.this, ToastsActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==4){
                    Intent i = new Intent(MainActivity.this, BundleActivity.class);
                    String dat = "hello";
                    i.putExtras(bundle);
                    i.putExtra(dat,"Hello i am passed data");
                    startActivity(i);
                }
                if(position==5){
                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtras(bundle);
                    startActivityForResult(i, 1);
                }
                if(position==6){
                    Intent i = new Intent(MainActivity.this, AdapterActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==7){
                    Intent i = new Intent(MainActivity.this, UIActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                if(position==8){
                    Intent i = new Intent(MainActivity.this, ActionActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        System.out.println("Request is " + requestCode);
//        System.out.println(resultCode +" Result code " + RESULT_OK);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                this.name = data.getStringExtra("person");
                Toast.makeText(MainActivity.this, this.name, Toast.LENGTH_SHORT).show();
//                System.out.print("The data passed is"+this.name);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

     @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle bundle = new Bundle();
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.btn_1:
                i = new Intent(MainActivity.this, UIActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                return true;

            case R.id.btn_2:
                i = new Intent(MainActivity.this, MainActivity.class);
                i.putExtras(bundle);
                startActivity(i);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
