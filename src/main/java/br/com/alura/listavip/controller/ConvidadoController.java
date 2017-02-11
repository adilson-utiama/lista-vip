package br.com.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;	

	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){
		
		Iterable<Convidado> convidados = convidadoService.listar();
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@Transactional
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Convidado convidado){
		try{
			
//			boolean emailFalha = false;
//			
//			try{
//				EmailService emailService = new EmailService();
//				emailService.enviar(convidado.getNome(), convidado.getEmail());
//			}catch(Exception e){
//				emailFalha = true;
//				throw new RuntimeException(e);
//			}
//			if(emailFalha){
				convidadoService.salvar(convidado);
//			}
			
			
		}catch(Exception e){
			throw new RuntimeException("Erro ao salvar convidado.");
		}
		
		return "redirect:listaconvidados";
	}
	
	@RequestMapping("listaconvidados/{codigo}")
	public String deletar(@PathVariable("codigo") Convidado convidado){
		System.out.println(convidado.getId());
		convidadoService.deletar(convidado.getId());
		return "listaconvidados";
	}
}
