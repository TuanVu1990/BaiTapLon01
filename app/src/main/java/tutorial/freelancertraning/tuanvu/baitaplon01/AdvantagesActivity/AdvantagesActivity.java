package tutorial.freelancertraning.tuanvu.baitaplon01.AdvantagesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class AdvantagesActivity extends AppCompatActivity {
    RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advantages);
        Intent intent= getIntent();
        recyclerView2 = (RecyclerView)findViewById(R.id.recyrcleViewTwo);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        List<Bean2> bean2List = new ArrayList<>();
        for (int i=0; i<=200;i++){
            bean2List.add(new Bean2("Anh gai Han Quoc","https://www.google.com.vn/imgres?imgurl=http%3A%2F%2Fanhnendep.net%2Fwp-content%2Fuploads%2F2016%2F03%2Fanh-girl-xinh-hot-girl-han-quoc-info.jpg&imgrefurl=http%3A%2F%2Fanhnendep.net%2Ftag%2Fhinh-nen-girl-han-quoc-xinh-cute%2F&docid=UpZXsmSUTYQtNM&tbnid=DFStidyDjpTyyM%3A&w=400&h=400&bih=681&biw=1364&ved=0ahUKEwjCrPnk2rvOAhVBHZQKHT_EDmQQMwgpKA4wDg&iact=mrc&uact=8"));

        }
        Adapter2 adapter2 = new Adapter2(bean2List);
        recyclerView2.setAdapter(adapter2);
    }

}
