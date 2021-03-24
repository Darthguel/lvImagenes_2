package com.example.lvimagenes_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listapersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapersonas=new ArrayList<Persona>();
        listapersonas.add(new Persona("Caro", 'f'));
        listapersonas.add(new Persona("Rodolfo",'m'));
        listapersonas.add(new Persona("Isaac",'m'));
        listapersonas.add(new Persona("Leo",'m'));
        listapersonas.add(new Persona("Miguel",'m'));

        AdaptadorPersonas adp = new AdaptadorPersonas(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adp);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,listapersonas.get(i).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class AdaptadorPersonas extends ArrayAdapter<Persona> {

        AppCompatActivity appCompatActivity;

        AdaptadorPersonas(AppCompatActivity context) {
            super(context, R.layout.persona, listapersonas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listapersonas.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imageView);

            if (listapersonas.get(position).getGenero()=='m')
                imageView1.setImageResource(R.drawable.hombre);
            else
                imageView1.setImageResource(R.drawable.mujer);
            return(item);
        }
    }
}