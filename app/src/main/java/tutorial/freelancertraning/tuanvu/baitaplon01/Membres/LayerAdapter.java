package tutorial.freelancertraning.tuanvu.baitaplon01.Membres;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class LayerAdapter extends ArrayAdapter<Items> {
	Context context;// tao doi tuong Context
	ArrayList<Items> arrItems = new ArrayList<Items>();

	// ke thua lai ham tao 3 tham so nay
	public LayerAdapter(Context context, int customListview,
			ArrayList<Items> objects) {
		super(context, customListview, objects);
		this.context = context;
		arrItems = objects;
	}

	// tao lop ViewHolder co cac thuoc tinh tren giao dien custom
	public static class ViewHolder {
		TextView tvTitle, tvDate;
		ImageView imgAvatar;
		Bitmap bm;
		String link;
	}

	// override lai ham getView de xay dung du lieu cho 1 dong
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder vh;
		if (rowView == null) {// lan dau bat len thi rowview se null
			LayoutInflater inflate = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflate.inflate(R.layout.list_item, null);
			vh = new ViewHolder();
			vh.tvTitle = (TextView) rowView.findViewById(R.id.title);
			vh.tvDate = (TextView) rowView.findViewById(R.id.date);
			vh.imgAvatar = (ImageView) rowView.findViewById(R.id.avatar);

			rowView.setTag(vh);// set du lieu tu viewHolder cho rowview
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		Items item = arrItems.get(position);
		vh.tvTitle.setText(item.getTitle());
		vh.tvDate.setText(item.getDate());
		vh.link = item.getImage();
		new DownloadImg(vh).execute(vh.link);

		return rowView;
	}
}
