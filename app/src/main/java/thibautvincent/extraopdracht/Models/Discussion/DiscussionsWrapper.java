package thibautvincent.extraopdracht.Models.Discussion;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thibaut on 8/24/16.
 */
public class DiscussionsWrapper {

    @Expose
    private List<Discussion> results = new ArrayList<Discussion>();

    public List<Discussion> getResults() {
        return results;
    }

    public void setResults(List<Discussion> results) {
        this.results = results;
    }
}
