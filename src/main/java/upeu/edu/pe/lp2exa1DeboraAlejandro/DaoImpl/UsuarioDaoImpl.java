package upeu.edu.pe.lp2exa1DeboraAlejandro.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Dao.UsuarioDao;
import upeu.edu.pe.lp2exa1DeboraAlejandro.Entity.Usuario;

@Repository

public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Override
	public Usuario read(String nomuser) {
		String SQL = "select *from usuario where nomuser=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {nomuser}, 
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
}
	
}