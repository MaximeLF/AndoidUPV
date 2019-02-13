package com.example.practica2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import listViewControlleur.CustomAdapteur;

public class FavouriteActivity extends AppCompatActivity {
    private String authorName = "Albert Einstein";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ArrayList<Quotation> quotes = getMockQuotations();
        CustomAdapteur ca = new CustomAdapteur(getApplicationContext(),R.layout.quotation_list_row,quotes);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(ca);
        lv.setOnItemClickListener((adapterView, view, i, l) ->{
            TextView tv = view.findViewById(R.id.quote_author);
            String author_name = tv.getText().toString();
            if(author_name == null || author_name.equals("")){
                Toast.makeText(getApplicationContext(),"impossible for this quote",Toast.LENGTH_LONG).show();
            }else {
                try {
                    authorName = URLEncoder.encode(author_name,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                authorInfo(view);
            }

        });
        lv.setOnItemLongClickListener((adapteurView, view, i, l)->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.deleteQuote);
            builder.setPositiveButton(R.string.yes, (dialogInterface, id) -> {
                quotes.remove(i);
                ca.notifyDataSetChanged();
            });
            builder.setNegativeButton(R.string.no,(dialogInterface, id) -> Log.e("reponse","no"));
            builder.create().show();
            //Toast.makeText(getApplicationContext(),"essai",Toast.LENGTH_LONG).show();
            return true;
        });
    }

    public void authorInfo(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search="+authorName));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(intent,"View UPV’s web page"));
        }else {
            Toast.makeText(getApplicationContext(),"No internet navigator",Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<Quotation> getMockQuotations(){
        ArrayList<Quotation> res = new ArrayList<>();
        res.add(new Quotation().setQuoteAuthor("Confucius").setQuoteText("Exige beaucoup de toi-même et attends peu des autres. Ainsi beaucoup d'ennuis te seront épargnés."));
        res.add(new Quotation().setQuoteText("Dans la vie on ne fait pas ce que l'on veut mais on est responsable de ce que l'on est.").setQuoteAuthor("Jean-Paul Sartre"));
        res.add(new Quotation().setQuoteAuthor("Gandhi").setQuoteText("La vie est un mystère qu'il faut vivre, et non un problème à résoudre."));
        res.add(new Quotation().setQuoteText("On passe une moitié de sa vie à attendre ceux qu'on aimera et l'autre moitié à quitter ceux qu'on aime.").setQuoteAuthor("Victor Hugo"));
        res.add(new Quotation().setQuoteAuthor("Coluche").setQuoteText("Pour critiquer les gens il faut les connaître, et pour les connaître, il faut les aimer."));
        res.add(new Quotation().setQuoteText("La vie, c'est comme une bicyclette, il faut avancer pour ne pas perdre l'équilibre.").setQuoteAuthor("Albert Einstein"));
        res.add(new Quotation().setQuoteAuthor("Confucius").setQuoteText("Choisissez un travail que vous aimez et vous n'aurez pas à travailler un seul jour de votre vie."));
        res.add(new Quotation().setQuoteText("Celui qui cherche une femme belle, bonne et intelligente, n'en cherche pas une mais trois.").setQuoteAuthor("Oscar Wilde"));
        res.add(new Quotation().setQuoteAuthor("Nelson Mandela").setQuoteText("Etre libre, ce n'est pas seulement se débarrasser de ses chaînes ; c'est vivre d'une façon qui respecte et renforce la liberté des autres."));
        res.add(new Quotation().setQuoteText("L'ennui dans ce monde, c'est que les idiots sont sûrs d'eux et les gens sensés pleins de doutes.").setQuoteAuthor("Bertrand Russell"));
        res.add(new Quotation().setQuoteText("Plus tu pédales moins vite moins t'avances plus vite"));
        return res;

    }

}
