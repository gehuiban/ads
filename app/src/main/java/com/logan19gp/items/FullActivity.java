package com.logan19gp.items;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.logan19gp.items.api.AdsItem;

public class FullActivity extends AppCompatActivity {

    public static final String EXTRA_ADS = "EXTRA_ADS";
    private AdsItem adsItem;

    private TextView titleText;
    private TextView descriptionText;
    private TextView callToActionText;
    private TextView rateText;
    private TextView categoryText;
    private TextView appIdText;
    private TextView productIdText;
    private TextView creativeIdText;
    private TextView homeScreenText;
    private TextView campaignDisplayOrderText;
    private TextView campaignIdText;
    private TextView campaignTypeIdText;
    private TextView isRandomPickText;
    private TextView minOsVersionText;
    private TextView bidRateText;

    private ImageView primaryImage;
    private ImageView rateImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_page);

        final Intent intent = getIntent();
        adsItem = intent.getParcelableExtra(EXTRA_ADS);

        titleText = (TextView) findViewById(R.id.title_text);
        descriptionText = (TextView) findViewById(R.id.description_text);
        callToActionText = (TextView) findViewById(R.id.call_to_action_text);
        rateText = (TextView) findViewById(R.id.rate_text);
        appIdText = (TextView) findViewById(R.id.app_id_text);
        productIdText = (TextView) findViewById(R.id.product_id_text);
        categoryText = (TextView) findViewById(R.id.category_text);
        creativeIdText = (TextView) findViewById(R.id.creative_id_text);
        homeScreenText = (TextView) findViewById(R.id.home_screen_text);
        campaignDisplayOrderText = (TextView) findViewById(R.id.campaign_display_order_text);
        campaignIdText = (TextView) findViewById(R.id.campaign_id_text);
        campaignTypeIdText = (TextView) findViewById(R.id.campaign_type_id_text);
        isRandomPickText = (TextView) findViewById(R.id.is_random_pick_text);
        minOsVersionText = (TextView) findViewById(R.id.min_os_version_text);
        bidRateText = (TextView) findViewById(R.id.bid_rate_text);

        primaryImage = (ImageView) findViewById(R.id.primary_image);
        rateImage = (ImageView) findViewById(R.id.rate_image);

        MyApplication.picasso
                .load(adsItem.getProductThumbnail())
                .into(primaryImage);
        MyApplication.picasso
                .load(adsItem.getAverageRatingImageURL())
                .into(rateImage);
        titleText.setText(adsItem.getProductName());
        descriptionText.setText(adsItem.getProductDescription());
        callToActionText.setText(adsItem.getCallToAction());
        callToActionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(adsItem.getClickProxyURL()));
                    startActivity(viewIntent);
                } catch (Exception e) {
                    Toast.makeText(FullActivity.this, "Unable to Connect Try Again...", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        rateText.setText(adsItem.getRating() + " - " + adsItem.getNumberOfRatings());
        categoryText.setText(adsItem.getCategoryName());
        appIdText.setText(adsItem.getAppId());

        if (adsItem.getProductId() != null) {
            productIdText.setText(String.valueOf(adsItem.getProductId()));
        }
        if (adsItem.getBidRate() != null) {
            bidRateText.setText(String.valueOf(adsItem.getBidRate()));
        }
        if (adsItem.getMinOSVersion() != null) {
            minOsVersionText.setText(String.valueOf(adsItem.getMinOSVersion()));
        }
        if (adsItem.getCreativeId() != null) {
            creativeIdText.setText(String.valueOf(adsItem.getCreativeId()));
        }

        homeScreenText.setText(String.valueOf(adsItem.getHomeScreen()));
        campaignDisplayOrderText.setText(String.valueOf(adsItem.getCampaignDisplayOrder()));
        campaignIdText.setText(String.valueOf(adsItem.getCampaignId()));
        campaignTypeIdText.setText(String.valueOf(adsItem.getCampaignTypeId()));
        isRandomPickText.setText(String.valueOf(adsItem.getRandomPick()));
    }

}
