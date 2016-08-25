package thibautvincent.extraopdracht.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import thibautvincent.extraopdracht.API.API;
import thibautvincent.extraopdracht.Constants.Constants;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.Models.Discussion.DiscussionsWrapper;
import thibautvincent.extraopdracht.Models.Statistics.Statistics;

/**
 * Created by Thibaut on 8/24/16.
 */
public class DiscussionService {

    private static DiscussionService instance = null;
    private Retrofit retrofitAdapter;
    private API api;
    private Gson gson;

    public synchronized static DiscussionService getInstance() {
        if (instance == null) {
            instance = new DiscussionService();
        }
        return instance;
    }

    private DiscussionService() {
        this.gson = new GsonBuilder().create();
        this.retrofitAdapter = new Retrofit
                .Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.api = retrofitAdapter.create(API.class);
    }

    public ArrayList<Discussion> getDiscussions() {
        ArrayList<Discussion> listDiscussions = new ArrayList<>();
        try {
            Call call = api.getDiscussions();
            Response<DiscussionsWrapper> data= call.execute();
            List<Discussion> discussions = data.body().getResults();

            for (Discussion discussion : discussions) {
                listDiscussions.add(discussion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listDiscussions;
    }

    public void addDiscussion(Discussion discussion) {
        try {
            Call call = api.addDiscussion(discussion);
            Response<Discussion> response = call.execute();
        } catch (IOException ex) {

        }
    }

    public Discussion getDiscussionById(int id) {
        try {
            Call call = api.getDiscussionById(id);
            Response<Discussion> discussion = call.execute();
            return discussion.body();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Discussion setWinnerOfDiscussion(Discussion discussion) {
        try {
            Call call = api.voteDiscussion(discussion);
            Response<Discussion> data = call.execute();
            return data.body();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Statistics getStatistics() {
        try {
            Call call = api.getStats();
            Response<Statistics> data = call.execute();
            return data.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
