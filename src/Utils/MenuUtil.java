package Utils;

import Modules.VirtualPet.VirtualPetModel;

abstract public class MenuUtil {

    static void menuStartGame(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@ 1 > Entrar        (\\___/)  @");
        System.out.println("@ 2 > Criar Conta    |* *|   @");
        System.out.println("@ 0 > Finalizar       \\_/    @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.print("@ Escolha uma opção: ");
    }

    static void menuJogoSemPet(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@ 1 > Adotar Pet             @");
        System.out.println("@ 0 > Finalizar              @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.print("@ Escolha uma opção: ");
    }

    static void menuJogoComPet(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@ 1 > Ver Meu Pet     _      @");
        System.out.println("@ 2 > Brincar       (^ ^)    @");
        System.out.println("@ 3 > Alimentar    <|  o|>   @");
        System.out.println("@ 4 > Limpar        |O  |    @");
        System.out.println("@ 5 > Remover Pet  <|___|>   @");
        System.out.println("@ 0 > Finalizar       S      @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.print("@ Escolha uma opção: ");
    }

    static void menuPet(VirtualPetModel pet){

        if (pet.getEspecie() == null){
            System.out.println("VOCÊ NÃO POSSUI PET");
            return;
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        switch (pet.getEspecie()){
            case GATO:
                System.out.println("""
\\    /\\
 )  ( ')
(  /  )
 \\(__) \\""");
                break;
            case CACHORRO:
                System.out.println("""
     __
(___()'`;
/,    /`
\\\\"--\\\\""");
                break;
            case PEIXE:
                System.out.println("""
       O  o
   _\\_   o
\\\\/  o\\ .
//\\___=
   ''""");
                break;
            case PASSARO:
                System.out.println("""
                           (
                          `-`-.
                          '( @ >
                           _) (
                          /    )
                         /_,'  /\s
                           \\  /\s
                        ===m""m===""");
                break;
            case COELHO:
                System.out.println("""
                          //
                         ('>
                         /rr
                        *\\))_""");
                break;
        }
        System.out.printf("@ Nome > %s\n", pet.getNome());
        System.out.printf("@ Especie > %s\n", pet.getEspecie());
        System.out.printf("@ Fome > %b\n", pet.isFome());
        System.out.printf("@ Sujo > %b\n", pet.isSujo());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

}