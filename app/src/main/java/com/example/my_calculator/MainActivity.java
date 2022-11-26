package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.sonuc_text);
        editText.setShowSoftInputOnFocus(false);
    }

    public void Yazdir (View view) {

        switch (view.getId()) {
            case R.id.button_temizle: editText.setText("");
            break;
            case R.id.button_dot: EkranaYazdir(".");
                break;
            case R.id.button_0: EkranaYazdir("0");
                break;
            case R.id.button_multiply: EkranaYazdir("*");
                break;
            case R.id.button_1: EkranaYazdir("1");
                break;
            case R.id.button_2: EkranaYazdir("2");
                break;
            case R.id.button_3: EkranaYazdir("3");
                break;
            case R.id.button_4: EkranaYazdir("4");
                break;
            case R.id.button_5: EkranaYazdir("5");
                break;
            case R.id.button_6: EkranaYazdir("6");
                break;
            case R.id.button_7: EkranaYazdir("7");
                break;
            case R.id.button_8: EkranaYazdir("8");
                break;
            case R.id.button_9: EkranaYazdir("9");
                break;
            case R.id.button_divide: EkranaYazdir("/");
                break;
            case R.id.button_plus: EkranaYazdir("+");
                break;
            case R.id.button_minus: EkranaYazdir("-");
                break;
            case R.id.button_sil:  Sil();
                break;
            case R.id.button_equal: Sonuc();
                break;

        }
}

     private void Sil() {
        int cursorPos=editText.getSelectionStart();
        if(cursorPos>0) {
            String eskiDeger = editText.getText().toString();
            String solTaraf = eskiDeger.substring(0, cursorPos-1);
            String sagTaraf = eskiDeger.substring(cursorPos);
            String yeniDeger = solTaraf+sagTaraf;
            editText.setText(yeniDeger);
            editText.setSelection(cursorPos-1);
        }
     }

     private void Sonuc() {
        String yazi = editText.getText().toString();
        Expression ifade = new Expression(yazi);
        String result = String.valueOf(ifade.calculate()).toString();

        editText.setText(result);
        editText.setSelection(result.length());

     }

    private void EkranaYazdir(String deger) {

        int cursorPos=editText.getSelectionStart(); //imlecin nerede oldugunu aldık böylece basıldıgı yerden istedigimizi yazmaya başlayacak.
        String eskiDeger = editText.getText().toString();
        String solTaraf =  eskiDeger.substring(0,cursorPos);
        String sagTaraf = eskiDeger.substring(cursorPos);
        String yeniDeger = solTaraf+deger+sagTaraf;
        editText.setText(yeniDeger);
        editText.setSelection(cursorPos+1); //imleci 1 ilerletmek için.
    }
}