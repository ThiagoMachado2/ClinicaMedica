package com.example.clinica.adapter.controller;

import com.example.clinica.adapter.dto.ConsultaDTO;
import com.example.clinica.application.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        consultaService.agendarConsulta(consultaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> consultarPorId(@PathVariable int id) {
        Optional<ConsultaDTO> consultaDTO = consultaService.consultarPorId(id);
        return consultaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listarConsultas() {
        List<ConsultaDTO> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        consultaService.atualizarConsulta(consultaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsulta(@PathVariable int id) {
        consultaService.cancelarConsulta(id);
        return ResponseEntity.ok().build();
    }
}
