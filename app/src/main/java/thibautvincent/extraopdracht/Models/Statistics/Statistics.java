package thibautvincent.extraopdracht.Models.Statistics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thibaut on 8/24/16.
 */
public class Statistics {

    @SerializedName("mij")
    @Expose
    private int discussionsWon;

    @SerializedName("vriend")
    @Expose
    private int discussionsLost;

    @SerializedName("totaalOpgelost")
    @Expose
    private int discussionsSolved;

    public int getDiscussionsSolved() {
        return discussionsSolved;
    }

    public void setDiscussionsSolved(int discussionsSolved) {
        this.discussionsSolved = discussionsSolved;
    }

    @SerializedName("totaal")
    @Expose
    private int totalDiscussions;

    public int getDiscussionsWon() {
        return discussionsWon;
    }

    public void setDiscussionsWon(int discussionsWon) {
        this.discussionsWon = discussionsWon;
    }

    public int getDiscussionsLost() {
        return discussionsLost;
    }

    public void setDiscussionsLost(int discussionsLost) {
        this.discussionsLost = discussionsLost;
    }

    public int getTotalDiscussions() {
        return totalDiscussions;
    }

    public void setTotalDiscussions(int totalDiscussions) {
        this.totalDiscussions = totalDiscussions;
    }
}
