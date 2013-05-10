package br.com.exemplo.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import br.com.exemplo.dao.LoginDAO;
import br.com.exemplo.model.UsuariosBean;


public class LoginController implements Serializable {
	

	private static final long serialVersionUID = 1L;
    private UsuariosBean usuariosBean;
    private HttpSession sessao;
    private String login;
    private String senha;
    private String statusLogin = null;
    

	// CONSTRUTOR
    public LoginController() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        sessao = (HttpSession) contexto.getExternalContext().getSession(true);
       
    }
    
    
    // IMPLEMENTAÇÃO DOS MÉTODOS DO CONTROLLER

    public String logar() {
    	
    	try {
    		LoginDAO dao = new LoginDAO();
			
    		usuariosBean = null;
    		usuariosBean = dao.verificaLogin(this.login, this.senha);
    		
    		if(usuariosBean != null) {
    			sessao.setAttribute("usuariosBean", usuariosBean);
    			statusLogin = "sucesso";
    			
    			return "./principal.jsf";
    			
    		} else {
    			statusLogin = "negado";
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return statusLogin;
    }

        
        
        
    public String sair() {
        sessao.invalidate();        
        login = null;
        senha = null;
        usuariosBean = null;
        return "./index.jsf";
    }


    
    
    // GETTS AND SETTERS
	public String getStatusLogin() {
		return statusLogin;
	}


	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}



    
    
    
    
    

}
