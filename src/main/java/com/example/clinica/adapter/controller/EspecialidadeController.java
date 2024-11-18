package com.example.clinica.adapter.controller;

import com.example.clinica.adapter.dto.EspecialidadeDTO;
import com.example.clinica.application.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<Void> criarEspecialidade(@RequestBody EspecialidadeDTO especialidadeDTO) {
        especialidadeService.criarEspecialidade(especialidadeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> consultarPorId(@PathVariable int id) {
        Optional<EspecialidadeDTO> especialidadeDTO = especialidadeService.consultarPorId(id);
        return especialidadeDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO>> listarEspecialidades() {
        List<EspecialidadeDTO> especialidades = especialidadeService.listarEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEspecialidade(@RequestBody EspecialidadeDTO especialidadeDTO) {
        especialidadeService.atualizarEspecialidade(especialidadeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEspecialidade(@PathVariable int id) {
        especialidadeService.excluirEspecialidade(id);
        return ResponseEntity.ok().build();
    }
}
