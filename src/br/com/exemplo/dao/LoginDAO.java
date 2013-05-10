package br.com.exemplo.dao;

import br.com.exemplo.model.UsuariosBean;

public class LoginDAO {

	/** CONSTRUTOR */
	public LoginDAO(){
		
	}
	
	
	
	
	/** PEGA DADOS USUARIO BANCO */
	public UsuariosBean verificaLogin(String login, String senha) throws Exception{
		
		UsuariosBean usuariosBean = null;
		
		if(login.equals("rbalestra") && senha.equals("123")){

			 usuariosBean = new UsuariosBean();
			
			//Simulando como se viesse do banco esses dados
			usuariosBean.setNome("rbalestra");
			usuariosBean.setEmail("meuEmail@gmail.com");
			usuariosBean.setTelefone("9999.9889");
		}
		
		return usuariosBean;
	}
	
	
	
}
