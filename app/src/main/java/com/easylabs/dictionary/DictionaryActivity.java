package com.easylabs.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity implements View.OnClickListener {
    Button btRus;
    Button btEng;
    TextView tvDictionary;

    int currentLanguage = 0;
    final int RUS = 0;
    final int ENG = 1;

    String[] rusWords = new String[0];
    String[] engWords = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        setTitle("Тема " + Data.tasksTitles[Data.num]);

        System.out.println();

        btRus = (Button) findViewById(R.id.btRus);
        btEng = (Button) findViewById(R.id.btEng);
        tvDictionary = (TextView) findViewById(R.id.tvDictionary);

        btRus.setOnClickListener(this);
        btEng.setOnClickListener(this);

        switch (Data.num) {
            case 0:
                rusWords = Data.animalsRusList;
                engWords = Data.animalsEnglishList;
                break;
            case 1:
                rusWords = Data.technicsRusList;
                engWords = Data.technicsEngList;
                break;
            case 2:
                rusWords = Data.clothesRusList;
                engWords = Data.clothesEnglishList;
                break;
            case 3:
                rusWords = Data.foodRusList;
                engWords = Data.foodEnglishList;
                break;
        }

        setWords();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.btRus:
                currentLanguage = RUS;
                break;
            case R.id.btEng:
                currentLanguage = ENG;
                break;
        }

        setWords();
    }

    private void setWords() {
        String str = "";
        if (currentLanguage == RUS) {
            for (int i = 0; i < rusWords.length; i++) {
                str += rusWords[i] + "\n\n";
            }
        } else {
            for (int i = 0; i < engWords.length; i++) {
                str += engWords[i] + "\n\n";
            }
        }

        tvDictionary.setText(str);
    }
}
