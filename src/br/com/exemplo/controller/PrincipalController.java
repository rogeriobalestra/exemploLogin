package br.com.exemplo.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.exemplo.model.UsuariosBean;

public class PrincipalController {

	private UsuariosBean usuariosBean;
	private HttpSession sessao;
	
	public PrincipalController() {
		
        FacesContext contexto = FacesContext.getCurrentInstance();
        sessao = (HttpSession) contexto.getExternalContext().getSession(true);
		
        usuariosBean = new UsuariosBean();
        usuariosBean = (UsuariosBean) sessao.getAttribute("usuariosBean");
		
        //
        if(usuariosBean.getNome().equals(null)){
        	sair();
        }
        
	}
	
	
	
	
	
	
	
	
	
    public String sair() {
    	sessao.invalidate();
    	usuariosBean = null;
        return "./index.jsf";
    }
	
	
	
	// GETTS AND SETTERS

	public UsuariosBean getUsuariosBean() {
		return usuariosBean;
	}

	public void setUsuariosBean(UsuariosBean usuariosBean) {
		this.usuariosBean = usuariosBean;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
