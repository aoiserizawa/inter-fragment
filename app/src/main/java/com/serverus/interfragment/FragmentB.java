package com.serverus.interfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alvinvaldez on 2/14/15.
 */
public class FragmentB extends Fragment {
    TextView text;
    String data;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_b, container, false);
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        if(savedInstanceState != null){

            data = savedInstanceState.getString("text");

            TextView myText = (TextView) view.findViewById(R.id.textView);

            myText.setText(data);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        text = (TextView) getActivity().findViewById(R.id.textView);
    }

    public void changeText(String data){
        this.data = data;
        text.setText(data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);

    }
}
