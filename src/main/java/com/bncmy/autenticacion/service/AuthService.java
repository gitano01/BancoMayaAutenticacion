package com.bncmy.autenticacion.service;

import com.bncmy.autenticacion.model.Clientes;
import com.bncmy.autenticacion.service.repository.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bncmy.autenticacion.model.Usuarios;
import com.bncmy.autenticacion.model.exception.ErrorNegocio;
import com.bncmy.autenticacion.model.exception.RespuestaError;
import com.bncmy.autenticacion.service.repository.usuario.UsuarioRepositoryInterface;

import java.util.Optional;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepositoryInterface repository;
	@Autowired
	private GenericRepository genericRepo;

	public ResponseEntity<?> generateToken(Usuarios user,String band) throws Exception {

		ResponseEntity<?> resp = null;
		try {

			String password = user.getContrasenia();

			user = repository.findByUsername(user.getUsername());

			if (user == null) {
				throw new ErrorNegocio(HttpStatus.BAD_REQUEST, "Operacion Fallida",
						"Usuario y/o contraseña  incorrectos");
			}

			// secrea una instancia de BcryptPassword
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			// Password to encode
			String rawPassword = password;

			// Hashing the password
			String encodedPassword = passwordEncoder.encode(rawPassword);

			// Print the hashed password
			System.out.println("Encoded Password: " + encodedPassword);

			// Check if the raw password matches the encoded password
			if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
				throw new ErrorNegocio(HttpStatus.BAD_REQUEST, "Operacion Fallida",
						"Usuario y/o contraseña  incorrectos");
			}

			//Vamos si la peticion es realizada por un cliente vamos por los datos del (supuesto) si no verificamos si tiene datos de empleado
			if(band.equals("cliente"))
				Optional<Clientes> cli = genericRepo.findById(user.getId());




			resp = new ResponseEntity<Usuarios>(user, HttpStatus.OK);

		} catch (ErrorNegocio en) {

			int numberHtttpDesired = Integer.parseInt(en.getError().getCode());
			RespuestaError respuestaError = en.getError();
			return new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHtttpDesired));

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
		return resp;

	}
}
