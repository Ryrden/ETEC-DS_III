package com.example.appcofre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtDataProg;
    TextView txtConfirmProg;
    TextView txtServicoProg;
    EditText edtNomeProg;
    EditText edtUsuarioProg;
    EditText edtSenhaProg;

    credencialModel credencial = new credencialModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDataProg = findViewById(R.id.txtData);
        txtConfirmProg = findViewById(R.id.txtConfirm);
        txtServicoProg = findViewById(R.id.txtServico);
        edtNomeProg = findViewById(R.id.edtServico);
        edtUsuarioProg = findViewById(R.id.edtUsuario);
        edtSenhaProg = findViewById(R.id.edtSenha);
    }

    public void clickBtnDeletar(View v)
    {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        txtServicoProg.setText("Usuario Deletado com Sucesso");
        txtDataProg.setText("Atual usuário: Vázio");
    }
    public void clickBtnAlterar(View v)
    {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        txtServicoProg.setText("Usuario Alterado com Sucesso");
        txtDataProg.setText("Atual usuário: \nNOME: "+credencial.getNome()+"\nUSUARIO: "+credencial.getUsuario()+"\nSENHA: "+credencial.getSenha());
    }
    public void clickBtnCadastrar(View v)
    {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        txtServicoProg.setText("Usuario Cadastrado com Sucesso");
        txtDataProg.setText("Atual usuário: \nNOME: "+credencial.getNome()+"\nUSUARIO: "+credencial.getUsuario()+"\nSENHA: "+credencial.getSenha());
    }

    public void clickBtnNovo(View v){
        limpar();
    }

    public void limpar(){
        edtNomeProg.setText("");
        edtUsuarioProg.setText("");
        edtSenhaProg.setText("");
        edtNomeProg.requestFocus();
        txtServicoProg.setText("Serviço");
        txtServicoProg.setText("");
        txtDataProg.setText("");
    }

}