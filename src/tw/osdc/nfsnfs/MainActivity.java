package tw.osdc.nfsnfs;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.view.Menu;

public class MainActivity extends Activity {

	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mActionBar = getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		setTabs();
	}

	private void setTabs() {
		// TODO Auto-generated method stub
		ActionBar.Tab tab1 = mActionBar.newTab().setText(R.string.first);
		ActionBar.Tab tab2 = mActionBar.newTab().setText(R.string.international);
		ActionBar.Tab tab3 = mActionBar.newTab().setText(R.string.second);
		
		ListFragment lf1 = new MyListFragment();
		ListFragment lf2 = new MyListFragment(); //international
		ListFragment lf3 = new MyListFragment();
		
		setArguments(lf1, FirstRoom.topics, FirstRoom.authors, FirstRoom.time);
		setArguments(lf2, IntlRoom.topics, IntlRoom.authors, IntlRoom.time);
		setArguments(lf3, SecondRoom.topics, SecondRoom.authors, SecondRoom.time);
		
		tab1.setTabListener(new MyTabListener(lf1));
		tab2.setTabListener(new MyTabListener(lf2));
		tab3.setTabListener(new MyTabListener(lf3));
		
		mActionBar.addTab(tab1);
		mActionBar.addTab(tab2);
		mActionBar.addTab(tab3);		
		
	}

	private void setArguments(Fragment fragment, String[][] topics, String[][] authors,
			String[][] time) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		bundle.putSerializable("topics", topics);
		bundle.putSerializable("authors", authors);
		bundle.putSerializable("time", time);
		fragment.setArguments(bundle);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class MyTabListener implements ActionBar.TabListener {

		private Fragment mFragment;
		
		public MyTabListener(Fragment f) {
			this.mFragment = f;
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			ft.add(R.id.fragment, mFragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			ft.remove(mFragment);
		}
		
	}
}
