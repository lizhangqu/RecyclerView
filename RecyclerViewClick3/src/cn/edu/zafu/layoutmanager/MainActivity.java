package cn.edu.zafu.layoutmanager;

import org.lucasr.twowayview.ItemClickSupport;
import org.lucasr.twowayview.ItemClickSupport.OnItemClickListener;
import org.lucasr.twowayview.ItemClickSupport.OnItemLongClickListener;
import org.lucasr.twowayview.ItemSelectionSupport;
import org.lucasr.twowayview.ItemSelectionSupport.ChoiceMode;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private CardViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final String[] data = { "StaggeredGridLayoutManager", "LayoutManager",
				"GridLayoutManager", "Adapter", "ViewHolder",
				"LinearLayoutManager", "CardView", "ListView", "TextView",
				"Vertical", "Horizontal", "RecyclerView" };

		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

		// 如果布局大小一致有利于优化
		mRecyclerView.setHasFixedSize(true);

		// 使用线性布局管理器
		LayoutManager layout = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(layout);

		// 初始化适配器并绑定适配器
		mAdapter = new CardViewAdapter(data);

		mRecyclerView.setAdapter(mAdapter);
		final ItemClickSupport itemClick = ItemClickSupport
				.addTo(mRecyclerView);
		itemClick.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(RecyclerView parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), "短按" + data[position],
						Toast.LENGTH_SHORT).show();
			}

		});

		itemClick.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(RecyclerView parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), "长按" + data[position],
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});

		
	}
}
