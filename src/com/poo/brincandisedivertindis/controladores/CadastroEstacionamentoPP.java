package com.poo.brincandisedivertindis.controladores;

import com.mysql.jdbc.PreparedStatement;
import com.poo.brincandisedivertindis.entidades.EstacionamentoPP;
import com.poo.brincandisedivertindis.entidades.VagasPP;
import com.poo.brincandisedivertindis.factory.ConexaoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroEstacionamentoPP {
    private ConsolePP console;

    public CadastroEstacionamentoPP(ConsolePP console) {
        this.console = console;
    }

    public EstacionamentoPP preencherDadosEstacionamento() {
        EstacionamentoPP estacionamento = new EstacionamentoPP();

        console.escreve("Digite a placa do veículo:");
        String placaVeiculo = console.leLinha();
        estacionamento.setVeiculo(placaVeiculo);

        console.escreve("Digite o nome do motorista:");
        String motorista = console.leLinha();
        estacionamento.setMotorista(motorista);

        console.escreve("Digite o código da vaga:");
        String codVaga = console.leLinha();
        estacionamento.setVaga(codVaga);

        console.escreve("Digite o código da fileira da vaga:");
        String codFileira = console.leLinha();
        estacionamento.setFileira(codFileira);

        return estacionamento;
    }

    public void cadastrarEstacionamento(EstacionamentoPP estacionamento) throws Exception {
        String sql = "INSERT INTO estacionamento(placa_veiculo, motorista, dt_entrada, codigo_vaga, codigo_fileira) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            // Valores esperados pela query (?)
            pstm.setString(1, estacionamento.getVeiculo());
            pstm.setString(2, estacionamento.getMotorista());
            pstm.setDate(3, new Date(estacionamento.getDataEntrada().getTime()));
            pstm.setString(4, estacionamento.getVaga());
            pstm.setString(5, estacionamento.getFileira());

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

    public List<EstacionamentoPP> listarEstacionamento(){
        List<EstacionamentoPP> estacionamentoList = new ArrayList<EstacionamentoPP>();

        String sql = "SELECT * FROM estacionamento";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConexaoPP.ConectarBD(); // Cria conexão com o BD
            pstm = (PreparedStatement) conn.prepareStatement(sql); // Prepara para executar a query

            rset = pstm.executeQuery(); // Executa a query

            while (rset.next()) {
                EstacionamentoPP marca = new EstacionamentoPP();

                marca.setVeiculo(rset.getString("placa_veiculo"));
                marca.setVaga(rset.getString("codigo_vaga"));
                marca.setMotorista(rset.getString("motorista"));
                marca.setFileira(rset.getString("codigo_fileira"));
                marca.setDataEntrada(rset.getDate("dt_entrada"));

                estacionamentoList.add(marca);
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
        return estacionamentoList;
    }

}
