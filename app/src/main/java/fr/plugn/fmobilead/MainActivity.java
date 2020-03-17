package fr.plugn.fmobilead;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        image = (ImageView) findViewById(R.id.imageView);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "Activation...", "Application de la configuration automatique : interdiction de l'itinérance via la réécriture des données de la carte SIM : {\"PERMANENT_NETWORK_BAN\": ADD_NETWORK{208, 01, \"Orange F\", \"FR\"}} ... Veuillez patienter, et n'éteignez pas votre appareil...",
                        true);
                dialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                        image.setImageResource(R.drawable.transparent);
                    }
                }, 17000); // 3000 milliseconds delay
            }

        });

    }

}
