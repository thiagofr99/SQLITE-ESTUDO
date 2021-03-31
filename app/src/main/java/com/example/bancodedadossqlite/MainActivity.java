package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR(40), idade INT(3))");

            //DELETAR TABELA
            //bancoDados.execSQL("DROP TABLE pessoas");


            //UPDATE
            //bancoDados.execSQL("UPDATE pessoas SET idade =20 WHERE nome='Mariana'");


            //DELETE
            bancoDados.execSQL("DELETE FROM pessoas WHERE id=2");



            //Inserir dados
            /*bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Mariana',18)");
            bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Pedro', 50)");*/

            //Recuperar pessas
            /*String consulta = "SELECT nome,idade FROM pessoas WHERE nome='Maria' AND idade=35";*/


            //Busca entre o valor
            /*String consulta = "SELECT * FROM pessoas WHERE nome IN('Maria','Jamilton') ";

            String consulta = "SELECT * FROM pessoas WHERE idade BETWEEN 35 AND 50 ";*/


            //Consulta por parte da palavra ou codigo executando a partir da direita do %
            /*String consulta = "SELECT * FROM pessoas WHERE nome LIKE 'mar%'";*/

            /*String consulta = "SELECT * FROM pessoas WHERE nome LIKE '%a%'";*/

            //Ordenar idade do menor para o maior
            /*String consulta = "SELECT * FROM pessoas WHERE idade ORDER BY idade ASC";*/

            //Ordenar idade do MAIOR para o MENOR
            /*String consulta = "SELECT * FROM pessoas WHERE idade ORDER BY idade DESC";*/


            //Aduiciona uma limitação no resultado da busca no caso os 3 primeiros ( Neste caso )
            //String consulta = "SELECT * FROM pessoas WHERE idade ORDER BY idade DESC LIMIT 3";



            String consulta = "SELECT * FROM pessoas";










          Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceId = cursor.getColumnIndex("id");

            cursor.moveToFirst();
            while (cursor != null) {
                String nome = cursor.getString(indiceNome);
                String idade = String.valueOf(cursor.getInt(indiceIdade));
                String id = String.valueOf(cursor.getInt(indiceId));

                Log.i("RESULTADO - Id- "+id+"/ nome ", nome + " / idade: " + idade);

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}