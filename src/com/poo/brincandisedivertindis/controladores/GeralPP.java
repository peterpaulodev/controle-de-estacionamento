package com.poo.brincandisedivertindis.controladores;

import com.mysql.jdbc.PreparedStatement;
import com.poo.brincandisedivertindis.entidades.*;
import com.poo.brincandisedivertindis.factory.ConexaoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeralPP {
    private ConsolePP console;
    private CadastroVeiculoPP cadastroVeiculosControlador;
    private CadastroVagaPP cadastroVagasControlador;
    private CadastroEstacionamentoPP cadastroEstacionamentoControlador;
    private GeralPP geralControlador;

    public GeralPP(ConsolePP console, CadastroVeiculoPP cadastroVeiculosControlador, CadastroVagaPP cadastroVagasControlador, CadastroEstacionamentoPP cadastroEstacionamentoControlador) {
        this.console = console;
        this.cadastroVeiculosControlador = cadastroVeiculosControlador;
        this.cadastroVagasControlador = cadastroVagasControlador;
        this.cadastroEstacionamentoControlador = cadastroEstacionamentoControlador;
    }

    public void relatorioCadastros(){
        console.escreve("------ RELATÓRIO GERAL ------");

        System.out.println("\n------ listagem de veículos ------");
        System.out.println("Placa  |  Modelo  |  Cor ");
        for (VeiculoPP v : cadastroVeiculosControlador.listarVeiculos()){
            System.out.println(v.getPlaca() + " - " + v.getModelo() + " - " + v.getCor());
        }

        System.out.println("\n\n------ listagem de marcas ------");
        System.out.println("Código  |  Nome ");
        for (MarcaPP v : cadastroVeiculosControlador.listarMarcas()){
            System.out.println(v.getCodigo() + " - " + v.getNome());
        }

        System.out.println("\n\n------ listagem de modelos ------");
        System.out.println("Código  |  Nome ");
        for (ModeloPP v : cadastroVeiculosControlador.listarModelos()){
            System.out.println(v.getCodigo() + " - " + v.getNome());
        }

        System.out.println("\n\n------ listagem de vagas ------");
        System.out.println("Vaga  |  Fileira ");
        for (VagasPP v : cadastroVagasControlador.listarVagas()){
            System.out.println(v.getCodVaga() + " - " + v.getCodFileira());
        }

        System.out.println("\n\n------ listagem de estacionamentos ------");
        System.out.println("Veículo (Placa)  |  Motorista  |  Entrada |  Vaga  |  Fileira");
        for (EstacionamentoPP v : cadastroEstacionamentoControlador.listarEstacionamento()){
            System.out.println(v.getVeiculo() + " - " + v.getMotorista() + " - " + v.getDataEntrada() + " - " + v.getVaga() + " - " + v.getFileira());
        }

        System.out.println(" \n\n----------------- FIM DO RELATÓRIO ----------------- \n\n");
    }
}
