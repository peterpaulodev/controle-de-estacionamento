package com.poo.brincandisedivertindis.controladores;

import com.mysql.jdbc.PreparedStatement;
import com.poo.brincandisedivertindis.entidades.*;
import com.poo.brincandisedivertindis.factory.ConexaoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroVeiculoPP {
    private ConsolePP console;

    public CadastroVeiculoPP(ConsolePP console) {
        this.console = console;
    }

    // --------- CADASTRO DE VEICULOS --------- //
    public VeiculoPP preencherDadosVeiculo(){
        VeiculoPP veiculo = new VeiculoPP();

        console.escreve("Digite a placa do veículo:");
        String placa = console.leLinha();
        veiculo.setPlaca(placa);

        console.escreve("Digite a cor do veículo:");
        String cor = console.leLinha();
        veiculo.setCor(cor);

        console.escreve("Digite o modelo do veículo:");
        String modelo = console.leLinha();
        veiculo.setModelo(modelo);

        return veiculo;
    }

    public void cadastrarVeiculo(VeiculoPP veiculo) throws Exception {
        String sql = "INSERT INTO veiculos(placa, cor, modelo) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            // Valores esperados pela query (?)
            pstm.setString(1, veiculo.getPlaca());
            pstm.setString(2, veiculo.getCor());
            pstm.setString(3, veiculo.getModelo());

            pstm.execute(); // Executa a query
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<VeiculoPP> listarVeiculos(){
        List<VeiculoPP> veiculosList = new ArrayList<VeiculoPP>();

        String sql = "SELECT * FROM veiculos";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                VeiculoPP veiculo = new VeiculoPP();

                veiculo.setPlaca(rset.getString("placa"));
                veiculo.setModelo(rset.getString("modelo"));
                veiculo.setCor(rset.getString("cor"));

                veiculosList.add(veiculo);
            }

//            if (veiculosList.size() > 0) {
//                System.out.println("\nNeste dia o seu veículo esteve nas seguintes vagas: \n");
//                for (VagasPP v : veiculosList) {
//                    System.out.println("Vaga: " + v.getCodVaga());
//                    System.out.println("Fileira: " + v.getCodFileira());
//                    System.out.println("-------------- // -----------");
//                }
//            } else {
//                System.out.println("\nEste veículo não ocupou nenhuma vaga neste dia!\n");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return veiculosList;
    }


    // --------- CADASTRO DE MODELOS --------- //
    public ModeloPP preencherDadosModelo(){
        ModeloPP modelo = new ModeloPP();

        console.escreve("Digite o código do modelo:");
        String codigo = console.leLinha();
        modelo.setCodigo(codigo);

        console.escreve("Digite o nome do modelo:");
        String nome = console.leLinha();
        modelo.setNome(nome);

        return modelo;
    }

    public void cadastrarModelo(ModeloPP modelo) throws Exception {
        String sql = "INSERT INTO modelos(nome, codigo) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            // Valores esperados pela query (?)
            pstm.setString(1, modelo.getNome());
            pstm.setString(2, modelo.getCodigo());

            pstm.execute(); // Executa a query
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<ModeloPP> listarModelos(){
        List<ModeloPP> modelosList = new ArrayList<ModeloPP>();

        String sql = "SELECT * FROM modelos";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                ModeloPP modelo = new ModeloPP();

                modelo.setNome(rset.getString("nome"));
                modelo.setCodigo(rset.getString("codigo"));

                modelosList.add(modelo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return modelosList;
    }


    // --------- CADASTRO DE MARCAS --------- //
    public MarcaPP preencherDadosMarca(){
        MarcaPP marca = new MarcaPP();

        console.escreve("Digite o código da marca:");
        String codigo = console.leLinha();
        marca.setCodigo(codigo);

        console.escreve("Digite o nome da marca:");
        String nome = console.leLinha();
        marca.setNome(nome);

        return marca;
    }

    public void cadastrarMarca(MarcaPP marca) throws Exception {
        String sql = "INSERT INTO marcas(nome, codigo) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            // Valores esperados pela query (?)
            pstm.setString(1, marca.getNome());
            pstm.setString(2, marca.getCodigo());

            pstm.execute(); // Executa a query
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<MarcaPP> listarMarcas(){
        List<MarcaPP> marcasList = new ArrayList<MarcaPP>();

        String sql = "SELECT * FROM marcas";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                MarcaPP marca = new MarcaPP();

                marca.setCodigo(rset.getString("codigo"));
                marca.setNome(rset.getString("nome"));

                marcasList.add(marca);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return marcasList;
    }


}
