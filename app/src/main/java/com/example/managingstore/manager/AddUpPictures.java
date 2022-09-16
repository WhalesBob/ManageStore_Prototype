package com.example.managingstore.manager;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.managingstore.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddUpPictures#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUpPictures extends Fragment {

    // TODO : DB 처리해서 내용 바꾸는 자리.

    static final String message = "이 자리에 원래는 DB가 들어가서 처리가 됩니다.";
    // 만약에, 사진으로 처리할 것이라면, 여기를 바꾸는게 맞다.

    static final int REQUEST_IMAGE_CAPTURE = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddUpPictures() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ManagerFirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddUpPictures newInstance(String param1, String param2) {
        AddUpPictures fragment = new AddUpPictures();
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
        View view = inflater.inflate(R.layout.fragment_manager_first, container, false);

        Button captureButton = (Button) view.findViewById(R.id.captureButton);

        captureButton.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
            alert.setTitle("안내문")
                    .setPositiveButton("확인", (dialog, which) -> {
                        PackageManager pm = getContext().getPackageManager();
                        if(pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
                            dispatchTakePictureIntent();
                        }
                    })
                    .setMessage(message)
                    .show();
        });

        return view;
    }

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}