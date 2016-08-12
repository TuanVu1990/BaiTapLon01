package tutorial.freelancertraning.tuanvu.baitaplon01.AdvantagesActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

/**
 * Created by 3543 on 8/12/2016.
 */
public class Adapter2 extends RecyclerView.Adapter<ViewHolder2> {
    List<Bean2>bean2List;

    public Adapter2(List<Bean2> bean2List) {
        this.bean2List = bean2List;
    }

    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder2(layoutInflater.inflate(R.layout.recyrclerview_advantageslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
        holder.bind2(bean2List.get(position));
    }

    @Override
    public int getItemCount() {
        return bean2List.size();
    }
}
