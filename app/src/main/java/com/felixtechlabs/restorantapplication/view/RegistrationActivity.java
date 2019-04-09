package com.felixtechlabs.restorantapplication.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private EditText UserEmail,UserPassword;
    private Button ButtonSignUp;
    private ProgressDialog progressDialog;
    private ProgressBar progressBar;
    private TextView txtDetails;

    private FirebaseAuth mAuth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();


        //txtDetails = (TextView) findViewById(R.id.txt_user);
        progressDialog = new ProgressDialog(this);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        UserEmail = (EditText)findViewById(R.id.editTextEmail);
        UserPassword = (EditText)findViewById(R.id.editTextPassword);
        //UserConfirmPassword = (EditText)findViewById(R.id.confirmpass);
        ButtonSignUp = (Button)findViewById(R.id.buttonSignup);
        //mFirebaseInstance = FirebaseDatabase.getInstance();
//
//
        mFirebaseInstance = FirebaseDatabase.getInstance();
//// get reference to 'users' node
//      mFirebaseDatabase = mFirebaseInstance.getReference("users");
////
////        // store app title to 'app_title' node
//       mFirebaseInstance.getReference("app_title").setValue("Realtime Database");
////
//        // app_title change listener
//        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.e(TAG, "App title updated");
//
//                String appTitle = dataSnapshot.getValue(String.class);
//
//                // update toolbar title
//                getSupportActionBar().setTitle(appTitle);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.e(TAG, "Failed to read app title value.", error.toException());
//            }
//        });



        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = UserEmail.getText().toString();
                String password = UserPassword.getText().toString();

//                // Check for already existed userId
//                if (TextUtils.isEmpty(userId)) {
//                    createUser(email, password);
//                } else {
//                    updateUser(email, password);
//                }

                SignUpNewAccount();
//

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()  !=null){

        }
    }

    private void SignUpNewAccount() {
        final String email = UserEmail.getText().toString();
        String password = UserPassword.getText().toString();
//        String confirmpass = UserConfirmPassword.getText().toString();
        // Check for already existed userId
//        if (TextUtils.isEmpty(userId)) {
//            userId = mFirebaseDatabase.push().getKey();
//            User user = new User(email, password);
//
//            mFirebaseDatabase.child(userId).setValue(user);
//            createUser(email, password);
//        } else {
//            updateUser(email, password);
//        }

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"please write your email",Toast.LENGTH_SHORT).show();

        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"please write your password",Toast.LENGTH_SHORT).show();
        }

//        else if (TextUtils.isEmpty(confirmpass))
//        {
//            Toast.makeText(this,"please write your confirmpassword",Toast.LENGTH_SHORT).show();
//        }
//        else if (password.equals(confirmpass))
//        {
//            Toast.makeText(this," your password do not match your confirmpassword",Toast.LENGTH_SHORT).show();
//        }
        else
        {
            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();
            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(UserEmail.getText().toString(),UserPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //checking if success
                            if(task.isSuccessful()){

                                String imageUrl = null;
                                User user = new User(
                                        email



                                );
                                FirebaseDatabase.getInstance().getReference("User")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressBar.setVisibility(View.GONE);
                                        if (task.isSuccessful()){
                                            Toast.makeText(RegistrationActivity.this,getString(R.string.registration_success),Toast.LENGTH_LONG).show();
                                        }else {
                                            //display a failure message
                                        }
                                    }
                                });

                                //task.getResult().getUser().getUid();
                                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                                startActivity(intent);
                                //display some message here
                                Toast.makeText(RegistrationActivity.this,"Successfully registered",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegistrationActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                //display some message here
                                Toast.makeText(RegistrationActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }

                    });
        }
    }
}

