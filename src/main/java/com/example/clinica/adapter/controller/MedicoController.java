package com.example.clinica.adapter.controller;

import com.example.clinica.adapter.dto.MedicoDTO;
import com.example.clinica.application.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Void> cadastrarMedico(@RequestBody MedicoDTO medicoDTO) {
        medicoService.cadastrarMedico(medicoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> consultarPorId(@PathVariable int id) {
        Optional<MedicoDTO> medicoDTO = medicoService.consultarPorId(id);
        return medicoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos() {
        List<MedicoDTO> medicos = medicoService.listarMedicos();
        return ResponseEntity.ok(medicos);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarMedico(@RequestBody MedicoDTO medicoDTO) {
        medicoService.atualizarMedico(medicoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable int id) {
        medicoService.excluirMedico(id);
        return ResponseEntity.ok().build();
    }
}

