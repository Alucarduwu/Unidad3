package com.example.navigationcomponent;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link configurar_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class configurar_fragment extends Fragment
        implements GestureOverlayView.OnGesturePerformedListener {


    private GestureLibrary gLibrary;
    private View viewFragment;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String tag;

    public configurar_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment configurar_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static configurar_fragment newInstance(String param1, String param2) {
        configurar_fragment fragment = new configurar_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> predictions= gLibrary.recognize(gesture);
        if (predictions.size() > 0 && predictions.get(0).score > 1){
            String action = predictions.get(0).name;
            
            Log.i(tag:"Gesture",action);


            if (action.equals("configurar")){

            }
        }
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
        return inflater.inflate(R.layout.fragment_configurar_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFragment = view;
        gestureSetup(viewFragment);
    }

    private void gestureSetup(View view) {
   gLibrary = GestureLibraries.fromRawResource(getActivity(),R.raw.gestures);
   if (!gLibrary.load()){
       // finish():
   }
   GestureOverlayView gOverlay = view.findViewById(R.id.gestures);
   gOverlay.addOnGesturePerformedListener(this);
    }
}
