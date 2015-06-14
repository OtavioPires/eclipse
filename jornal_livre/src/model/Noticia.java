package model;

import java.util.Date;

public class Noticia {
	private Long id;
	private String titulo;
	private String subtitulo;
	private String texto;
	private String autor;
	private Date data_noticia;
	private Long id_secao;
	
	public Noticia(){
		 
	}
	
	public Noticia(Long id, String titulo, String subtitulo, String texto,
			String autor, Date data_noticia, Long id_secao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.autor = autor;
		this.data_noticia = data_noticia;
		this.id_secao = id_secao;
	}

	
	
}

