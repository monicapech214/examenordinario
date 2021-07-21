package com.example.ordinariopuntodeventa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class ventanainventario extends AppCompatActivity {
    Button insertar,eliminar, actualizar;
    EditText nombreproducto, precio, cantidad,fecha,imagenprod;
private AdminSQLITEHelper admin;
private SQLiteDatabase bd;
private ContentValues registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventanainventario);
        admin = new AdminSQLITEHelper(this,vars.bd,null,vars.version);
        insertar = (Button)findViewById(R.id.insertar);
        eliminar = (Button)findViewById(R.id.eliminar);
        actualizar = (Button)findViewById(R.id.actualizar);
        nombreproducto = (EditText) findViewById(R.id.nombreproducto);
        precio = (EditText) findViewById(R.id.precio);
        cantidad = (EditText) findViewById(R.id.cantidad);
        imagenprod = (EditText) findViewById(R.id.imgprod);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLITEHelper admin = new AdminSQLITEHelper(ventanainventario.this, vars.bd, null, vars.version);
               bd= admin.getReadableDatabase();
               registro=new ContentValues();
                if (nombreproducto != null) {
                    registro.put("nombreproducto", nombreproducto.getText().toString());
                    registro.put("precio", precio.getText().toString());
                    registro.put("cantidad", cantidad.getText().toString());
                    registro.put("imgprod", imagenprod.getText().toString());
                    bd.insert("productos",null,registro);
                    bd.close();
                    Toast.makeText(ventanainventario.this,"REGISTRO EXITOSO",Toast.LENGTH_LONG).show();
                     nombreproducto.setText("");
                    precio.setText("");
                    cantidad.setText("");
                    imagenprod.setText("");
                }
                else {

                    Toast.makeText(ventanainventario.this,"REGISTRO NO AGREGADO",Toast.LENGTH_LONG).show();
                }
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLITEHelper admin = new AdminSQLITEHelper(ventanainventario.this, vars.bd, null, vars.version);
                bd= admin.getReadableDatabase();
                registro=new ContentValues();

                bd.delete("productos","nombreproducto='"+nombreproducto+"'",null);
                bd.delete("productos","precio='"+precio+"'",null);
                bd.delete("productos","cantidad='"+cantidad+"'",null);
                bd.delete("productos","imgprod='"+imagenprod+"'",null);
                bd.close();
                Toast.makeText(getApplicationContext(),"Registro eliminado con exito",Toast.LENGTH_SHORT).show();
                nombreproducto.setText("");
                precio.setText("");
                cantidad.setText("");
                imagenprod.setText("");
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLITEHelper admin = new AdminSQLITEHelper(ventanainventario.this, vars.bd, null, vars.version);
                bd= admin.getReadableDatabase();
                AlertDialog.Builder alert = new AlertDialog.Builder(ventanainventario.this);
                final View customlayout = getLayoutInflater().inflate(R.layout.dialog_layout,null);
                alert.setView(customlayout);
                alert.setCancelable(false);
                EditText idp= customlayout.findViewById(R.id.idprod);
                EditText precionuev = customlayout.findViewById(R.id.precionew);
                EditText cantinuev = customlayout.findViewById(R.id.cantidadnew);
                alert.setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String idpr = idp.getText().toString();
                        String precion = precionuev.getText().toString();
                        String cantin = cantinuev.getText().toString();
                        registro=new ContentValues();
                        registro.put("precio", precion);
                        registro.put("cantidad", cantin);
                        bd.update("productos",registro,"idprod="+idp,null);
                        bd.close();
                        Toast.makeText(ventanainventario.this,"ACTUALIZADO CON EXITO",Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();

            }
        });
    }
    private void mostrarDialogo()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(ventanainventario.this);
        final View customlayout = getLayoutInflater().inflate(R.layout.dialog_layout,null);
        alert.setView(customlayout);
        alert.setCancelable(false);
        EditText idp= customlayout.findViewById(R.id.idprod);
        EditText precionuev = customlayout.findViewById(R.id.precionew);
        EditText cantinuev = customlayout.findViewById(R.id.cantidadnew);
        alert.setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String idpr = idp.getText().toString();
                String precion = precionuev.getText().toString();
                String cantin = cantinuev.getText().toString();

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}