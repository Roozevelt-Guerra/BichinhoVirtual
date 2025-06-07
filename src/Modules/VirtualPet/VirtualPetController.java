package Modules.VirtualPet;

import Enums.EspecieEnum;
import Modules.VirtualPet.Errors.VirtualPetErros;
import Modules.VirtualPet.Exceptions.VirtualPetException;

public class VirtualPetController extends Throwable {

    private VirtualPetModel pet;

    public boolean existePet() {
        return this.pet != null && this.pet.getNome() != null;
    }


    public void adotar(String nome, EspecieEnum especie) {
        pet = new VirtualPetModel(pet, especie);
    }

    public boolean statusFome(){
       return pet.isFome();
    }

    public void alimetarPet(){
        try {
            boolean status = this.statusFome();

            if (!status){
                throw new VirtualPetException(VirtualPetErros.jaComeu);
            }
            this.pet.alimentar();

        } catch (VirtualPetException erro) {
            System.err.println(erro.getMessage());
        }
    }

    public boolean statusLimpeza(){
        return this.pet.isSujo();
    }

    public void limparPet(){
        try {
            boolean status = this.statusLimpeza();

            if (!status) {
                throw new VirtualPetException(VirtualPetErros.jaEstaLimpo);
            }
            this.pet.limpar();

        } catch (VirtualPetException erro) {
            System.err.println(erro.getMessage());
        }
    }

    public void brincarComPet(){
        if (this.statusFome()){
            System.out.println("pet está com fome e não pode brincar");
        } else {
            System.out.println("Brincando com o pet...");
            this.brincarComPet();
            System.out.println("Pet ficou sujo brincando e está com fome");
        }
    }

    public VirtualPetModel getPet() {
        return this.pet;
    }
}
