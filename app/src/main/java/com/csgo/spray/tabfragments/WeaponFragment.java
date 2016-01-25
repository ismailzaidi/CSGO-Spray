package com.csgo.spray.tabfragments;

import java.util.ArrayList;

import com.csgo.spray.adapter.WeaponRecyclerAdapter;
import com.csgo.spray.model.DataFetcher;
import com.csgo.spray.model.Weapon;
import com.csgospray.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;

public class WeaponFragment extends Fragment {
    private static String KEY_WEAPON = "com.csgo.spray.key";
    private WeaponRecyclerAdapter adapter;
    private DataFetcher dataFetcher;
    private ArrayList<Weapon> list;

    public static WeaponFragment InstanceOf(String weaponCategory) {
        WeaponFragment fragment = new WeaponFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_WEAPON, weaponCategory);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String category = getArguments().getString(KEY_WEAPON);
        list = DataFetcher.getInstance(getActivity()).getCategory(category);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weapon_fragment_item, container,
                false);
        RecyclerView listView = (RecyclerView) view.findViewById(R.id.listViewWeapons);
        listView.setLayoutManager(new GridLayoutManager(getContext(),2));
        listView.setItemAnimator(new FadeInDownAnimator());
        adapter = new WeaponRecyclerAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        return view;
    }
}
