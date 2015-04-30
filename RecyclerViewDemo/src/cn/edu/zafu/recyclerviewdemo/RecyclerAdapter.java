package cn.edu.zafu.recyclerviewdemo;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.edu.zafu.recyclerviewdemo.RecyclerAdapter.ItemViewHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
	private List<Item> items;
	//点击监听事件
	interface OnRecyclerViewItemClickListener{
		void onClick(View view,int position);
	};
	private OnRecyclerViewItemClickListener listener;
	
	public void setListener(OnRecyclerViewItemClickListener listener) {
		this.listener = listener;
	}
	public RecyclerAdapter(List<Item> items) {
		this.items = items;
	}
	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.item, viewGroup, false);
		return new ItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ItemViewHolder viewHolder,final int position) {
		Item item = items.get(position);
		viewHolder.img.setImageResource(item.getImg());
		viewHolder.title.setText(item.getTitle());
		viewHolder.description.setText(item.getDescription());
		viewHolder.time.setText(item.getTime());
		
		viewHolder.itemView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (listener!=null) {
					listener.onClick(viewHolder.itemView, position);
				}
				
			}
		});
	}

	public final static class ItemViewHolder extends RecyclerView.ViewHolder {
		ImageView img;
		TextView title;
		TextView description;
		TextView time;

		public ItemViewHolder(View itemView) {
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.img);
			title = (TextView) itemView.findViewById(R.id.title);
			description = (TextView) itemView.findViewById(R.id.description);
			time = (TextView) itemView.findViewById(R.id.time);
		}
	}
}
