package danger.service.impl.queryView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danger.bean.queryView.Tongji;
import danger.mapper.queryView.TongjiMapper;
import danger.service.queryView.TongjiService;

@Service
public class TongjiServiceImpl implements TongjiService {
	@Autowired
	private TongjiMapper tongjiMapper;

	@Override
	public List<Tongji> getTongjiInfo(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return tongjiMapper.getTongjiInfo(condition);
	}

	@Override
	public Tongji getTotalInfo(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return tongjiMapper.getTotalInfo(condition);
	}
	

	
	
	
	

}
