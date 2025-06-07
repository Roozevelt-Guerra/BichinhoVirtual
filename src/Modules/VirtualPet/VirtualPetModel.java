package Modules.VirtualPet;

import Enums.EspecieEnum;

public class VirtualPetModel {

    private String nome;
    private EspecieEnum especie;
    private boolean fome = true;
    private boolean sujo = true;

    public VirtualPetModel(){}

    public VirtualPetModel(VirtualPetModel pet, EspecieEnum especie) {
        this.nome = nome;
        this.especie = especie;
    }

    public String getNome() {
        return this.nome;
    }

    public EspecieEnum getEspecie() {
        return this.especie;
    }

    public boolean isFome() {
        return this.fome;
    }

    public boolean isSujo() {
        return this.sujo;
    }

    protected void alimentar() {
        this.fome = false;
    }

    protected void limpar() {
        this.sujo = false;
    }

    protected void brincar() {
        this.limpar();
        this.alimentar();
    }

    @Override
    public String toString() {
        return "VirtualPetModel{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
