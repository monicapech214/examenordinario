package com.example.ordinariopuntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ir_venta,ir_inventario, ir_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ir_venta = (Button)findViewById(R.id.venta);
        ir_inventario = (Button)findViewById(R.id.inventario);
        ir_salir = (Button)findViewById(R.id.salir);
        ir_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ventanainventario.class);
                startActivity(i);
            }
        });
        ir_venta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ventanaventa.class);
                startActivity(i);
            }
        });
        ir_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}