package cn.edu.zafu.layoutmanager;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.zafu.layoutmanager.CardViewAdapter.OnItemClickListener;
import cn.edu.zafu.layoutmanager.CardViewAdapter.OnItemLongClickListener;

public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private CardViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] data = { "StaggeredGridLayoutManager", "LayoutManager", "GridLayoutManager", "Adapter", "ViewHolder",
				"LinearLayoutManager", "CardView", "ListView", "TextView",
				"Vertical", "Horizontal", "RecyclerView" };

		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);


		//如果布局大小一致有利于优化
		mRecyclerView.setHasFixedSize(true);

		//使用线性布局管理器
		LayoutManager layout = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(layout);
		

		//初始化适配器并绑定适配器
		mAdapter = new CardViewAdapter(data,new OnItemClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView info = (TextView) v.findViewById(R.id.info_text);
				Toast.makeText(getApplicationContext(), "单击"+info.getText(), Toast.LENGTH_LONG).show();
			}
		},new OnItemLongClickListener() {
			
			@Override
			public void onLongClick(View v) {
				TextView info = (TextView) v.findViewById(R.id.info_text);
				Toast.makeText(getApplicationContext(), "长按"+info.getText(), Toast.LENGTH_LONG).show();
		
			}
		});
		
		mRecyclerView.setAdapter(mAdapter);
	}
}
