package tutorial.freelancertraning.tuanvu.baitaplon01.Membres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class MembresActivity extends AppCompatActivity {
    private String finalUrl = "http://vnexpress.net/rss/tin-moi-nhat.rss";
    private DownloadWebPage obj;
    private ListView lvItems;
    private ArrayList<Items> arr = new ArrayList<Items>();
    LayerAdapter strValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membres);
        Intent intent = new Intent();
        lvItems = (ListView) findViewById(R.id.lvItems);
        fetch();
    }
    public void fetch() {
        obj = new DownloadWebPage(this, lvItems, arr, new AsyncResponse() {
            @Override
            public void processFinish(ArrayList<Items> output) {
                arr = output;
            }
        });

        obj.execute(finalUrl);

    }
}
