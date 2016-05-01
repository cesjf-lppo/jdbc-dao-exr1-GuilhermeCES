/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class AnuncioDAO {
    public List<Anuncio> listaTodos() {
        List<Anuncio> todos = new ArrayList<>();
        Connection conexao;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM anuncio");
            while (resultado.next()) {
                Anuncio anu = new Anuncio();
                anu.setId(resultado.getLong("id"));
                anu.setNome(resultado.getString("nome"));
                anu.setDescricao(resultado.getString("descricao"));
                anu.setPreco(resultado.getFloat("preco"));
                todos.add(anu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todos;
    }

    public void criar(Anuncio novoAnu) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(String.format("INSERT INTO anuncio(nome, descricao, preco) VALUES('%s','%s','%f')", novoAnu.getNome(), novoAnu.getDescricao(), novoAnu.getPreco()));
        }
        catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
