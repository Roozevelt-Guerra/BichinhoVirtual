package Modules.User;

import Modules.VirtualPet.VirtualPetModel;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UsuarioModel {

    private int id;
    private String nome;
    private boolean logado;
    private String email;
    private VirtualPetModel petVirtual;
    private String senha;

    public UsuarioModel(int id,
                        String nome,
                        String email,
                        String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = Base64.getEncoder().encodeToString(senha.getBytes(StandardCharsets.UTF_8));
    }

    protected boolean entrar() {
        return this.logado = true;
    }

    protected String getEmail() {
        return this.email;
    }

    protected String getSenha() {
        return this.senha;
    }

    protected void adotarPet(VirtualPetModel pet){
        this.petVirtual = pet;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", logado=" + logado +
                ", email='" + email + '\'' +
                ", petVirtual=" + petVirtual +
                ", senha='" + senha + '\'' +
                '}';
    }
}
