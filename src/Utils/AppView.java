package Utils;

import Enums.EspecieEnum;
import Modules.User.UsuarioController;
import java.util.Scanner;

public class AppView {


    private UsuarioController controller = new UsuarioController();

    private void jogando(){

        while (true){

            Scanner scanner = new Scanner(System.in);

            boolean possuiPet = controller.possuiPet();

            if (possuiPet){
                MenuUtil.menuJogoComPet();
            } else {
                MenuUtil.menuJogoSemPet();
            }

            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    if (possuiPet){
                        MenuUtil.menuPet(controller.meuPet());
                    } else {
                        System.out.println("@ Vou te ajudar a adotar seu Pet");
                        for (int i = 0; i < EspecieEnum.values().length; i++) {
                            System.out.printf("@ [%d] > %s\n", i, EspecieEnum.values()[i]);
                        }
                        System.out.print("@ Qual especie você quer? ");
                        int especie = scanner.nextInt();
                        System.out.print("@ Qual será o nome dele (sem espaço)? ");
                        String nomePet = scanner.next();
                        this.controller.adotarPet(nomePet, EspecieEnum.values()[especie]);

                        System.out.println("PARABÉNS, AGORA VOCÊ TEM UM PET!");

                    }
                    break;
                case 2:
                    if (possuiPet){
                        this.controller.brincarComPet();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    if (possuiPet){
                        this.controller.alimenarPet();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 4:
                    if (possuiPet){
                        this.controller.limparPet();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 5:
                    if (possuiPet){
                        this.controller.removerPet();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                case 0:
                    this.controller.sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            if (opcao == 0){
                break;
            }

        }

    }

    public void startGame(){

        boolean escolhendoOpcao = true;

        while (escolhendoOpcao){

            Scanner scanner = new Scanner(System.in);
            MenuUtil.menuStartGame();
            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.print("@ Email: ");
                    String emailLogar = scanner.next();
                    System.out.print("@ Senha: ");
                    String senhaLogar = scanner.next();
                    boolean statusEntrar = this.controller.entrar(emailLogar, senhaLogar);

                    if (statusEntrar){
                        jogando();
                    }

                    break;
                case 2:
                    System.out.println("@ Bem vindo a criação de usuário");
                    System.out.print("@ Qual seu nome mesmo? (Sem espaço): ");
                    String nome = scanner.next();
                    System.out.print("@ Qual o seu melhor email? ");
                    String email = scanner.next();
                    System.out.print("@ Coloque uma senha bem segura (8 caracteres ou mais): ");
                    String senha = scanner.next();

                    boolean usuarioCriado = controller.inserirUsuario(nome, email, senha);

                    if (usuarioCriado){
                        escolhendoOpcao = false;
                    }
                    jogando();
                    continue;
                case 0:
                    this.controller.sair();
                    System.out.println("Fechando jogo!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }

    }

}