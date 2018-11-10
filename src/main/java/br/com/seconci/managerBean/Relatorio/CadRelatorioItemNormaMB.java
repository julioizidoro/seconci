package br.com.seconci.managerBean.Relatorio;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.seconci.dao.NormaItemDao;
import br.com.seconci.model.Normaitem;
import br.com.seconci.model.Relatorio;
import br.com.seconci.model.Relatorioitem;
import br.com.seconci.model.Relatorioitemcomentario;
import br.com.seconci.model.Relatorioitemcomentariofoto;
import br.com.seconci.model.Relatorioitemdescricao;

@Named
@ViewScoped
public class CadRelatorioItemNormaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private NormaItemDao normaItemDao;
	private Relatorio relatorio;
	private Relatorioitem relatorioItem;
	private String novoComentario;
	
	@PostConstruct
	private void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		if (relatorio==null) {
			relatorio = (Relatorio) session.getAttribute("relatorio");
			relatorioItem = new Relatorioitem();
			Normaitem norma = (Normaitem) session.getAttribute("normaItem");
			consultaNormaItem(norma);
			novoComentario="";
		}
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public Relatorioitem getRelatorioItem() {
		return relatorioItem;
	}

	public void setRelatorioItem(Relatorioitem relatorioItem) {
		this.relatorioItem = relatorioItem;
	}
	
	public String getNovoComentario() {
		return novoComentario;
	}

	public void setNovoComentario(String novoComentario) {
		this.novoComentario = novoComentario;
	}

	public void consultaNormaItem(Normaitem norma) {
		norma = normaItemDao.pesquisar(norma.getIdnormaitem());
		if (norma!=null) {
			relatorioItem.setItemnorma(norma.getItemnorma());
			relatorioItem.setNome(norma.getNome());
			
			//Gerar lista descricao
			if (relatorioItem.getRelatorioitemdescricaoList()==null) {
				relatorioItem.setRelatorioitemdescricaoList(new ArrayList<Relatorioitemdescricao>());
			}
			if (norma.getNormadescricaoList()!=null) {
				for (int i=0;i<norma.getNormadescricaoList().size();i++) {
					Relatorioitemdescricao  relatorioItemDescricao = new Relatorioitemdescricao();
					relatorioItemDescricao.setDescricao(norma.getNormadescricaoList().get(i).getDescricao());
					relatorioItemDescricao.setSelecionado(false);
					relatorioItemDescricao.setRelatorioitem(relatorioItem);
					relatorioItem.getRelatorioitemdescricaoList().add(relatorioItemDescricao);
				}
			}
			
			//Gerar Lista Comentarios
		}
		if (relatorioItem.getRelatorioitemcomentarioList()==null) {
			relatorioItem.setRelatorioitemcomentarioList(new ArrayList<Relatorioitemcomentario>());
		}
		if (norma.getNormacomentarioList()!=null) {
			for (int i=0;i<norma.getNormacomentarioList().size();i++) {
				Relatorioitemcomentario  relatorioItemComentario = new Relatorioitemcomentario();
				relatorioItemComentario.setComentario(norma.getNormacomentarioList().get(i).getComentario());
				relatorioItemComentario.setSelecionado(false);
				relatorioItemComentario.setNovo(false);
				relatorioItemComentario.setRelatorioitem(relatorioItem);
				relatorioItem.getRelatorioitemcomentarioList().add(relatorioItemComentario);
			}
		}
		
		//Gerar lista de foros comentários
		
		if (relatorioItem.getRelatorioitemcomentariofotoList()==null) {
			relatorioItem.setRelatorioitemcomentariofotoList(new ArrayList<Relatorioitemcomentariofoto>());
		}
		if (norma.getNormacomentariofotoList()!=null) {
			for (int i=0;i<norma.getNormacomentariofotoList().size();i++) {
				Relatorioitemcomentariofoto  relatorioItemComentariofoto = new Relatorioitemcomentariofoto();
				String nome = String.valueOf(norma.getNormacomentariofotoList().get(i).getIdnormacomentariofoto());
				nome = nome + "_" + norma.getNormacomentariofotoList().get(i).getNomearquivo();
				relatorioItemComentariofoto.setNomrarquivo(nome);
				relatorioItemComentariofoto.setSelecionado(true);
				relatorioItemComentariofoto.setRelatorioitem(relatorioItem);
				relatorioItem.getRelatorioitemcomentariofotoList().add(relatorioItemComentariofoto);
			}
		}
	}
	
	public String nomeComentarioFoto(Relatorioitemcomentariofoto foto) {
		String nome =  "https://local.systm.com.br/imagens/" + foto.getNomrarquivo();
		return nome;
	}
	
	
	public String cancelar() {
		return "cadastroRelatorio";
	}
	
	public String incluirNovoComentario() {
		if (novoComentario.length()>0) {
			Relatorioitemcomentario  relatorioItemComentario = new Relatorioitemcomentario();
			relatorioItemComentario.setComentario(novoComentario);
			relatorioItemComentario.setSelecionado(true);
			relatorioItemComentario.setRelatorioitem(relatorioItem);
			relatorioItemComentario.setNovo(true);
			relatorioItem.getRelatorioitemcomentarioList().add(relatorioItemComentario);
			novoComentario = "";
		}
		
		return null;
	}
	
	public void excluirComentario(int index) {
		Relatorioitemcomentario comentario = relatorioItem.getRelatorioitemcomentarioList().get(index);
		if ((comentario.isSelecionado()) && (!comentario.isNovo())) {
			relatorioItem.getRelatorioitemcomentarioList().remove(index);
		}
	}
	
	public String styleComentario(Relatorioitemcomentario comentario) {
		if (comentario.isNovo()) {
			return "ji-descricaocomentarionovo";
		}
		return "ji-descricaocomentariopadrao";
	}
	
	

	

}
