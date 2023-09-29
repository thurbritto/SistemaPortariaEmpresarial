package com.project.spe.visitante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Table(name = "visitantes")
@Entity(name = "visitantes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Visitante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long CPF;
    private String placaCarro;
    private String dataHora;
    private String nomeEmpresa;
    private String email;
    private Long telefone;
    private String situacao;
    private String motivo;

    public Visitante(VisitanteRequestDTO data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.nome = data.nome();
        this.CPF = data.CPF();
        this.placaCarro = data.placaCarro();
        this.dataHora = dtf.format(LocalDateTime.now());
        this.nomeEmpresa = data.nomeEmpresa();
        this.email = data.email();
        this.telefone = data.telefone();
        this.situacao = data.situacao();
        this.motivo = data.motivo();
    }
}