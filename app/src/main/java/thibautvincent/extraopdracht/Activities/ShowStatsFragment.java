package thibautvincent.extraopdracht.Activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import thibautvincent.extraopdracht.Models.Statistics.Statistics;
import thibautvincent.extraopdracht.R;
import thibautvincent.extraopdracht.Services.DiscussionService;

public class ShowStatsFragment extends Fragment {

    @Bind(R.id.tvMyWins)
    public TextView tvWins;

    @Bind(R.id.tvFriendWins)
    public TextView tvLoses;

    @Bind(R.id.tvTotalDiscussionsSolved)
    public TextView tvDiscussionsSolved;

    @Bind(R.id.tvTotalDiscussions)
    public TextView tvDiscussions;

    private DiscussionService discussionService;

    public static ShowStatsFragment newInstance() {
        ShowStatsFragment fragment = new ShowStatsFragment();
        return fragment;
    }

    public ShowStatsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_show_stats, container, false);
        ButterKnife.bind(this, view);

        this.discussionService = DiscussionService.getInstance();
        Statistics statistics = this.discussionService.getStatistics();

        tvWins.setText(String.valueOf(statistics.getDiscussionsWon()));
        tvLoses.setText(String.valueOf(statistics.getDiscussionsLost()));
        tvDiscussionsSolved.setText(String.valueOf(statistics.getDiscussionsSolved()));
        tvDiscussions.setText(String.valueOf(statistics.getTotalDiscussions()));

        return view;
    }

}
