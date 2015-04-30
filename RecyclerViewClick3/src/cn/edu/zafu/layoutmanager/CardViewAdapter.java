package cn.edu.zafu.layoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardViewAdapter extends
		RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
	// 数据集
	public String[] data;

	public CardViewAdapter(String[] data) {
		this.data = data;
	}

	@Override
	public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// 绑定布局
		View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.item, null);
		// 创建ViewHolder
		ViewHolder viewHolder = new ViewHolder(itemLayoutView);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		// 绑定数据
		viewHolder.info.setText(data[position].toString());

	}

	@Override
	public int getItemCount() {
		return data.length;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView info;
		public ViewHolder(View itemLayoutView) {
			super(itemLayoutView);
			info = (TextView) itemLayoutView.findViewById(R.id.info_text);
		}
	}

}
