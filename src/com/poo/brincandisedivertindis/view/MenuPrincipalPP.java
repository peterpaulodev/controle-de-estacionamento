package com.poo.brincandisedivertindis.view;

import com.poo.brincandisedivertindis.controladores.CadastroVeiculoPP;
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
        private static final int SAIR = 0;


    private ConsolePP console;
    private CadastroVeiculoPP cadastroVeiculosControlador;

    public MenuPrincipalPP(ConsolePP console, CadastroVeiculoPP cadastroVeiculosControlador) {
        this.console = console;
        this.cadastroVeiculosControlador = cadastroVeiculosControlador;
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
                    console.escreve("6) Verificar vagas disponíveis");
                    console.escreve("6) Verificar onde um veículo está estacionado");
                    console.escreve("------------------------------");

                    console.escreve("Digite uma opção: ");

                    Integer opcao = console.leInteiro();

                    switch (opcao) {
                        case CADASTRAR_VEICULO:
                            cadastroVeiculosControlador.cadastrarVeiculo();
                            break;
                        case CADASTRAR_MARCA:
//                            cadastroVeiculosControlador.;
                            break;
                        case CADASTRAR_MODELO:
//                            cadastroVeiculosControlador.;
                            break;
                        case CADASTRAR_VAGA:
//                            cadastroVeiculosControlador.;
                            break;
                        case REGISTRAR_ESTACIONAMENTO:
//                            cadastroVeiculosControlador.;
                            break;
                        case VERIFICAR_VAGA:
//                            cadastroVeiculosControlador.;
                            break;
                        case VERIFICAR_VAGAS_DISPONIVEIS:
//                            cadastroVeiculosControlador.;
                            break;
                        case VERIFICAR_VAGA_VEICULO:
//                            cadastroVeiculosControlador.;
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
