/**
 *Aluno: Alex Lopes Pereira
 *RA: 818143852
 *
 */

package br.usjt.ads20.appuniversidadesd1.Model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.usjt.ads20.appuniversidadesd1.R;
import br.usjt.ads20.appuniversidadesd1.View.MainActivity;


public class ListarUniversidadesActivity extends AppCompatActivity {
    public static final String UNIVERSIDADE = "br.usjt.ads20.appfilmes.universidadesListadas";
    Universidade[] lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_herois);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);

        ArrayList<Universidade> universidades = (ArrayList<Universidade>) intent.getSerializableExtra(MainActivity.UNIVERSIDADES);
        Log.e("array de universidades", universidades.toString());
        Dados.setUniversidades(universidades);
        lista = Dados.buscarUniversidades(chave);
        BaseAdapter adapter = new UniversidadeAdaptador(this, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse(lista[i].getWebPages());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}