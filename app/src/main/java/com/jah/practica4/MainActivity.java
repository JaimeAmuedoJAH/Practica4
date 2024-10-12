package com.jah.practica4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnMostrar;
    Spinner spLista;
    CheckBox cbNegrita, cbCursiva;
    TextView txtResultado, lblNombre, lblEdad;
    EditText txtNombre, txtEdad;
    SwitchCompat swOscuro;
    View main;
    ArrayAdapter<CharSequence> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnMostrar = findViewById(R.id.btnMostrar);
        spLista = findViewById(R.id.spLista);
        cbNegrita = findViewById(R.id.cbNegrita);
        cbCursiva = findViewById(R.id.cbCursiva);
        txtResultado = findViewById(R.id.txtResultado);
        lblNombre = findViewById(R.id.lblNombre);
        lblEdad = findViewById(R.id.lblEdad);
        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        swOscuro = findViewById(R.id.swOscuro);
        main = findViewById(R.id.main);

        txtNombre.requestFocus();

        adaptador = ArrayAdapter.createFromResource(this, R.array.lista, android.R.layout.simple_spinner_dropdown_item);
        spLista.setAdapter(adaptador);

        btnMostrar.setOnClickListener(view -> mostrarContenido());

        swOscuro.setOnCheckedChangeListener((compoundButton, checkedId) -> modoOscuro(checkedId));

        cbNegrita.setOnCheckedChangeListener((compoundButton, checkedId) -> textoNegrita(checkedId));
        cbCursiva.setOnCheckedChangeListener((compoundButton, checkedId) -> textoCursiva(checkedId));


    }

    private void textoCursiva(boolean checkedId) {
        if(checkedId){
            if(cbNegrita.isChecked()){
                txtResultado.setTypeface(null, Typeface.BOLD_ITALIC);
            }else{
                txtResultado.setTypeface(null, Typeface.ITALIC);
            }
        }else{
            if(cbNegrita.isChecked()){
                txtResultado.setTypeface(null, Typeface.BOLD);
            }else{
                txtResultado.setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    private void textoNegrita(boolean checkedId) {
        if(checkedId){
            if(cbCursiva.isChecked()){
                txtResultado.setTypeface(null, Typeface.BOLD_ITALIC);
            }else{
                txtResultado.setTypeface(null, Typeface.BOLD);
            }
        }else{
            if(cbCursiva.isChecked()){
                txtResultado.setTypeface(null, Typeface.ITALIC);
            }else{
                txtResultado.setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    private void modoOscuro(boolean checkedId) {
        if(checkedId){
            main.setBackgroundColor(Color.BLACK);
            txtResultado.setTextColor(Color.WHITE);
            lblNombre.setTextColor(Color.WHITE);
            lblNombre.setHintTextColor(Color.WHITE);
            lblEdad.setTextColor(Color.WHITE);
            lblEdad.setHintTextColor(Color.WHITE);
            txtNombre.setTextColor(Color.WHITE);
            txtEdad.setTextColor(Color.WHITE);
            cbNegrita.setTextColor(Color.WHITE);
            cbCursiva.setTextColor(Color.WHITE);
            swOscuro.setTextColor(Color.WHITE);
        }else{
            main.setBackgroundColor(Color.WHITE);
            txtResultado.setTextColor(Color.BLACK);
            lblNombre.setTextColor(Color.BLACK);
            lblNombre.setHintTextColor(Color.BLACK);
            lblEdad.setTextColor(Color.BLACK);
            lblEdad.setHintTextColor(Color.BLACK);
            txtNombre.setTextColor(Color.BLACK);
            txtEdad.setTextColor(Color.BLACK);
            cbNegrita.setTextColor(Color.BLACK);
            cbCursiva.setTextColor(Color.BLACK);
            swOscuro.setTextColor(Color.BLACK);
        }
    }

    private void mostrarContenido() {
        String str = spLista.getSelectedItem() + "";
        txtResultado.setText(str);
    }
}