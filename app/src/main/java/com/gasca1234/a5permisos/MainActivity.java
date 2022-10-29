package com.gasca1234.a5permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gasca1234.a5permisos.Adaptrpermiso.Adaptadorpermiso;
import com.gasca1234.a5permisos.Modelo.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Permiso> permisos = new ArrayList<Permiso>();
        permisos.add(new Permiso("llamada"));
        permisos.add(new Permiso("mensaje"));
        permisos.add(new Permiso("camara"));
        permisos.add(new Permiso("video"));
        permisos.add(new Permiso("bluetooth"));

        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Adaptadorpermiso adapter = new Adaptadorpermiso(permisos);
        recyclerView.setAdapter(adapter);
    }
}