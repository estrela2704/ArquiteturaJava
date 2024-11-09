package br.edu.infnet.felipe.domain.usuario;

import java.time.LocalDate;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role", discriminatorType = DiscriminatorType.STRING) // Alterado para user_role
public abstract class Usuario extends Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
    @Column(unique = true, nullable = false)
	private String email;
    
	private String password;
	
    @Enumerated(EnumType.STRING)
	private UsuarioRole role;
    
    public Usuario() {
    	super();
    }
	
	public Usuario(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco, String password, UsuarioRole role) {
		super(cpf, nome, sobrenome, dataNascimento, telefone, endereco);
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioRole getRole() {
		return role;
	}

	public void setRole(UsuarioRole role) {
		this.role = role;
	}

}
