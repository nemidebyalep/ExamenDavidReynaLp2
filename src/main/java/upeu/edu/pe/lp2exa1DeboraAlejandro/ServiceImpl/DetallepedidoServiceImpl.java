package upeu.edu.pe.lp2exa1DeboraAlejandro.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Dao.DetallePedidoDao;
import upeu.edu.pe.lp2exa1DeboraAlejandro.Entity.DetallePedido;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Service.DetallepedidoService;
@Service
public class DetallepedidoServiceImpl implements DetallepedidoService{

	@Autowired
	private DetallePedidoDao detallepedidoDao;  

	@Override
	public DetallePedido read(int id) {
		// TODO Auto-generated method stub
		return detallepedidoDao.read(id);
	}
	

}
