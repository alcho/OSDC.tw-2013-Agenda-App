package tw.osdc.nfsnfs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AgendaAdapter extends BaseAdapter {

	private String[] mTime;
	private String[] mTopic;
	private String[] mAuthor;
	private LayoutInflater mInflater;

	
	AgendaAdapter(Context context, String[] topic, String[] author, String[] time) {
		this.mTopic = topic;
		this.mAuthor = author;
		this.mTime = time;
		//this.mDescription = description;
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTopic.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if(convertView == null) {
			holder = new ViewHolder();
			
			convertView = mInflater.inflate(R.layout.listrow, null);
			holder.time = (TextView) convertView.findViewById(R.id.time);
			holder.topic = (TextView) convertView.findViewById(R.id.topic);
			holder.author = (TextView) convertView.findViewById(R.id.author);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.time.setText(mTime[position]);
		holder.topic.setText(mTopic[position]);
		holder.author.setText(mAuthor[position]);
		
		return convertView;
	}
	
    static class ViewHolder {
        TextView time;
        TextView topic;
        TextView author;
    }

}
