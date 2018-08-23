package com.londonappbrewery.destini;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;
    int mIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressTree(1);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressTree(2);
            }
        });

    }

    private void progressTree(int choice) {

        switch(mIndex) {
            case 1:
                if(choice == 1) {
                    updateStory(3);
                    mIndex = 3;
                }else {
                    updateStory(2);
                    mIndex = 2;
                }
                break;

            case 2:
                if(choice == 1) {
                    updateStory(3);
                    mIndex = 3;
                }else {
                    displayEnd(4);
                    mIndex = 4;
                }
                break;

            case 3:
                if(choice == 1) {
                    displayEnd(6);
                    mIndex = 4;
                }else {
                    displayEnd(5);
                    mIndex = 4;
                }
                break;

            case 4:
                if(choice == 1) {
                    updateStory(1);
                    mIndex = 1;
                }else {
                    finish();
                }
        }
    }

    private void updateStory(int index) {
        String storyT = "T" + index + "_Story";
        String topB = "T" + index + "_Ans1";
        String bottomB = "T" + index + "_Ans2";

        mStoryText.setText(getStringIdentifier(this, storyT));
        mTopButton.setText(getStringIdentifier(this, topB));
        mBottomButton.setText(getStringIdentifier(this, bottomB));
    }

    private void displayEnd(int index) {
        String ending = "T" + index + "_End";

        mStoryText.setText(getStringIdentifier(this, ending));
        mTopButton.setText(R.string.EndingOp1);
        mBottomButton.setText(R.string.EndingOp2);
    }

    public static int getStringIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }
}
