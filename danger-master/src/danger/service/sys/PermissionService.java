package danger.service.sys;

import java.util.List;
import danger.bean.sys.*;;

public interface PermissionService {
	 /**
     * 查询所有的权限
     * @return 权限集合
     */
    public 	List<Permission> getAllpermission();
}
