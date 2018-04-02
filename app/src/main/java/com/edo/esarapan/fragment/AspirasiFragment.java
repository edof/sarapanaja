package com.edo.esarapan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.edo.esarapan.R;
import com.edo.esarapan.app.AppConfig;
import com.edo.esarapan.app.VolleySingleton;
import com.edo.esarapan.model.AspirasiAdapter;
import com.edo.esarapan.model.AspirasiItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Edo Firmansyah on 3/17/2018.
 */

public class AspirasiFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private Context context;
    private View view;
    ArrayList <AspirasiItem> aspList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //layout untuk fragment
        view = inflater.inflate(R.layout.fragment_aspirasi, container, false);
        context = container.getContext();
        mProgressBar = view.findViewById(R.id.progressbar_aspirasi);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_ASP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mProgressBar.setVisibility(View.GONE);

                aspList = new ArrayList<>();

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String idAsp = jsonObject.getString("id_aspirasi");
                        String namaAsp = jsonObject.getString("nama");
                        String phonemail = jsonObject.getString("phonemail");
                        String uraianAsp = jsonObject.getString("uraian");
                        String jalanAsp = jsonObject.getString("jalan");
                        String rtAsp = jsonObject.getString("rt");
                        String rwAsp = jsonObject.getString("rw");
                        String kelAsp = jsonObject.getString("kelurahan");
                        String kecAsp = jsonObject.getString("kecamatan");
                        String createAsp = jsonObject.getString("created_at");
                        String kategoriAsp = jsonObject.getString("nama_kategori");

                        Log.e("cek", uraianAsp);

                        AspirasiItem mAsp = new AspirasiItem(idAsp, namaAsp, phonemail, uraianAsp, jalanAsp, rtAsp, rwAsp, kelAsp, kecAsp, createAsp, kategoriAsp);
                        aspList.add(mAsp);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                AspirasiAdapter aspirasiAdapter = new AspirasiAdapter(context, aspList);
                mRecyclerView = (RecyclerView) view.findViewById(R.id.rvAspirasi);
                mRecyclerView.setHasFixedSize(true);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(aspirasiAdapter);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mengubah judul pada toolbar
        getActivity().setTitle("Aspirasi");
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}