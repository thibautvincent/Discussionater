package thibautvincent.extraopdracht.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import thibautvincent.extraopdracht.Adapters.DiscussionAdapter;
import thibautvincent.extraopdracht.Constants.Constants;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.R;
import thibautvincent.extraopdracht.Services.DiscussionService;

public class DiscussionsOverviewFragment extends Fragment {

    private DiscussionAdapter discussionAdapter;
    private DiscussionService discussionService;
    public ListView listDiscussions;

    public static DiscussionsOverviewFragment newInstance() {
        DiscussionsOverviewFragment fragment = new DiscussionsOverviewFragment();
        return fragment;
    }

    public DiscussionsOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_discussions_overview, container, false);

        this.discussionAdapter = new DiscussionAdapter(getContext(), R.layout.discussion_list_item, R.id.list_discussions, new ArrayList<Discussion>());

        this.discussionService = DiscussionService.getInstance();

        this.listDiscussions = (ListView) view.findViewById(R.id.list_discussions);
        this.getDiscussions();

        listDiscussions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Discussion discussion = discussionAdapter.getItem(position);

                Toast.makeText(getActivity(), discussion.getVraag(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), DiscussionDetailActivity.class);
                intent.putExtra(Constants.DISCUSSION_ID_TAG, discussion.getId());
                startActivity(intent);
            }
        });

        return view;
    }

    private void getDiscussions() {
        discussionAdapter.clear();
        this.discussionAdapter.addAll(this.discussionService.getDiscussions());

        listDiscussions.setAdapter(this.discussionAdapter);
        discussionAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.getDiscussions();
    }
}
