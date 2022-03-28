package com.example.myapplication;

/*

Author: ING. CARLOS OTERO RAMÍREZ

 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int contador=1;
    String guardar="";
    boolean hayNumeroNegativo=false;

    private EditText editText1;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Existencia de Número Negativo");

        editText1 = findViewById(R.id.AM1_id2);
        button1 = findViewById(R.id.AM1_id3);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.AM1_id4);
        button2.setOnClickListener(this);
    }

    public void dialogoAlerta(String titulo, String mensaje){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AM1_id3:
                if(editText1.getText().toString().isEmpty()){
                    dialogoAlerta("Mensaje de Error", "El Campo de Texto esta Vacio");
                } else {
                    guardar+=Double.parseDouble(editText1.getText().toString())+ " ";
                    if(contador == 5){
                        editText1.setText("");
                        editText1.setEnabled(false);
                        button1.setEnabled(false);
                        if(hayNumeroNegativo == false){
                            dialogoAlerta("Mensaje de Información", "Has terminado de Introducir los cinco Digitos" +
                                    "\n" + "No Introduciste Números Negativos" +
                                    "\n" + "Los Números Ingresados Fueron: " + guardar);
                        } else {
                            dialogoAlerta("Mensaje de Información", "Has terminado de Introducir los cinco Digitos" +
                                    "\n" + "Sí Introduciste Números Negativos" +
                                    "\n" + "Los Números Ingresados Fueron: " + guardar);
                        }
                    } else {
                        if(Double.parseDouble(editText1.getText().toString()) > 0){
                            hayNumeroNegativo = true;
                        }
                        contador++;
                        editText1.setText("");
                        dialogoAlerta("Mensaje de Información", "Introduce otro Número");
                    }
                }
                break;
            case R.id.AM1_id4:
                System.exit(0);
                break;
        }
    }
}