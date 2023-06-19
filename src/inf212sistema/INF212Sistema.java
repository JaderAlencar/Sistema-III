/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf212sistema;

import Controller.CMedico;
import Controller.CPaciente;
import Model.Medico;
import Model.Paciente;
import Util.Validadores;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Adm
 */
public class INF212Sistema {

    public static CPaciente cadPaciente = new CPaciente();
    public static CMedico cadMedico = new CMedico();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadPaciente.mockPacientes();
        cadMedico.mockMedicos();
        int opM = 99;
        int opSM = 99;

        do {
            System.out.println("-- Sistema de Agendmento --");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                if (opM == 1) {
                                    cadastrarPaciente();
                                } else {
                                    cadastrarMedico();
                                }
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                if (opM == 1) {
                                    editarPaciente();
                                } else {
                                    editarMedico();
                                }
                                break;
                            case 3:
                                if (opM == 1) {
                                    listarPaciente();
                                } else {
                                    listarMedico();
                                }
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                if (opM == 1) {
                                    deletarPaciente();
                                } else {
                                    deletarMedico();
                                }
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                        }
                    } while (opSM != 0);
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (opM != 0);

    }//fim método main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("-- Menu Principal --");
        System.out.println("1 - Ger. Paciente");
        System.out.println("2 - Ger. Medico");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }//fim menuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Paciente";
        }
        if (opM == 2) {
            subM = "Medico";
        }
        System.out.println("-- Ger. " + subM + " --");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");
    }// fim subMenu

    private static void cadastrarPaciente() {
        System.out.println("-- Cadastro de Paciente --");
        CPaciente cadPaciente = new CPaciente(); // Crie uma instância de CPaciente ou utilize a instância existente

        int login;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        String email = null;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);

            if (tcpf) {
                Paciente pacienteExistente = cadPaciente.buscarPacientePorCPF(cpf);

                if (pacienteExistente != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();

                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();

                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);

        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();

        login = cadPaciente.gerarLogin();

        Paciente paciente = new Paciente(login, nome, cpf, endereco, telefone, email);

        cadPaciente.adicionarPaciente(paciente); // Adiciona o paciente à lista de pacientes no controlador

        System.out.println(paciente.getNome() + " cadastrado com sucesso!");
    }

    private static void cadastrarMedico() {

        System.out.println("-- Cadastro de Medico --");
        CMedico cadMedico = new CMedico(); // Instância do controlador de médicos

        System.out.println("-- Cadastro de Médico --");

        System.out.print("Informe o nome: ");
        String nome = leia.nextLine();

        System.out.print("Informe o CRM: ");
        String cpf = leia.nextLine();

        System.out.print("Informe a especialidade: ");
        String especialidade = leia.nextLine();

        System.out.print("Informe o telefone: ");
        String telefone = leia.nextLine();

        String crm = cadMedico.gerarcrm(); // Gerar um número de CRM usando o controlador

        Medico medico = new Medico(crm, nome, cpf, especialidade, telefone);

        cadMedico.adicionarMedico(medico); // Adicionar o médico à lista de médicos no controlador

        System.out.println(medico.getNome() + " cadastrado com sucesso!");
    }

}
