package com.socra.socra.retro_freak.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.socra.socra.retro_freak.fragments.Series_y_Pelis;
import com.socra.socra.retro_freak.fragments.gamer;
import com.socra.socra.retro_freak.fragments.manga;
import com.socra.socra.retro_freak.fragments.superheroes;

public class adaptador_tabs extends FragmentStatePagerAdapter {

    private int numberOfTabs;


    public adaptador_tabs(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;

    }

    @Override
    public  Fragment getItem(int position) {
        switch (position){
            case 0:
                return new manga();
            case 1:
                return new Series_y_Pelis();
            case 2:
                return new gamer();
            case 3:
                return new superheroes();
            default:
                 return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
