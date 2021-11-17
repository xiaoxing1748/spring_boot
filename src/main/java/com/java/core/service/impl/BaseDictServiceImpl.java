package com.java.core.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.core.dao.BaseDictDao;
import com.java.core.po.BaseDict;
import com.java.core.service.BaseDictService;
/**
 * 数据字典Service接口实现类
 */
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService{	
	@Autowired
	private BaseDictDao baseDictDao;
	//根据类别代码查询数据字典
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}
}
