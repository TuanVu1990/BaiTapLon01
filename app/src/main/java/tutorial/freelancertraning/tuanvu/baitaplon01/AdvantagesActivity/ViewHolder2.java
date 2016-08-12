package tutorial.freelancertraning.tuanvu.baitaplon01.AdvantagesActivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

/**
 * Created by 3543 on 8/12/2016.
 */
public class ViewHolder2 extends RecyclerView.ViewHolder {
    TextView tvTitle2;
    ImageView imgPhoto2;
    public ViewHolder2(View itemView) {
        super(itemView);
        tvTitle2 = (TextView)itemView.findViewById(R.id.tvTitle2);
        imgPhoto2 = (ImageView)itemView.findViewById(R.id.ivPhoto2);
    }
    public void bind2(Bean2 bean2){
        tvTitle2.setText(bean2.title2);
        Glide.with(itemView.getContext()).load(bean2.imgURL2).into(imgPhoto2);
    }
}
