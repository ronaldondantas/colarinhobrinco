/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author jotap
 */
@Entity
@SequenceGenerator(name="usuario_seq", sequenceName="usuario_id_seq", allocationSize=1)
public class Usuario {
    
        @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_seq")
	private Integer id;
        
        @Column(name="nome")
	private String nome;
        
        @Column(name="email")
	private String email;        
        
        @Column(name="senha")
	private String senha;      
        
        public Usuario(){}
   
        public Usuario(String nome, String email, String senha) {
            super();
            this.nome = nome;
            this.email = email;
            this.senha = senha;            
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }    
            
        @Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
    
}
