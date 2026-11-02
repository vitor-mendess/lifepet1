
package br.com.lifepet.config;

import br.com.lifepet.entity.Perfil;
import br.com.lifepet.entity.Usuario;
import br.com.lifepet.entity.Tutor;
import br.com.lifepet.repository.UsuarioRepository;
import br.com.lifepet.repository.TutorRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner criarUsuarioTeste(
            UsuarioRepository usuarioRepository,
            TutorRepository tutorRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            Usuario usuario = usuarioRepository
                    .findByEmail("vitor@email.com")
                    .orElseGet(() -> {
                        Usuario novoUsuario = new Usuario();

                        novoUsuario.setNome("Vitor");
                        novoUsuario.setEmail("vitor@email.com");
                        novoUsuario.setSenha(
                                passwordEncoder.encode("123456"));
                        novoUsuario.setPerfil(Perfil.TUTOR);

                        return usuarioRepository.save(novoUsuario);
                    });

            if (usuario.getPerfil() == Perfil.TUTOR
                    && tutorRepository.findByEmailContainingIgnoreCase(
                    usuario.getEmail()).isEmpty()) {

                Tutor tutor = new Tutor();

                tutor.setNome(usuario.getNome());
                tutor.setEmail(usuario.getEmail());
                tutor.setTelefone("11999999999");

                tutorRepository.save(tutor);

                System.out.println("TUTOR DE TESTE CRIADO!");
            }

            if (usuarioRepository.findByEmail(
                    "vet@lifepet.com").isEmpty()) {

                Usuario veterinario = new Usuario();

                veterinario.setNome("Dr. Veterinário");
                veterinario.setEmail("vet@lifepet.com");
                veterinario.setSenha(
                        passwordEncoder.encode("123456"));
                veterinario.setPerfil(Perfil.VETERINARIO);

                usuarioRepository.save(veterinario);
            }
        };
    }
}
