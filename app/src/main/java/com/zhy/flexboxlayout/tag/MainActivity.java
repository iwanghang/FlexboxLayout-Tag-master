package com.zhy.flexboxlayout.tag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TagFlowLayout tagFlowLayout;
    LayoutInflater mInflater;

    private String[] mVals = new String[]
            {"Hello", "AndroidAndroidAndroidAndroidAndroidAndroidAndroid", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);

        tagFlowLayout = (TagFlowLayout) findViewById(R.id.id_tagFlowLayout);
        tagFlowLayout.setAdapter(new TagAdapter<String>(mVals)
        {
            @Override
            protected View getView(ViewGroup parent, int position, String s)
            {

//                TextView tv = (TextView) mInflater.inflate(R.layout.tv, parent, false);
//                tv.setText(s);
//                return tv;

                LinearLayout wh_tag = (LinearLayout) mInflater.inflate(R.layout.wh_tag, parent, false);
                wh_tag.setBackgroundResource(R.drawable.normal_bg);

                ImageView wh_tag_img = (ImageView) wh_tag.findViewById(R.id.wh_tag_img);
                wh_tag_img.setImageResource(R.mipmap.tag_horn_normal);

                TextView wh_tag_tv = (TextView) wh_tag.findViewById(R.id.wh_tag_tv);
                wh_tag_tv.setText(s);
                wh_tag_tv.setTextColor(Color.parseColor("#64646A"));

                return wh_tag;

            }

            @Override
            protected void onSelect(ViewGroup parent, View view, int position)
            {
                Toast.makeText(MainActivity.this, "onSelect = " + position, Toast.LENGTH_SHORT).show();

                LinearLayout wh_tag = (LinearLayout) view.findViewById(R.id.wh_tag);
                wh_tag.setBackgroundResource(R.drawable.checked_bg);

                ImageView wh_tag_img = (ImageView) wh_tag.findViewById(R.id.wh_tag_img);
                wh_tag_img.setImageResource(R.mipmap.tag_horn_checked);

                TextView wh_tag_tv = (TextView) view.findViewById(R.id.wh_tag_tv);
                wh_tag_tv.setTextColor(Color.parseColor("#ffffff"));
            }

            @Override
            protected void onUnSelect(ViewGroup parent, View view, int position)
            {
                Toast.makeText(MainActivity.this, "onUnSelect = " + position, Toast.LENGTH_SHORT).show();

                LinearLayout wh_tag = (LinearLayout) view.findViewById(R.id.wh_tag);
                wh_tag.setBackgroundResource(R.drawable.normal_bg);

                ImageView wh_tag_img = (ImageView) wh_tag.findViewById(R.id.wh_tag_img);
                wh_tag_img.setImageResource(R.mipmap.tag_horn_normal);

                TextView wh_tag_tv = (TextView) view.findViewById(R.id.wh_tag_tv);
                wh_tag_tv.setTextColor(Color.parseColor("#64646A"));
            }

            @Override
            protected boolean select(int position) {
                Toast.makeText(MainActivity.this, "select = " + position, Toast.LENGTH_SHORT).show();
                return super.select(position);
            }

            //            @Override
//            protected boolean select(int position)
//            {
////                if (position == 0) return true;
//
//                return super.select(position);
//            }

        });

//        tagFlowLayout.setJustifyContent(FlexboxLayout.JUSTIFY_CONTENT_CENTER);
    }
}
