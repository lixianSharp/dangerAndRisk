package danger.service.impl.queryView;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import danger.mapper.dangerManage.DangerMapper;

@Controller
public class TestTranServiceImpl {

	@Resource
	private DangerMapper dangerMapper;

	public void deleteTestTrans() {
		dangerMapper.deleteByPrimaryKey(85);
		int i = 1 / 0;
		dangerMapper.deleteByPrimaryKey(84);
	}
}
