package com.example.android.thetraveller;

//import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.thetraveller.MainActivity;
import com.example.android.thetraveller.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    int counter = 5;
    ImageView ivlogo;
    Button btnforgotpass;
    TextView tvheading;

    Button btnsignup;
    EditText etname;
    EditText etpass;
    Button btnlogin;

    Button btncancel;
    TextView tvname;
    TextView tvpass;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ivlogo = (ImageView) findViewById(R.id.ivlogo);
        tvname = (TextView) findViewById(R.id.tvname);
        tvpass = (TextView) findViewById(R.id.tvpass);

        btnforgotpass = (Button) findViewById(R.id.btnforgotpass);

        tvheading = (TextView) findViewById(R.id.tvheading);

        etname = (EditText) findViewById(R.id.etname);
        etpass = (EditText) findViewById(R.id.etpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsignup);

        btncancel = (Button) findViewById(R.id.btncancel);
        btncancel.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        btnsignup.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        //jis activity mei bhejna hai if already logged in
//        if(firebaseAuth.getCurrentUser() != null){
//            //close this activity
//            finish();
//            //opening profile activity
//            startActivity(new Intent(this, MainActivity.class));
//        }


        progressDialog = new ProgressDialog(this);
    }


    //method for user login
    private void userLogin(){
        String email = etname.getText().toString().trim();
        String password  = etpass.getText().toString().trim();


        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Logging in, Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){

                            finish();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }else
                            Toast.makeText(LoginActivity.this,"Invalid username/ Password",Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnlogin:
                userLogin();
                break;

            case R.id.btnsignup:
                finish();
                startActivity(new Intent(this, SignupActivity.class));
                break;

            case R.id.btncancel:
                finish();
                break;
        }
    }
}