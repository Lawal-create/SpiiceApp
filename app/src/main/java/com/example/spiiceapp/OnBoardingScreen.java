package com.example.spiiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.spiiceapp.Adapters.OnboardingAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingScreen extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);



        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);

        setupOnboardingItem();
        setCurrentOnboardingIndicators(0);


        //set up view pager
        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });

    }

    private void setupOnboardingItem(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        //onBoarding screen details
        OnboardingItem onBoardingMessage = new OnboardingItem();
        onBoardingMessage.setDescription("Find projects from companies everywhere in the world");
        onBoardingMessage.setImage(R.drawable.planet);
        onBoardingMessage.setTextView("Spiice");

        //make Money screen
        OnboardingItem makeMoneyScreen = new OnboardingItem();
        makeMoneyScreen.setTextView("Spiice");
        makeMoneyScreen.setDescription("Make money while working on awesome projects");
        makeMoneyScreen.setImage(R.drawable.money_illustration);

        //chat screen details
        OnboardingItem chatScreen = new OnboardingItem();
        chatScreen.setDescription("Chat with other freelancers and develop your network");
        chatScreen.setImage(R.drawable.phone_illustration);
        chatScreen.setTextView("Spiice");


        //plus one Screen details
        OnboardingItem plusOneScreen = new OnboardingItem();
        plusOneScreen.setTextView("Spiice");
        plusOneScreen.setImage(R.drawable.work_hard);
        plusOneScreen.setDescription("Work hard and level up!");

        //progress screen details
        OnboardingItem progressScreen = new OnboardingItem();
        progressScreen.setTextView("Spiice");
        progressScreen.setDescription("Enjoy your progress!");
        progressScreen.setImage(R.drawable.progress);


        onboardingItems.add(chatScreen);
        onboardingItems.add(plusOneScreen);
        onboardingItems.add(progressScreen);
        onboardingItems.add(onBoardingMessage);
        onboardingItems.add(makeMoneyScreen);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }
    private void setCurrentOnboardingIndicators(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            }else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
    }
}
