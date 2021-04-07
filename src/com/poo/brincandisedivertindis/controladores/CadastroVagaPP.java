package com.poo.brincandisedivertindis.controladores;

import com.mysql.jdbc.PreparedStatement;
import com.poo.brincandisedivertindis.entidades.MarcaPP;
import com.poo.brincandisedivertindis.entidades.VagasPP;
import com.poo.brincandisedivertindis.factory.ConexaoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroVagaPP {
    private ConsolePP console;

    public CadastroVagaPP(ConsolePP console) {
        this.console = console;
    }

    public VagasPP preencherDados() {
        VagasPP vagas = new VagasPP();

        console.escreve("Digite o código da fileira:");
        Integer codFileira = console.leInteiro();
        vagas.setCodFileira(codFileira);

        console.escreve("Digite o código da vaga:");
        Integer codVaga = console.leInteiro();
        vagas.setCodVaga(codVaga);

        return vagas;
    }

    public void cadastrarVaga(VagasPP vagas) throws Exception {
        String sql = "INSERT INTO vagas(codigo_vaga, codigo_fileira) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            // Valores esperados pela query (?)
            pstm.setInt(1, vagas.getCodVaga());
            pstm.setInt(2, vagas.getCodFileira());

            pstm.execute(); // Executa a query
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
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
    }

    public void verificarVaga() {
        console.escreve("------ CONSULTE UMA VAGA ------");

        console.escreve("Digite o código da fileira:");
        Integer codFileira = console.leInteiro();

        console.escreve("Digite o código da vaga:");
        Integer codVaga = console.leInteiro();

        console.escreve("Digite a data desejada (formato: yyyy-mm-dd):");
        String data = console.leLinha();

        String sql = "SELECT * FROM estacionamento WHERE codigo_vaga = '" + codVaga + "' AND codigo_fileira = '" + codFileira + "' AND dt_entrada LIKE '%" + data + "%' LIMIT 1";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            if (rset.next()) {
                System.out.println("\n A vaga está indisponível!\n");
            } else {
                System.out.println("\n A vaga está disponível!\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
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
    }

    public void verificarVagasDisponiveis() {
        console.escreve("------ CONSULTE AS VAGAS OCUPADAS ------");

        console.escreve("Digite a data desejada (formato: yyyy-mm-dd):");
        String data = console.leLinha();

        String sql = "SELECT * FROM estacionamento WHERE dt_entrada LIKE '%" + data + "%'";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            Integer vagas = 0;
            while (rset.next()) {
                vagas++;
            }

            System.out.println("\n -----> " + vagas + " vaga(s) ocupada(s) no dia informado!.\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // Try para fechar as conexões
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
    }

    public void verificarVagaVeiculo() {
        console.escreve("------ ENCONTRE O SEU VEÍCULO ------");

        List<VagasPP> vagasList = new ArrayList<VagasPP>();

        console.escreve("Digite a placa do veículo:");
        String placa = console.leLinha();

        console.escreve("Digite a data desejada (formato: yyyy-mm-dd):");
        String data = console.leLinha();

        String sql = "SELECT * FROM estacionamento WHERE dt_entrada LIKE '%" + data + "%' AND placa_veiculo = '" + placa + "'";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                VagasPP vagas = new VagasPP();

                vagas.setCodVaga(rset.getInt("codigo_vaga"));
                vagas.setCodFileira(rset.getInt("codigo_fileira"));

                vagasList.add(vagas);
            }

            if (vagasList.size() > 0) {
                System.out.println("\nNeste dia o seu veículo esteve nas seguintes vagas: \n");
                for (VagasPP v : vagasList) {
                    System.out.println("Vaga: " + v.getCodVaga());
                    System.out.println("Fileira: " + v.getCodFileira());
                    System.out.println("-------------- // -----------");
                }
            } else {
                System.out.println("\nEste veículo não ocupou nenhuma vaga neste dia!\n");
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
    }

    public List<VagasPP> listarVagas(){
        List<VagasPP> marcasList = new ArrayList<VagasPP>();

        String sql = "SELECT * FROM vagas";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                VagasPP marca = new VagasPP();

                marca.setCodVaga(rset.getInt("codigo_vaga"));
                marca.setCodFileira(rset.getInt("codigo_fileira"));

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
