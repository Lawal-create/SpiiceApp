package com.example.spiiceapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spiiceapp.OnboardingItem;
import com.example.spiiceapp.R;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<OnboardingItem> onboardingItems;

    public OnboardingAdapter(List<OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                //inflate the layout fot this activity
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));

    }

    @Override
    public int getItemCount() {

        return onboardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder{

        private TextView textDescription;
        private ImageView imageOnBoarding;
        private TextView textView;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnBoarding = itemView.findViewById(R.id.imageOnBoarding);
            textView = itemView.findViewById(R.id.textView);
        }

        void setOnboardingData(OnboardingItem onboardingItem){
            textView.setText(onboardingItem.getTextView());
            textDescription.setText(onboardingItem.getDescription());
            imageOnBoarding.setImageResource(onboardingItem.getImage());
        }
    }
}
