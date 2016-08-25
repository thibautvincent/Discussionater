package thibautvincent.extraopdracht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import thibautvincent.extraopdracht.Activities.AddDiscussionActivity;
import thibautvincent.extraopdracht.Activities.ShowStatsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overview, menu);
        return true;
    }

    public void addDiscussion(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Add discussion", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AddDiscussionActivity.class);
        startActivity(intent);
    }

    public void showStats(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Show statistics", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShowStatsActivity.class);
        startActivity(intent);
    }
}
