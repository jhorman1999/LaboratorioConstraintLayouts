package com.example.laboratorioconstraintlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void enviarMensaje(View v){
        //pedir datos
        //correo
        EditText correo=(EditText)findViewById(R.id.editTextCorreo);
        String messageCorreo= correo.getText().toString();
        //asunto
        EditText asunto=(EditText)findViewById(R.id.editTextAsunto);
        String messageAsunto= asunto.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");

        intent.putExtra(Intent.EXTRA_EMAIL,messageCorreo);
        intent.putExtra(Intent.EXTRA_SUBJECT,asunto.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,leerDatosFormulario().toString());

        startActivity(intent);


    }


    public String leerDatosFormulario(){
        String mensaje="";
        Switch respirar = (Switch) findViewById(R.id.switchRespirar);
        respirar.isChecked();
        if(respirar.isChecked()){
            mensaje=respirar.getText().toString()+"\n";

        }
        Switch fiebre = (Switch) findViewById(R.id.switchFiebre);
        fiebre.isChecked();
        if(fiebre.isChecked()){
            mensaje=mensaje+fiebre.getText().toString()+"\n";

        }
        Switch gusto = (Switch) findViewById(R.id.switchGustoYOlfato);
        gusto.isChecked();
        if(gusto.isChecked()){
            mensaje=mensaje+gusto.getText().toString()+"\n";

        }
        Switch dolor = (Switch) findViewById(R.id.switchDolorDeCabeza);
        dolor.isChecked();
        if(dolor.isChecked()){
            mensaje=mensaje+dolor.getText().toString()+"\n";

        }
        Switch tos = (Switch) findViewById(R.id.switchTosSeca);
        tos.isChecked();
        if(tos.isChecked()){
            mensaje=mensaje+tos.getText().toString()+"\n";

        }
        return mensaje;
    }

}