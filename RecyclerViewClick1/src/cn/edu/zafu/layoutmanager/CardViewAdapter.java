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
		this(data, null, null);
	}

	public CardViewAdapter(String[] data, OnItemClickListener onClickListener) {
		this(data, onClickListener, null);
	}

	public CardViewAdapter(String[] data, OnItemClickListener onClickListener,
			OnItemLongClickListener onLongClickListener) {
		this.data = data;
		this.onClickListener = onClickListener;
		this.onLongClickListener = onLongClickListener;
	}

	@Override
	public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// 绑定布局
		View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.item, null);
		// 创建ViewHolder
		ViewHolder viewHolder = new ViewHolder(itemLayoutView, onClickListener,
				onLongClickListener);
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
		public ViewHolder(View itemLayoutView,
				final OnItemClickListener onClickListener,
				final OnItemLongClickListener onLongClickListener) {
			super(itemLayoutView);
			info = (TextView) itemLayoutView.findViewById(R.id.info_text);
			itemLayoutView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (onClickListener != null) {
						onClickListener.onClick(v);
					}
				}
			});
			itemLayoutView.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					if (onLongClickListener != null) {
						onLongClickListener.onLongClick(v);
					}
					return true;
				}
			});
		}
	}

	interface OnItemClickListener {
		void onClick(View v);
	}

	interface OnItemLongClickListener {
		void onLongClick(View v);
	}

	private OnItemClickListener onClickListener;
	private OnItemLongClickListener onLongClickListener;


}
