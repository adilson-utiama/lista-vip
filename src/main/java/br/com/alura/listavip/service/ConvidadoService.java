package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadosRepository;
	
	public Iterable<Convidado> listar(){
		return convidadosRepository.findAll();
	}

	public void salvar(Convidado convidado) {
		convidadosRepository.save(convidado);
		
	}

	public void deletar(Long id) {
		convidadosRepository.delete(id);
		
	}
}
