package com.example.habitation;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lier les éléments du layout aux variables Java
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);

        // Bouton "Calculer" déclenche la méthode calculer()
        findViewById(R.id.button_calcul).setOnClickListener(v -> calculer());
    }

    private void calculer() {
        String surfaceText = surfaceInput.getText().toString();
        String piecesText = piecesInput.getText().toString();

        if (surfaceText.isEmpty() || piecesText.isEmpty()) {
            resultView.setText(getString(R.string.error_empty_fields));
            return;
        }

        double surface = Double.parseDouble(surfaceText);
        int pieces = Integer.parseInt(piecesText);
        boolean piscine = piscineCheckbox.isChecked();

        double impotBase = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        // Affichage du résultat en utilisant strings.xml
        resultView.setText(getString(R.string.result_text, total));
    }
}