package com.logan19gp.items;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.logan19gp.items.api.AdsItem;

import java.util.ArrayList;
import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ViewHolder> {
    List<AdsItem> adsItems = new ArrayList<>();
    Activity mActivity;

    public void addAds(List<AdsItem> newProducts) {
        adsItems.addAll(newProducts);
        notifyDataSetChanged();
    }

    public AdsAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final AdsItem product = adsItems.get(position);
        holder.titleText.setText(product.getProductName());
        holder.descriptionText.setText(product.getProductDescription());
        holder.rateText.setText(product.getRating() + " - " + product.getNumberOfRatings());
        MyApplication.picasso
                .load(product.getProductThumbnail())
                .into(holder.primaryImage);
        MyApplication.picasso
                .load(product.getAverageRatingImageURL())
                .into(holder.rateImage);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FullActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        mActivity, new Pair<>(view.findViewById(R.id.primary_image), "primary_image")
                );

                intent.putExtra(FullActivity.EXTRA_ADS, product);
                mActivity.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return adsItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout container;
        TextView titleText;
        TextView descriptionText;
        TextView rateText;
        ImageView primaryImage;
        ImageView rateImage;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));

            container = (LinearLayout) itemView.findViewById(R.id.card_container);
            titleText = (TextView) itemView.findViewById(R.id.title_text);
            descriptionText = (TextView) itemView.findViewById(R.id.description_text);
            rateText = (TextView) itemView.findViewById(R.id.rate_text);
            primaryImage = (ImageView) itemView.findViewById(R.id.primary_image);
            rateImage = (ImageView) itemView.findViewById(R.id.rate_image);
        }
    }
}
