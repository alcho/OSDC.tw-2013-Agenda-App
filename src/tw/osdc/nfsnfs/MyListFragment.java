package tw.osdc.nfsnfs;

import java.util.ArrayList;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MyListFragment extends ListFragment {
	
	String[][] mTime;
	String[][] mTopics;
	String[][] mAuthors;
	
	ArrayList<AgendaAdapter> mAdapterList;
	
	private Spinner mSpinner = null;
	int now = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_list, container, false);
		setSpinnder(v);
		
		return v;
	}

	private void setSpinnder(View v) {
		// TODO Auto-generated method stub
		String[] date = { "Day 1", "Day 2"};
		
		mSpinner = (Spinner) v.findViewById(R.id.spinner);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, date);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
		
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == 0) {
					setListAdapter(mAdapterList.get(0));
				}else {
					setListAdapter(mAdapterList.get(1));
				}
				now = arg2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}			
		});
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mTopics = (String[][]) getArguments().getSerializable("topics");
		mAuthors = (String[][]) getArguments().getSerializable("authors");
		mTime = (String[][]) getArguments().getSerializable("time");
		
		mAdapterList = new ArrayList<AgendaAdapter>();
		for(int i = 0; i < 2; i++) {
			AgendaAdapter test = new AgendaAdapter(getActivity(), mTopics[i], mAuthors[i], mTime[i]);
			mAdapterList.add(test);
		}
		
		
		setListAdapter(mAdapterList.get(0));
	}

}
