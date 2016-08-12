package tutorial.freelancertraning.tuanvu.baitaplon01.ActualiesActivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

/**
 * Created by 3543 on 8/12/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvContent;
    ImageView ivPhoto;

    public ViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvContent = (TextView) itemView.findViewById(R.id.tvTitle);
        ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);

    }

    public void bind(Bean bean){
        tvTitle.setText(bean.title);
        tvContent.setText(bean.content);
        Glide.with(itemView.getContext()).load(bean.imageURL).into(ivPhoto);
    }
}
