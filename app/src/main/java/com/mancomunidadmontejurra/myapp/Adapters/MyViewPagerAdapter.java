package com.mancomunidadmontejurra.myapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.mancomunidadmontejurra.myapp.Fragments.AveriaFragment;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentArray;
    private int numberOfTabs;

    public MyViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numberOfTabs = behavior;
        fragmentArray = new ArrayList<>();
        //fragmentArray.add(new ChatsFragment());
        fragmentArray.add(new AveriaFragment());

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}
