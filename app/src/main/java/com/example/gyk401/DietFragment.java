package com.example.gyk401;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DietFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DietFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listView; //litsviewın tanımlanması

    private OnFragmentInteractionListener mListener;

    public DietFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DietFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DietFragment newInstance(String param1, String param2) {
        DietFragment fragment = new DietFragment();
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
       View holder =inflater.inflate(R.layout.fragment_diet, container, false);

       listView=holder.findViewById(R.id.listview); //listviewın atanması
        ArrayList<Food> flist = new ArrayList<>(); //Food tipindeki arrayListin oluşturulması
        //f adında bir food objesi oluşturulması ve listeye eklenmesi
        Food f = new Food("Yumurta,peynir,zeytin",5000.0,R.drawable.yumurta);
        flist.add(f);
         f = new Food("Mevsim yeşillikleri salata",5000.0,R.drawable.salata);
        flist.add(f);
         f = new Food("Badem,fındık,ceviz",5000.0,R.drawable.kuruyemis);
        flist.add(f);
        f = new Food("Kivi,çilek,muz",5000.0,R.drawable.meyve);
        flist.add(f);
        //adapter objesinin tanımlanması
        ListAdapter adapter = new ListAdapter(flist,getContext());
        listView.setAdapter(adapter); //listeye adaptörün set edilmesi
        return holder;
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
