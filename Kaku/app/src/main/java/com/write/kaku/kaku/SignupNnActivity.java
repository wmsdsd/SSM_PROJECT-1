package com.write.kaku.kaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupNnActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_nn);

        mAuth = FirebaseAuth.getInstance();

        Button NnConfirmButton = (Button)findViewById(R.id.NnConfirmButton);
        final EditText inputNn = (EditText)findViewById(R.id.inputNn);

        NnConfirmButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            String nickname = inputNn.getText().toString();

                //todo firebase에서 닉네임 중복 체크
                boolean nicknameCheck = true;

                //닉 네임 request를 생성
                UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder().setDisplayName(nickname).build();
                //request를 보냄 (송신)
                mAuth.getCurrentUser().updateProfile(profileUpdate);

                if(nicknameCheck){
                    Intent intent = new Intent(SignupNnActivity.this, MainActivity.class );
                    startActivity(intent);
                }else{
                    Toast.makeText(SignupNnActivity.this, "nickname already exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
