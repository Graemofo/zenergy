package com.gdoherty.zenergy;

import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class SoundFragment extends Fragment {

//    private StorageReference storageReference;
//    FirebaseStorage storage = FirebaseStorage.getInstance();
//    StorageReference storageRef = storage.getReference();

    private static MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sounds, container, false);

        ImageButton piano = v.findViewById(R.id.pianoBtn);
        piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Piano Sounds", Toast.LENGTH_LONG).show();
                play("https://firebasestorage.googleapis.com/v0/b/zenapp-8b655.appspot.com/o/forest_river_mp3.mp3?alt=media&token=aeb06dcc-fa5e-453f-a8ad-7d0452778c94");
            }
        });

        ImageButton beach = v.findViewById(R.id.beachBtn);
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Beach Sounds", Toast.LENGTH_LONG).show();

                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/zenapp-8b655.appspot.com/o/beach_sounds_mp3.mp3?alt=media&token=4304f06e-23f3-4cc6-ae42-6c10a9ca08bc");
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });
        ImageButton forest = v.findViewById(R.id.forestBtn);
        forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Forest Sounds", Toast.LENGTH_LONG).show();
                playSounds("https://firebasestorage.googleapis.com/v0/b/zenapp-8b655.appspot.com/o/forest_river_mp3.mp3?alt=media&token=aeb06dcc-fa5e-453f-a8ad-7d0452778c94");
            }
        });
        return v;
    }

    public static void playSounds(String url) {

        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();

        } else {
            mediaPlayer.start();
        }
    }

    public static void play(String url) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mediaPlayer.start();
        }
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
        }
    }

    public static void stopSounds() {
        mediaPlayer.stop();
    }


}