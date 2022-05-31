package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;
import br.com.fiap.service.UploadService;

@Named
@RequestScoped
public class UsuarioBean {
	private UploadedFile imagem;
	@Inject
	private Usuario usuario;
	@Inject
	private UsuarioDao d;
	
	public void salvar() {
		usuario.setCaminhoImagem(UploadService.write(imagem, "imagens"));
		d.criar(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UploadedFile getImagem() {
		return imagem;
	}

	public void setImagem(UploadedFile imagem) {
		this.imagem = imagem;
	}

	public List<Usuario> getAll() {
		return d.listar();
	}
}
