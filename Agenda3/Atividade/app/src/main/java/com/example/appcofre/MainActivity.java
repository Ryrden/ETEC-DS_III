package com.example.appcofre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtConfirmProg;
    TextView txtServicoProg;
    EditText edtNomeProg;
    EditText edtUsuarioProg;
    EditText edtSenhaProg;
    int quantidadeRegistros;
    int registroAtual;
    int idCredencialAtual;

    credencialModel credencial = new credencialModel();

    bdModel bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtConfirmProg = findViewById(R.id.txtConfirm);
        txtServicoProg = findViewById(R.id.txtServico);
        edtNomeProg = findViewById(R.id.edtServico);
        edtUsuarioProg = findViewById(R.id.edtUsuario);
        edtSenhaProg = findViewById(R.id.edtSenha);

        carregarRegistroZero();
    }

    public void clickBtnDeletar(View v) {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        bd = new bdModel(getApplicationContext());
        bd.delete(bd.getTabela(), credencial);
        limpar();
        carregarRegistroZero();
        txtServicoProg.setText("Usuario Deletado com Sucesso");
    }

    public void clickBtnAlterar(View v) {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        bd = new bdModel(getApplicationContext());
        bd.update(bd.getTabela(), credencial);
        carregarRegistroZero();
        txtServicoProg.setText("Usuario Alterado com Sucesso");
    }

    public void clickBtnCadastrar(View v) {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        bd = new bdModel(getApplicationContext());
        bd.insert(bdModel.getTabela(), credencial);
        carregarRegistroZero();
        txtServicoProg.setText("Usuario Cadastrado com Sucesso");
    }

    public void clickBtnNovo(View v) {
        limpar();
    }

    public void clickBtnAnterior(View v){
        if (quantidadeRegistros != 0 && registroAtual > 0){
            registroAtual -= 1;
            carregarDados(registroAtual);
        }
    }

    public void clickBtnProximo(View v){
        if (quantidadeRegistros != 0 && registroAtual < quantidadeRegistros - 1){
            registroAtual += 1;
            carregarDados(registroAtual);
        }
    }

    public void carregarDados(int i) {
        bd = new bdModel(getApplicationContext());
        ArrayList<credencialModel> arrayCredencialModel;
        arrayCredencialModel = bd.select();
        quantidadeRegistros = arrayCredencialModel.size();
        if (quantidadeRegistros != 0) {
            credencialModel credencialModel = arrayCredencialModel.get(i);
            txtServicoProg.setText("Serviço " + String.valueOf(credencialModel.getId()) +
                    ":");
            idCredencialAtual = credencialModel.getId();
            edtNomeProg.setText(credencialModel.getNome());
            edtUsuarioProg.setText(credencialModel.getUsuario());
            edtSenhaProg.setText(credencialModel.getSenha());
        }
    }

    public void carregarRegistroZero(){
        registroAtual = 0;
        carregarDados(registroAtual);
    }

    public void limpar(){
        edtNomeProg.setText("");
        edtUsuarioProg.setText("");
        edtSenhaProg.setText("");
        edtNomeProg.requestFocus();
        txtServicoProg.setText("Serviço");
        txtServicoProg.setText("");
    }

}