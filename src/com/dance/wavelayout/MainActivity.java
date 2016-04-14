package com.dance.wavelayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);

		listview.setAdapter(new MyAdapter());

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "点击了第"+position+"条", 0).show();
			}
		});
	}

	class MyAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return 40;
		}
		@Override
		public Object getItem(int position) {
			return null;
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(MainActivity.this,
						R.layout.adapter_list, null);
			}
			TextView text = (TextView) convertView.findViewById(R.id.text);
			String string = position % 2 == 0 ? "天王盖地虎" : "小鸡炖蘑菇";
			text.setText(string + " - " + position);
			

			WaveLayout waveLayout = (WaveLayout) convertView;
			waveLayout.setWaveColor(position%2==0?Color.GRAY:Color.parseColor("#66ff0000"));
			
			if (waveLayout.isDrawingWave()) {
				waveLayout.clearWave();
			}

			return convertView;
		}

	}

}
