package com.example.ordinariopuntodeventa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ventanaventa extends AppCompatActivity {
ListView lista;
String[]arreglo;
    private AdminSQLITEHelper admin;
    private SQLiteDatabase bd;
    private ContentValues registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventanaventa);
        lista = (ListView) findViewById(R.id.lista);
        // lista.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //  public void onClick(View v) {
        if (bd != null) {
            AdminSQLITEHelper admin = new AdminSQLITEHelper(ventanaventa.this, vars.bd, null, vars.version);
            bd = admin.getReadableDatabase();
            Cursor fila = bd.rawQuery("SELECT * FROM PRODUCTOS", null);
            int cantidad = fila.getCount();
            int i = 0;
            arreglo = new String[cantidad];
            if (fila.moveToFirst()) {
                do {
                    String linea = fila.getInt(0) + "productos" + fila.getString(0);
                    arreglo[i] = linea;
                    i++;
                }
                while (fila.moveToNext());
            }


            }

      //  });
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ventanaventa.this);
                final View customlayout = getLayoutInflater().inflate(R.layout.dialog_layout,null);
                alert.setView(customlayout);
                alert.setCancelable(false);

                EditText cantii = customlayout.findViewById(R.id.cnt);
                alert.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String cantiv = cantii.getText().toString();

                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }
}