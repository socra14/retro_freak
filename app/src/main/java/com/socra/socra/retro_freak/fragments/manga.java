package com.socra.socra.retro_freak.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.activitis.Dragon_ball;
import com.socra.socra.retro_freak.activitis.Naruto;
import com.socra.socra.retro_freak.adaptadores.adaptador_fr_peq;
import com.socra.socra.retro_freak.clases.categorias;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link manga.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link manga#newInstance} factory method to
 * create an instance of this fragment.
 */
public class manga extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layout;
    private List<categorias> categorias;

    public manga() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment manga.
     */
    // TODO: Rename and change types and number of parameters
    public static manga newInstance(String param1, String param2) {
        manga fragment = new manga();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manga, container, false);

        layout= new LinearLayoutManager(getContext());
        categorias = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recicler_manga);
        getallproductos();

        adapter = new adaptador_fr_peq(categorias,R.layout.item_list_peque,new adaptador_fr_peq.OnItemClickListener() {


            @Override
            public void OnItemClick(View view, int position) {
                if(position ==0 ){
                    Intent intent = new Intent(getActivity(), Dragon_ball.class);
                    getActivity().startActivity(intent);

                }

                if(position==1){
                    Intent intent = new Intent(getActivity(), Naruto.class);
                    getActivity().startActivity(intent);
                }


            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);


        return view;
    }

    private void getallproductos(){
        categorias.add(new categorias(R.drawable.icondb,"DragonBall"));
        categorias.add(new categorias(R.drawable.iconnaru,"Naruto"));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
