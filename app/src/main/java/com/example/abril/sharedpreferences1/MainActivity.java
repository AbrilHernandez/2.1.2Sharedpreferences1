package com.example.abril.sharedpreferences1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String NAME="NAME";
    private EditText mEditTextName;
    private EditText edt_cliente,edt_direccion,edt_celular, tme_inicio, tme_final;
    private EditText edt_platillo, edt_postre;
    private SeekBar barra;
    private CheckBox manteles;
    boolean res;
    int papaya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_celular=(EditText) findViewById(R.id.edt_cel);
        edt_cliente=(EditText)findViewById(R.id.edt_cliente);
        edt_direccion=(EditText) findViewById(R.id.edt_direccion);
        tme_inicio = (EditText)findViewById(R.id.tme_inicio);
        tme_final = (EditText)findViewById(R.id.tme_final);
        edt_platillo = (EditText)findViewById(R.id.edt_platillo);
        edt_postre = (EditText)findViewById(R.id.edt_postre);
        barra = (SeekBar)findViewById(R.id.sbr_barra);
        manteles = (CheckBox)findViewById(R.id.check_manteles);


        SharedPreferences prefs = (getPreferences(MODE_PRIVATE));

        Button btn_leer=(Button) findViewById(R.id.btn_leer);
        btn_leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();//getPreferences(MODE_PRIVATE).edit();
                 edt_cliente.setText(prefs.getString("Cliente", edt_cliente.getText().toString()));
                edt_celular.setText(prefs.getString("Celular", edt_celular.getText().toString()));
                edt_direccion.setText(prefs.getString("Direccion", edt_direccion.getText().toString()));
                tme_inicio.setText(prefs.getString("Hora Inicial", tme_inicio.getText().toString()));
                tme_final.setText(prefs.getString("Hora Final", tme_final.getText().toString()));
                edt_platillo.setText(prefs.getString("Platillos",  edt_platillo.getText().toString()));
                edt_postre.setText(prefs.getString("Postres: ",edt_postre.getText().toString()));
                manteles.setChecked(prefs.getBoolean("Mantelería", check()));
                barra.setProgress(prefs.getInt("Meseros", progreso()));

            }
        });
        final Button btn_save =(Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText(btn_save);
            }
        });

    }
    public void saveText(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        check();
        progreso();
        editor.putString("Cliente", edt_cliente.getText().toString());
        editor.putString("Celular", edt_celular.getText().toString());
        editor.putString("Direccion", edt_direccion.getText().toString());
        editor.putString("Hora Inicial", tme_inicio.getText().toString());
        editor.putString("Hora Final", tme_final.getText().toString());
        editor.putString("Platillos", edt_platillo.getText().toString());
        editor.putString("Postres: ",edt_postre.getText().toString());
        editor.putBoolean("Mantelería", check());
        editor.putInt("Meseros", progreso());

        //editor.putString(NAME, valor);
        editor.commit();
    }
    public boolean check(){
        if(manteles.isChecked()){
            res = true;
            return res;
        }else {

        }
        return false;
    }

    public int progreso(){
        papaya = barra.getProgress();
        return papaya;
    }

}
