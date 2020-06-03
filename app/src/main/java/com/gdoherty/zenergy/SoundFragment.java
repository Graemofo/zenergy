package com.gdoherty.zenergy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.storage.StorageReference;

public class SoundFragment extends Fragment {

    private StorageReference storageReference;
    private static MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sounds, container, false);

        ImageButton beach = v.findViewById(R.id.beachBtn);
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Beach Sounds", Toast.LENGTH_LONG).show();
            }
        });
        ImageButton forest = v.findViewById(R.id.forestBtn);
        forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Forest Sounds", Toast.LENGTH_LONG).show();
                
            }
        });
        return v;
    }


}
