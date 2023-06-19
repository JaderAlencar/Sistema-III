/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adm
 */
public class CPaciente {

    private List<Paciente> pacientes;
    private int login;

    public CPaciente() {
        pacientes = new ArrayList<>();
        login = 1;
    }

    public int gerarLogin() {
        return login++;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void removerPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public void mockPacientes() {
        Paciente paciente1 = new Paciente();
        paciente1.setLogin(gerarLogin());
        paciente1.setCpf("30668518006");
        paciente1.setNome("Juvenal das Candongas");
        paciente1.setTelefone("51999889988");
        paciente1.setEndereco("Rua das Margaridas");
        pacientes.add(paciente1);
        
        Paciente paciente2 = new Paciente();
        paciente2.setLogin(gerarLogin());
        paciente2.setCpf("85606196077");
        paciente2.setNome("Madalena Espirito Santo");
        paciente2.setTelefone("51988998899");
        paciente2.setEndereco("Rua sem saída");
        pacientes.add(paciente1);
        
    }
    
}//fim classe controller

    

