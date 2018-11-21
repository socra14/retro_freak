package com.socra.socra.retro_freak.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socra.socra.retro_freak.R;
import com.socra.socra.retro_freak.clases.productossqlite;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link carrito.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link carrito#newInstance} factory method to
 * create an instance of this fragment.
 */
public class carrito extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public carrito() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment carrito.
     */
    // TODO: Rename and change types and number of parameters
    public static carrito newInstance(String param1, String param2) {
        carrito fragment = new carrito();
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
        View view =inflater.inflate(R.layout.fragment_carrito, container, false);
        // Inflate the layout for this fragment
       // registrar();




        return view;
    }

    public void registrar (){
        productossqlite admin = new productossqlite(getContext(),"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();




        ContentValues registro = new ContentValues();

        registro.put("descripcion","vegeta con trunks");
        registro.put("precio","20 euros");
        registro.put("descripcion","snes");
        registro.put("precio","60 euros");
        registro.put("descripcion","mario");
        registro.put("precio","10 euros");
        registro.put("descripcion","camiseta bbt");
        registro.put("precio","12 euros");
        registro.put("descripcion","cortina bbt");
        registro.put("precio","10 euros");
        registro.put("descripcion","camiseta ff");
        registro.put("precio","10 euros");
        registro.put("descripcion","figura cloud");
        registro.put("precio", "15 euros");
        registro.put("descripcion","figura got");
        registro.put("precio","20 euros");
        registro.put("descripcion","gogeta");
        registro.put("precio", "23 euros");
        registro.put("descripcion","camiseta got");
        registro.put("precio","10 euros");
        registro.put("descripcion","figura naruto");
        registro.put("precio","16 euros");
        registro.put("descripcion","figura tia");
        registro.put("precio","12 euros");




        BaseDeDatos.insert("productos",null,registro);
        BaseDeDatos.close();

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
