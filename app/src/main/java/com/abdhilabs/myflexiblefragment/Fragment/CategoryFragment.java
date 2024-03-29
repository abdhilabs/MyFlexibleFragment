package com.abdhilabs.myflexiblefragment.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abdhilabs.myflexiblefragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_detail_category) {
            if (v.getId() == R.id.btn_detail_category) {
                DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

                /**
                 *  Kelas Bundle merupakan kelas map data string untuk obyek-obyek parcelable.
                 *  Di sini kita bisa menginput lebih dari satu parameter/variabel ke dalam obyek Bundle
                 */

                // Untuk mengirimkan data antar fragment
                Bundle mBundle = new Bundle();
                mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
                String description = "Kategori ini akan berisi produk-produk lifestyle";
                // Data dikirimkan
                mDetailCategoryFragment.setArguments(mBundle);
                // Menggunakan methot setter & getter
                mDetailCategoryFragment.setDescription(description);
                FragmentManager mFragmentManager = getFragmentManager();
                if (mFragmentManager != null) {
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName());
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                }
            }
        }
    }
}
