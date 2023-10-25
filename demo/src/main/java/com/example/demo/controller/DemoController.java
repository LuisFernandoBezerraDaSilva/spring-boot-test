// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/usuarios")
// public class UsuarioController {
//     @Autowired
//     private UsuarioRepository usuarioRepository;

//     @GetMapping
//     public List<Usuario> listarUsuarios() {
//         return usuarioRepository.findAll();
//     }

//     @PostMapping
//     public Usuario criarUsuario(@RequestBody Usuario usuario) {
//         return usuarioRepository.save(usuario);
//     }

//     @GetMapping("/{id}")
//     public Usuario buscarUsuario(@PathVariable Long id) {
//         return usuarioRepository.findById(id)
//                 .orElseThrow(() -> new UsuarioNotFoundException(id));
//     }

//     @PutMapping("/{id}")
//     public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
//         Usuario usuario = usuarioRepository.findById(id)
//                 .orElseThrow(() -> new UsuarioNotFoundException(id));
//         usuario.setNome(usuarioAtualizado.getNome());
//         usuario.setIdade(usuarioAtualizado.getIdade());
//         usuario.setEmail(usuarioAtualizado.getEmail());
//         return usuarioRepository.save(usuario);
//     }

//     @DeleteMapping("/{id}")
//     public void deletarUsuario(@PathVariable Long id) {
//         usuarioRepository.deleteById(id);
//     }
// }