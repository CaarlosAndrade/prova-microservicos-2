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

import com.agenciaautomotiva.tcarimports.model.Moto;
import com.agenciaautomotiva.tcarimports.model.dto.MotoDto;
import com.agenciaautomotiva.tcarimports.repository.MotoRepository;

@Controller
public class MotoController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MotoRepository motoRepository;

	@GetMapping("/motos")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("motos/index");
		
		List<Moto> listarMoto = motoRepository.findAll();
		model.addObject("listarMoto", listarMoto);
		
		return model;
	}

	@GetMapping("/moto/cadastro")
	public ModelAndView cadastro(MotoDto model) {
		return new ModelAndView("motos/cadastro");
	}

	@PostMapping("/moto")
	public ModelAndView cadastrarMoto(@Valid MotoDto model, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) {
			ModelAndView modelView = new ModelAndView("motos/cadastro");
			return modelView;
		}
		
		Moto moto = modelMapper.map(model, Moto.class);
		motoRepository.save(moto);
		return new ModelAndView("redirect:/motos");
	}
}
