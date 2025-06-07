package Modules.User;

import DAO.DAO;
import Enums.EspecieEnum;
import Modules.User.Errors.UsuarioErros;
import Modules.User.Exceptions.UsuarioException;
import Modules.VirtualPet.Errors.VirtualPetErros;
import Modules.VirtualPet.Exceptions.VirtualPetException;
import Modules.VirtualPet.VirtualPetController;
import Modules.VirtualPet.VirtualPetModel;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class UsuarioController {

    private DAO<UsuarioModel> dao = new DAO<UsuarioModel>();
    private VirtualPetController petController = new VirtualPetController();
    private int idAtual = 1;
    private UsuarioModel usuarioLogado;

    public boolean possuiPet(){
        return petController.existePet();
    }

    public boolean entrar(String emailInformado, String senhaInformada){
        boolean status = false;
        try {
            List<UsuarioModel> usuario = dao.retornarTodos();
            for (int i = 0; i < usuario.size(); i++) {
                if (usuario.get(i).equals(emailInformado)) {
                    usuarioLogado = (UsuarioModel) usuario;
                }
            }
            if (usuarioLogado == null){
                throw new UsuarioException(UsuarioErros.verifiqueSuasCredenciais);
            }

            String senhaCodificada = Base64.getEncoder().encodeToString(senhaInformada.getBytes(StandardCharsets.UTF_8));

            if (this.usuarioLogado.getEmail().equals(emailInformado) && this.usuarioLogado.getSenha().equals(senhaCodificada)){
                this.usuarioLogado.entrar();
                status = true;
            } else {
                throw new UsuarioException(UsuarioErros.verifiqueSuasCredenciais);
            }
        } catch (UsuarioException erro) {
            System.err.println(erro.getMessage());
        }

        return status;
    }

    public void sair(){
         this.usuarioLogado = null;
    }

    public boolean verificar(String email){
        List<UsuarioModel> user = dao.retornarTodos();

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean inserirUsuario(String nome, String email, String senha){
        boolean status = false;

        try {

            if (!email.contains("@")){
                throw new UsuarioException(UsuarioErros.emailInvalido);
            }
            if (senha.length() < 8){
                throw new UsuarioException(UsuarioErros.senhaFraca);
            }
            boolean usuarioExistente = this.verificar(email);

            if (usuarioExistente){
                throw new UsuarioException(UsuarioErros.emailJaCadastrado);
            }

            UsuarioModel usuario = new UsuarioModel(idAtual, nome, email, senha);
            idAtual++;

            status = this.dao.inserir(usuario);
            this.usuarioLogado = usuario;

        } catch (UsuarioException erro){
            System.err.println(erro.getMessage());
        }
        return status;
    }

    public boolean adotarPet(String nome, EspecieEnum especie){
        boolean status = false;
        try {
            if (this.usuarioLogado == null) {
                throw new UsuarioException(UsuarioErros.verifiqueSuasCredenciais);
            }
            if (this.possuiPet()) {
                throw new VirtualPetException(VirtualPetErros.jaPossuiPet);
            }
            this.petController.adotar(nome, especie);
            this.usuarioLogado.adotarPet(this.petController.getPet());
            status = true;
        } catch (VirtualPetException | UsuarioException erro){
            System.err.println(erro.getMessage());
        }
        return status;
    }


    public void removerPet(){
        try {
            throw new VirtualPetException(VirtualPetErros.naoPodeAbandonar);

        } catch (VirtualPetException erro) {
            System.err.println(erro.getMessage());
        }
    }

    public void alimenarPet(){
        this.petController.alimetarPet();
    }

    public void limparPet(){
        this.petController.limparPet();
    }

    public void brincarComPet(){
        this.petController.brincarComPet();
    }

    public VirtualPetModel meuPet(){
        return this.petController.getPet();
    }
}
