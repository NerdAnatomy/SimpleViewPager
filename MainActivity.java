package com.example.simpleviewpager;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(11)
public class MainActivity extends Activity {

	private ViewPager mViewPager;
	private Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		ActionBar actionBar = getActionBar();
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.show();

		mViewPager = (ViewPager) findViewById(R.id.pager);
		ArrayList<TextView> tvList = new ArrayList<TextView>();
		for (int i = 0; i < 5; i++) {
			TextView tv = new TextView(mContext);
			tv.setText("Hello! This is page No." + i);
			tv.setTextColor(Color.BLACK);
			tv.setTextSize(20);
			tvList.add(tv);
		}
		mViewPager.setAdapter(new CustomPagerAdapter(tvList));
	}

	public class CustomPagerAdapter extends PagerAdapter {

		private ArrayList<TextView> mViewList;

		public CustomPagerAdapter(ArrayList<TextView> viewList) {
			this.mViewList = viewList;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			if (container.getChildAt(position) == null) {
				((ViewPager) container).addView(mViewList.get(position), 0);
			}
			return mViewList.get(position);
		}

		@Override
		public int getCount() {
			return mViewList.size();
		}

		@Override
		public void destroyItem(View collection, int position, Object view) {
		}

		@Override
		public boolean isViewFromObject(View paramView, Object paramObject) {
			return paramView == ((View) paramObject);
		}

	}

}
