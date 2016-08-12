package tutorial.freelancertraning.tuanvu.baitaplon01.ActualiesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class ActualitesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualites);
        Intent intent= getIntent();
        recyclerView = (RecyclerView)findViewById(R.id.recyrcleViewOne);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Bean> beanList= new ArrayList<>();
        for (int i=0;i<=200;i++){
            beanList.add(new Bean("Anh NGOC TRINH","It's is my idol","http://kenh14cdn.com/thumb_w/600/2016/angelaphuongtrinh01-1455902689083.jpg"));

        }
        Adapter adapter = new Adapter(beanList);
        recyclerView.setAdapter(adapter);
    }
}
