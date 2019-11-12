package com.example.hariswedira.vo2max;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvIndex, tvVot;
    private EditText edtUmur, edtJarak;
    private Button btnHitung, btnShare, btnRekomendasi;
    private RadioButton rbPria, rbWanita;
    private RadioGroup radioGroup;
    private String kategori,gender,teks="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvIndex = findViewById(R.id.tv_index);
        tvVot = findViewById(R.id.tv_vot);
        edtUmur = findViewById(R.id.edt_umur);
        edtJarak = findViewById(R.id.edt_jarak);
        btnHitung = findViewById(R.id.btn_hitung);
        btnShare = findViewById(R.id.btn_email);
        btnRekomendasi = findViewById(R.id.btn_rekomen);
        rbPria = findViewById(R.id.rb_pria);
        rbWanita = findViewById(R.id.rb_wanita);
        radioGroup = findViewById(R.id.radioGroup);

        btnHitung.setOnClickListener(this);
        btnRekomendasi.setOnClickListener(this);
        btnShare.setOnClickListener(this);

        tvIndex.setVisibility(View.GONE);
        tvVot.setVisibility(View.GONE);
        btnRekomendasi.setVisibility(View.GONE);
        btnShare.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_hitung:
                tvVot.setVisibility(View.VISIBLE);
                tvIndex.setVisibility(View.VISIBLE);
                btnShare.setVisibility(View.VISIBLE);
                btnRekomendasi.setVisibility(View.VISIBLE);
                if (edtJarak.getText().toString().matches("")||edtUmur.getText().toString().matches("")){
                    Toast.makeText(this, "Isian tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if (radioGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(this, "Isian radio tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    int umurI = Integer.parseInt(edtUmur.getText().toString());
                    float jarakD = Float.parseFloat(edtJarak.getText().toString());
                    float hasil = (float) ((0.172*((jarakD/15)-133))+33.3);

                    gender = rbPria.isChecked()?"Pria":"Wanita";

                    teks += "Umur\t: "+umurI+"\n";
                    teks += "Jarak Tempuh\t: "+jarakD+"\n";
                    teks += "Jenis Kelamin\t: "+gender+"\n";
                    teks += "Vo2 Max\t: "+hasil+"\n";

                    cek(umurI,hasil,gender);
                    colorText(kategori);
                    tvVot.setText(String.valueOf(hasil));
                    tvIndex.setText(kategori);
                }
                break;
            case R.id.btn_email:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Hasil Perhitungan Vo2 Max");
                intent.putExtra(Intent.EXTRA_TEXT,teks);
                teks="";
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"hariswediraa@gmail.com"});
                startActivity(intent);
                break;
            case R.id.btn_rekomen:
                String k = tvIndex.getText().toString();
                Intent intent1 = new Intent(MainActivity.this,ExcellentActivity.class);
                startActivity(intent1);
//                    startActivity(intent1);
//                if (k.equalsIgnoreCase("Poor")) {
//                    Intent i = new Intent(MainActivity.this, PoorActivity.class);
//                    startActivity(i);
//                } else if (k.equalsIgnoreCase("Good")) {
//                    Intent i = new Intent(MainActivity.this, GoodActivity.class);
//                    startActivity(i);
//                if (k.equalsIgnoreCase("Excellent")){
//                    Intent intent1 = new Intent(MainActivity.this,ExcellentActivity.class);
//                    startActivity(intent1);
//                }else {
//                    Toast.makeText(this, "Tidak ada pilihan", Toast.LENGTH_SHORT).show();
//                }
                break;
        }
    }

    public void colorText(String kategori){
        if (kategori.equalsIgnoreCase("Poor")){
            tvIndex.setTextColor(getResources().getColor(R.color.colorAccent));
        }else if (kategori.equalsIgnoreCase("Fair")){
            tvIndex.setTextColor(getResources().getColor(R.color.colorPrimary));
        }else if (kategori.equalsIgnoreCase("Good")){
            tvIndex.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }else if (kategori.equalsIgnoreCase("Excellent")){
            tvIndex.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    public String cek(int umur, float hasil,String gender){
        if (gender.equalsIgnoreCase("pria")){
            if (umur>=13&&umur<=19){
                if (hasil>=25&&hasil<=30||hasil<25){
                    kategori = "Poor";
                }else if (hasil>=31&&hasil<=34){
                    kategori = "Fair";
                }else if (hasil>=35&&hasil<=38){
                    kategori = "Good";
                }else if (hasil>=39&&hasil<=41||hasil>41){
                    kategori = "Excellent";
                }
            }else if (umur>=20&&umur<=29){

            }else if (umur>=30&&umur<=39){

            }else if (umur>=40&&umur<=49){

            }else if (umur>=50&&umur<=59){

            }else if (umur>=60){

            }
        }else if (rbWanita.isChecked()){

        }
        return kategori;
    }
}
