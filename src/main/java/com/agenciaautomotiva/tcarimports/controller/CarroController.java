package com.agenciaautomotiva.tcarimports.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenciaautomotiva.tcarimports.model.Carro;
import com.agenciaautomotiva.tcarimports.model.dto.CarroDto;
import com.agenciaautomotiva.tcarimports.repository.CarroRepository;

@Controller
public class CarroController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CarroRepository carroRepository;

	@GetMapping("/carros")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("carros/index");
		
		List<Carro> listarCarro = carroRepository.findAll();
		model.addObject("listarCarro", listarCarro);
		
		return model;
	}

	@GetMapping("/carro/cadastro")
	public ModelAndView cadastro(CarroDto model) {
		return new ModelAndView("carros/cadastro");
	}

	@PostMapping("/carro")
	public ModelAndView cadastrarMoto(@Valid CarroDto model, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) {
			ModelAndView modelView = new ModelAndView("carros/cadastro");
			return modelView;
		}
		
		Carro carro = modelMapper.map(model, Carro.class);
		carroRepository.save(carro);
		return new ModelAndView("redirect:/carros");
	}
}
