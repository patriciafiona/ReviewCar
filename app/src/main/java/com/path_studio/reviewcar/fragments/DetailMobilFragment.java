package com.path_studio.reviewcar.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.path_studio.reviewcar.R;

import java.util.ArrayList;

public class DetailMobilFragment extends Fragment {

    private ImageView gambar_mobil;
    private TextView mMerk, mHarga, mMesin, mKapasitasMesin,
            mTenagaMesin, mTorsi, mKursi, mKapasitasTangki, mPanjang, mLebar, mTinggi, mPintu;

    private TextView bKapasitasMesin, bBahanBakar, bTenagaMesin; //khusus yang ada di box melayang
    private RatingBar mRating;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_mobil, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //Inisialisasi semuanya

        gambar_mobil        = view.findViewById(R.id.gambar_mobil);

        mRating             = view.findViewById(R.id.ratingBar);

        mHarga              = view.findViewById(R.id.text_harga);
        mKapasitasMesin     = view.findViewById(R.id.text_kapasitas_mesin);
        mKapasitasTangki    = view.findViewById(R.id.text_kapasitas_tangki);
        mKursi              = view.findViewById(R.id.text_kursi);
        mLebar              = view.findViewById(R.id.text_lebar);
        mMerk               = view.findViewById(R.id.text_merk_mobil);
        mMesin              = view.findViewById(R.id.text_mesin);
        mPanjang            = view.findViewById(R.id.text_panjang);
        mPintu              = view.findViewById(R.id.text_pintu);
        mTenagaMesin        = view.findViewById(R.id.text_tenaga_mesin);
        mTinggi             = view.findViewById(R.id.text_tinggi);
        mTorsi              = view.findViewById(R.id.text_torsi);

        bKapasitasMesin     = view.findViewById(R.id.text_box_1);
        bBahanBakar         = view.findViewById(R.id.text_box_2);
        bTenagaMesin        = view.findViewById(R.id.text_box_3);
    }

    public void UI(ArrayList list){
        showProgressDialog();

        hideProgressDialog();
    }

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
