package upeu.edu.pe.lp2exa1DeboraAlejandro.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Dao.DetallePedidoDao;
import upeu.edu.pe.lp2exa1DeboraAlejandro.Entity.DetallePedido;
@Repository
public class DetallepedidoDaoImpl implements DetallePedidoDao{
		@Autowired
		private JdbcTemplate jdbcTemplate;
		@Override
		public DetallePedido read(int id){
			
			// TODO Auto-generated method stub
	        String SQL = "SELECT * FROM detalle_pedido WHERE iddetalle_pedido=?";
			return jdbcTemplate.queryForObject(SQL, new Object[]{id} , 
					new BeanPropertyRowMapper<DetallePedido>(DetallePedido.class)) ;
		}
}
