package thibautvincent.extraopdracht.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import thibautvincent.extraopdracht.Models.Discussion.Discussion;
import thibautvincent.extraopdracht.R;
import thibautvincent.extraopdracht.Services.DiscussionService;

public class AddDiscussionActivity extends AppCompatActivity {

    @Bind(R.id.etQuestion)
    public EditText etQuestion;

    @Bind(R.id.etFirstAnswer)
    public EditText etFirstAnswer;

    @Bind(R.id.etSecondAnswer)
    public EditText etSecondAnswer;

    @Bind(R.id.etCompensation)
    public EditText etCompensation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_discussion);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSaveDiscussion)
    public void save() {
        if (this.validate()) {
            DiscussionService discussionService = DiscussionService.getInstance();
            Discussion discussion = new Discussion();
            discussion.setVraag(etQuestion.getText().toString());
            discussion.setMijnAntwoord(etFirstAnswer.getText().toString());
            discussion.setVriendAntwoord(etSecondAnswer.getText().toString());
            discussion.setCompensatie(etCompensation.getText().toString());
            try {
                discussionService.addDiscussion(discussion);
            } catch (Exception ex) {
                this.showToast("We weren't able to process your request. Please try it again later.");
            } finally {
                this.showToast("Discussion added.");
                finish();
            }

        }
    }

    private boolean validate() {
        if (etQuestion.getText().toString().isEmpty()) {
            this.showToast("Question is empty");
            return false;
        }
        if (etFirstAnswer.getText().toString().isEmpty()) {
            this.showToast("First answer is empty");
            return false;
        }
        if (etSecondAnswer.getText().toString().isEmpty()) {
            this.showToast("Second answer is empty");
            return false;
        }
        if (etCompensation.getText().toString().isEmpty()) {
            this.showToast("Compensation is empty");
            return false;
        }
        return true;
    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

}
