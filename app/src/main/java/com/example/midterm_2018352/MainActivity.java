package com.example.midterm_2018352;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.FirebaseApp;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FirebaseApp.initializeApp(Context);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.login_btn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createSignInIntent();
            }
        });

    }

    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        Intent intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTosAndPrivacyPolicyUrls("https://google.com","https://google.com")
                .setIsSmartLockEnabled(false)
                .build();

        startActivityForResult(
                intent,
                RC_SIGN_IN);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
               /* FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                TextView name = findViewById(R.id.name);
                ImageView display_picture = findViewById(R.id.dp);
                TextView email = findViewById(R.id.email);
                assert user != null;
                name.setText(user.getDisplayName());
                Picasso.get().load(user.getPhotoUrl()).into(display_picture);
                email.setText(user.getEmail());*/
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                this.finish();


            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}