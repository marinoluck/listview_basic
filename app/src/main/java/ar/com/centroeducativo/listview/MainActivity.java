package ar.com.centroeducativo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // pido con el findViewById
        listView = (ListView) findViewById(R.id.list_view);
        // set del adapter, Esta linea es la que hace que la lista se llene
        listView.setAdapter(new UsersAdapter(this));
    }
}
