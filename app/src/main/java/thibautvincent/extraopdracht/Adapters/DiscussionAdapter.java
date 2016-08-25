package thibautvincent.extraopdracht.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import thibautvincent.extraopdracht.Constants.Constants;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.R;

/**
 * Created by Thibaut on 8/24/16.
 */
public class DiscussionAdapter extends ArrayAdapter<Discussion> {

    private Context context;

    private ArrayList<Discussion> discussions;
    private int layoutResourceId;


    public DiscussionAdapter(Context context, int resource, int textViewResourceId, ArrayList<Discussion> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.discussions = objects;
    }

    @Override
    public Discussion getItem(int position) {
        return this.discussions.get(position);
    }

    @Override
    public int getCount() {
        return this.discussions.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DiscussionViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) this.context).getLayoutInflater();
            convertView = layoutInflater.inflate(this.layoutResourceId, parent, false);

            viewHolder = new DiscussionViewHolder();

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (DiscussionViewHolder) convertView.getTag();
        }

        Discussion discussion = this.getItem(position);

        viewHolder.tvDiscussion = (TextView) convertView.findViewById(R.id.list_item_discussion_vraag);
        viewHolder.tvDiscussion.setText(discussion.getVraag());

        viewHolder.ivStatus = (ImageView) convertView.findViewById(R.id.list_item_discussion_status);
        if (discussion.getOpgelost() == 1) {
            Picasso.with(getContext()).load(this.setIconStatus(discussion.getGewonnen())).into(viewHolder.ivStatus);
        }

        return convertView;
    }

    private int setIconStatus(int gewonnen) {
        int icon;
        if(gewonnen == 1) {
            icon = Constants.ICON_SUCCESS;
        } else {
            icon = Constants.ICON_LOST;
        }
        return icon;
    }

    public class DiscussionViewHolder {
        private TextView tvDiscussion;
        private ImageView ivStatus;
    }
}
