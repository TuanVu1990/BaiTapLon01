package tutorial.freelancertraning.tuanvu.baitaplon01.AgendarActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent= getIntent();
        CircleImageView imgProfile = (CircleImageView) findViewById(R.id.img_profile);
        imgProfile.setBorderColor(Color.WHITE);
        imgProfile.setBorderWidth(4);
    }

}
