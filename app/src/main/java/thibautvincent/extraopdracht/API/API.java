package thibautvincent.extraopdracht.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.Models.Discussion.DiscussionsWrapper;
import thibautvincent.extraopdracht.Models.Statistics.Statistics;

/**
 * Created by Thibaut on 8/24/16.
 */
public interface API {

    @GET("/getDiscussions")
    Call<DiscussionsWrapper> getDiscussions();

    @POST("/saveDisc")
    Call<Discussion> addDiscussion(@Body Discussion discussion);

    @GET("/disc/{id}")
    Call<Discussion> getDiscussionById(@Path("id") int id);

    @POST("/discVoted")
    Call<Discussion> voteDiscussion(@Body Discussion discussion);

    @GET("/stats")
    Call<Statistics> getStats();

}
