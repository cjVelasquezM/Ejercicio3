package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio3.Tablas.Transacciones;
import com.example.ejercicio3.configuracion.SQLiteConexion;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etEdad, etCorreo, etDireccion;
    Button btnGuardar;

    private void config(){
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etEdad = (EditText) findViewById(R.id.etEdad);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        }
        private void AgregarPersona(){
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
            SQLiteDatabase db = conexion.getReadableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.nombre, etNombre.getText().toString());
            valores.put(Transacciones.apellido, etApellido.getText().toString());
            valores.put(Transacciones.edad, etEdad.getText().toString());
            valores.put(Transacciones.correo, etCorreo.getText().toString());
            valores.put(Transacciones.direccion, etDireccion.getText().toString());

            Long resultado = db.insert(Transacciones.TbPersonas, Transacciones.nombre, valores);

            Toast.makeText(getApplicationContext(), "Registro ingresado con exito" + resultado.toString()
                    , Toast.LENGTH_SHORT).show();

            db.close();

            ClearScreen();
        }

    private void ClearScreen() {
        etNombre.setText("");
        etApellido.setText("");
        etEdad.setText("");
        etCorreo.setText("");
        etDireccion.setText("");
    }

}