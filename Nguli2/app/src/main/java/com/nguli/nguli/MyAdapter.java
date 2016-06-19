package com.nguli.nguli;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.nguli.nguli.Fragment.FragNotif;
import com.nguli.nguli.Fragment.FragUser;


/**
 * Created by Nursaputra on 6/18/2016.
 */
public class MyAdapter extends FragmentPagerAdapter{
    private Context mContext;
    private String[] titles = {"B", "N", "A"};
    int [] icons = new int[]{R.mipmap.toko,R.mipmap.notif,R.mipmap.user};
    private int heightIcon;

    public MyAdapter(FragmentManager fm,Context c) {
        super(fm);

        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new RecyclerViewFragment();
        }
        else if (position == 1){
            frag = new FragNotif();
        }
        else if (position == 2){
            frag = new FragUser();
        }

        Bundle b = new Bundle();
        b.putInt("position",position);
        return frag;


    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icons[position]);
        d.setBounds(0,0,heightIcon,heightIcon);

        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return (sp);
    }
}
