package com.example.remileblanc.qrc_cs450_finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.CheckBox;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class RegisterFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private FirebaseAuth mAuth;

    private Button registerButton;

    private EditText newFirstName;
    private EditText newLastName;
    private EditText newEmail;
    private EditText newPassword;

    private String email;
    private String password;
    private String firstName;
    private String lastName;



    public RegisterFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_register, container, false);



        registerButton = rootView.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFirstName = rootView.findViewById(R.id.newFirstName);
                firstName = newFirstName.getText().toString();

                newLastName = rootView.findViewById(R.id.newLastName);
                lastName = newLastName.getText().toString();

                newEmail = rootView.findViewById(R.id.newEmail);
                email = newEmail.getText().toString();
                System.out.println(email);

                newPassword = rootView.findViewById(R.id.newPassword);
                password = newPassword.getText().toString();
                System.out.println(password);

                createAccount(email,password);

            }
        });

        return rootView;

    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

<<<<<<< HEAD
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_student:
                if (checked){

                }
                    // Put some meat on the sandwich
                else{

                }
                    // Remove the meat
                break;
            case R.id.checkbox_mentor:
                if (checked){

                }
                    // Cheese me
                else{

                }
                    // I'm lactose intolerant
                break;
            case R.id.checkbox_professor:
                if (checked){

                }
                    //prof
                else{

                }
                break;

        }
    }
=======
>>>>>>> 055207b360c3990a403a0c4aea43735eb6f494d3

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

    public void createAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(getContext(), "Authentication failed.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void updateUI(FirebaseUser user) {
        Toast.makeText(getContext(), "Hello "+user.getEmail(), Toast.LENGTH_LONG).show();


    }
}
