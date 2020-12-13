package com.becomedigital.sdk.identity.becomedigitalsdkiv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.becomedigital.sdk.identity.becomedigitalsdk.callback.BecomeCallBackManager;
import com.becomedigital.sdk.identity.becomedigitalsdk.callback.BecomeInterfaseCallback;
import com.becomedigital.sdk.identity.becomedigitalsdk.callback.BecomeResponseManager;
import com.becomedigital.sdk.identity.becomedigitalsdk.callback.LoginError;
import com.becomedigital.sdk.identity.becomedigitalsdk.models.InfoTarjeta;

public class MainActivity extends AppCompatActivity {
    private final BecomeCallBackManager mCallbackManager = BecomeCallBackManager.createNew ( );

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView textResponse = findViewById (R.id.textReponse);
        Button btnAut = findViewById (R.id.btnAuth);
        btnAut.setOnClickListener (view -> {
            BecomeResponseManager.getInstance ( ).startAutentication (MainActivity.this);
            BecomeResponseManager.getInstance ( ).registerCallback (mCallbackManager, new BecomeInterfaseCallback ( ) {
                @Override
                public void onSuccess(final InfoTarjeta responseIV) {
                    textResponse.setText(responseIV.toString());
                    Log.d ("responseIV", responseIV.toString());
                }

                @Override
                public void onCancel() {
                    textResponse.setText ("Cancelado por el usuario ");

                }

                @Override
                public void onError(LoginError pLoginError) {
                    textResponse.setText (pLoginError.getMessage ( ));
                    Log.d ("Error", pLoginError.getMessage ( ));
                }

            });
        });

    }
}
