package thibautvincent.extraopdracht.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import thibautvincent.extraopdracht.Constants.Constants;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.R;
import thibautvincent.extraopdracht.Services.DiscussionService;

public class DiscussionDetailFragment extends Fragment {

    private DiscussionService discussionService;
    private Discussion discussion = null;

    @Bind(R.id.tvQuestion)
    public TextView tvQuestion;
    @Bind(R.id.tvFirstAnswer)
    public TextView tvFirstAnswer;
    @Bind(R.id.tvSecondAnswer)
    public TextView tvSecondAnswer;
    @Bind(R.id.tvCompensation)
    public TextView tvCompensation;
    @Bind(R.id.btnCorrectAnswerFriend)
    public Button btnCorrectAnswerFriend;
    @Bind(R.id.btnCorrectAnswerMe)
    public Button btnCorrectAnswerMe;

    public static DiscussionDetailFragment newInstance() {
        DiscussionDetailFragment fragment = new DiscussionDetailFragment();
        return fragment;
    }

    public DiscussionDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.discussionService = DiscussionService.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion_detail, container, false);
        ButterKnife.bind(this, view);

        Bundle args = getActivity().getIntent().getExtras();
        if ( args != null) {
            discussion = this.discussionService.getDiscussionById(args.getInt(Constants.DISCUSSION_ID_TAG));
        }

        if (discussion != null) {
            tvQuestion.setText(discussion.getVraag());
            tvFirstAnswer.setText(discussion.getMijnAntwoord());
            tvSecondAnswer.setText(discussion.getVriendAntwoord());
            tvCompensation.setText(discussion.getCompensatie());
        }

        this.updateButtons();

        return view;
    }

    @OnClick(R.id.btnCorrectAnswerFriend)
    public void changeCorrectAnswerToFriend() {
        this.vote(0);
    }

    @OnClick(R.id.btnCorrectAnswerMe)
    public void changeCorrectAnswerToMe() {
        this.vote(1);
    }

    private void vote(int gewonnen) {
        discussion.setGewonnen(gewonnen);
        discussion = this.discussionService.setWinnerOfDiscussion(discussion);
        this.updateButtons();
    }

    private void updateButtons() {

        if (discussion != null && discussion.getOpgelost() == 1 && discussion.getGewonnen() == 1) {
            btnCorrectAnswerMe.setBackgroundColor(Color.GREEN);
            btnCorrectAnswerFriend.setBackgroundColor(Color.GRAY);
        }

        if (discussion != null && discussion.getOpgelost() == 1 && discussion.getGewonnen() == 0) {
            btnCorrectAnswerFriend.setBackgroundColor(Color.RED);
            btnCorrectAnswerMe.setBackgroundColor(Color.GRAY);
        }
    }

}
