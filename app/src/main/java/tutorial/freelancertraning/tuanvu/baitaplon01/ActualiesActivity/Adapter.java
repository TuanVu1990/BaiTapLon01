package tutorial.freelancertraning.tuanvu.baitaplon01.ActualiesActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import tutorial.freelancertraning.tuanvu.baitaplon01.AdvantagesActivity.Bean2;
import tutorial.freelancertraning.tuanvu.baitaplon01.R;

/**
 * Created by 3543 on 8/12/2016.
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<Bean> beanList;

    public Adapter(List<Bean> beanList) {
        this.beanList = beanList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new ViewHolder(layoutInflater.inflate(R.layout.recyrclerview_actualiteslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(beanList.get(position));
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}
