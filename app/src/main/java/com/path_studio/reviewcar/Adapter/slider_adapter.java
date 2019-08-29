package com.path_studio.reviewcar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.path_studio.reviewcar.R;

public class slider_adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slider_adapter(Context context){
        this.context = context;
    }

    //Arrays
    public int [] image = {
            R.drawable.mobil_alya,
            R.drawable.mobil_yaris,
            R.drawable.mobil_avanza,
            R.drawable.mobil_calya,
            R.drawable.mobil_xenia
    };

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (LinearLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.template_slider_car, container, false);

        ImageView slideImageView    = (ImageView) view.findViewById(R.id.gambar_mobil);

        slideImageView.setImageResource(image[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }

}
