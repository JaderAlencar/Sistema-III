/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adm
 */
public class CMedico {


    private List<Medico> medicos;
    private int login;
    private String crm;

    public CMedico() {
        medicos = new ArrayList<>();
        login = 1;
    }

    public int gerarLogin() {
        return login++;
    }
    public String gerarcrm(){
        return crm;
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void removerMedico(Medico medico) {
        medicos.remove(medico);
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public Medico buscarMedico(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        return null;
    }

    public void mockMedicos() {
        Medico medico1 = new Medico();
        medico1.setLogin(gerarLogin());
        medico1.setNome("Jose Maria Brabo");
        medico1.setCrm("0986341");
        medico1.setEspecialidade("Clinico Geral");
        medico1.setTelefone("51999999999");
        medico1.setEmail("jose.carlos@poaclin.com");
        medicos.add(medico1);
        
        Medico medico2 = new Medico();
        medico2.setLogin(gerarLogin());
        medico2.setNome("Roberto Carlos Marrento");
        medico2.setCrm("0578941");
        medico2.setEspecialidade("otorrinolaringologista");
        medico2.setTelefone("51999889988");
        medico2.setEmail("roberto.carlos@poaclin.com");
        medicos.add(medico2);
        
        
        
    }
    
}//fim classe controller
