package com.example.clinica.adapter.controller;

import com.example.clinica.adapter.dto.PacienteDTO;
import com.example.clinica.application.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Void> cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.cadastrarPaciente(pacienteDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> consultarPorId(@PathVariable int id) {
        Optional<PacienteDTO> pacienteDTO = pacienteService.consultarPorId(id);
        return pacienteDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        List<PacienteDTO> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.atualizarPaciente(pacienteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable int id) {
        pacienteService.excluirPaciente(id);
        return ResponseEntity.ok().build();
    }
}

