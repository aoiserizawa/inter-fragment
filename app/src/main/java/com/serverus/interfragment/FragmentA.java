package com.serverus.interfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by alvinvaldez on 2/14/15.
 */
public class FragmentA extends Fragment {

    Button button;
    int counter = 0;
    // User the method respond of interface Communicator
    // from the MainActivity
    Communicator comunicate; // interface variable can refer to subclass object

    // we call this method so that when the fragment restart after destroying because
    // of orientation change
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if there is a saved intance state from onSaveInstanceState method
        if(savedInstanceState == null){
            counter = 0;
        }else{
            // if there is  savedInstanceState use it
            // this will get the counter from "counter" put from
            // the onSaveInstanceState method below
            counter = savedInstanceState.getInt("counter", 0);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // getActivity returns a reference to mainActivity
        // then type cast it to Communicator to call the respond method
        comunicate = (Communicator) getActivity();

        // get the button from the xml
        button = (Button) getActivity().findViewById(R.id.button);

        // setting a listener which is onClick listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                comunicate.respond("The button was clicked "+counter+" times");
            }
        });
    }

    // we use this method to save the instanceState of the "counter"
    // because when the orientation change it fragment will destroy and recreate again
    // by that we will loose the data

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save it to outState
        // putInt is key value pair
        // then call the "counter" in onCreate method on the top
        outState.putInt("counter", counter);
    }

    //    @Override
//    public void onClick(View v) {
//        counter++;
//        comunicate.respond("The button was clicked "+counter+" times");
//    }
}
