package com.poo.brincandisedivertindis.view;

import com.poo.brincandisedivertindis.controladores.CadastroEstacionamentoPP;
import com.poo.brincandisedivertindis.controladores.CadastroVagaPP;
import com.poo.brincandisedivertindis.controladores.CadastroVeiculoPP;
import com.poo.brincandisedivertindis.controladores.GeralPP;
import com.poo.brincandisedivertindis.entidades.*;
import com.poo.brincandisedivertindis.util.ConsolePP;

public class MenuPrincipalPP {
        private static final int CADASTRAR_VEICULO = 1;
        private static final int CADASTRAR_MARCA = 2;
        private static final int CADASTRAR_MODELO = 3;
        private static final int CADASTRAR_VAGA = 4;
        private static final int REGISTRAR_ESTACIONAMENTO = 5;
        private static final int VERIFICAR_VAGA = 6;
        private static final int VERIFICAR_VAGAS_DISPONIVEIS = 7;
        private static final int VERIFICAR_VAGA_VEICULO = 8;
        private static final int CONSULTAR_DADOS = 9;
        private static final int SAIR = 0;


    private ConsolePP console;
    private CadastroVeiculoPP cadastroVeiculosControlador;
    private CadastroVagaPP cadastroVagasControlador;
    private CadastroEstacionamentoPP cadastroEstacionamentoControlador;
    private GeralPP geralControlador;

    public MenuPrincipalPP(ConsolePP console, CadastroVeiculoPP cadastroVeiculosControlador, CadastroVagaPP cadastroVagasControlador, CadastroEstacionamentoPP cadastroEstacionamentoControlador, GeralPP geralControlador) {
        this.console = console;
        this.cadastroVeiculosControlador = cadastroVeiculosControlador;
        this.cadastroVagasControlador = cadastroVagasControlador;
        this.cadastroEstacionamentoControlador = cadastroEstacionamentoControlador;
        this.geralControlador = geralControlador;
    }

        public void run() {
            try {
                boolean sair = false;
                do {
                    console.escreve("------ MENU PRINCIPAL ------");
                    console.escreve("1) Cadastrar veículos");
                    console.escreve("2) Cadastrar marcas");
                    console.escreve("3) Cadastrar modelos");
                    console.escreve("4) Cadastrar vaga");
                    console.escreve("5) Registrar um estacionamento");
                    console.escreve("6) Verificar a disponibilidade de uma vaga");
                    console.escreve("7) Verificar vagas ocupadas e disponíveis");
                    console.escreve("8) Verificar onde um veículo está estacionado");
                    console.escreve("9) Relatório de cadastros");
                    console.escreve("0) Sair");
                    console.escreve("------------------------------");

                    console.escreve("Digite uma opção: ");

                    Integer opcao = console.leInteiro();

                    switch (opcao) {
                        case CADASTRAR_VEICULO:
                            VeiculoPP veiculo = cadastroVeiculosControlador.preencherDadosVeiculo();
                            cadastroVeiculosControlador.cadastrarVeiculo(veiculo);
                            break;
                        case CADASTRAR_MODELO:
                            ModeloPP modelo = cadastroVeiculosControlador.preencherDadosModelo();
                            cadastroVeiculosControlador.cadastrarModelo(modelo);
                            break;
                        case CADASTRAR_MARCA:
                            MarcaPP marca = cadastroVeiculosControlador.preencherDadosMarca();
                            cadastroVeiculosControlador.cadastrarMarca(marca);
                            break;
                        case CADASTRAR_VAGA:
                            VagasPP vagas = cadastroVagasControlador.preencherDados();
                            cadastroVagasControlador.cadastrarVaga(vagas);
                            break;
                        case REGISTRAR_ESTACIONAMENTO:
                            EstacionamentoPP estacionamento = cadastroEstacionamentoControlador.preencherDadosEstacionamento();
                            cadastroEstacionamentoControlador.cadastrarEstacionamento(estacionamento);
                            break;
                        case VERIFICAR_VAGA:
                            cadastroVagasControlador.verificarVaga();
                            break;
                        case VERIFICAR_VAGAS_DISPONIVEIS:
                            cadastroVagasControlador.verificarVagasDisponiveis();
                            break;
                        case VERIFICAR_VAGA_VEICULO:
                            cadastroVagasControlador.verificarVagaVeiculo();
                            break;
                        case CONSULTAR_DADOS:
                            geralControlador.relatorioCadastros();
                            break;
                        case SAIR:
                            sair = true;
                            break;
                    }

                } while (!sair);
            } catch (Exception ex) {
            }
        }

}
