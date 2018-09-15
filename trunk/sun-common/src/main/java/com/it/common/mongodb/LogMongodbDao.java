package com.it.common.mongodb;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Component;
//import com.py.it.common.mongodb.model.InterfaceLog;
 
/**
 * @author xuqiao
 */
//@Component
public class LogMongodbDao {
//	@Autowired
//	private MongoTemplate mongoTemplate;
//	
//	public void insert(InterfaceLog interfaceLog) {
//		mongoTemplate.insert(interfaceLog);
//	}
//	public void deleteById(int id) {
//		Criteria criteria = Criteria.where("id").in(id);
//		Query query = new Query(criteria);
//		mongoTemplate.remove(query, InterfaceLog.class);
//	}
//	public void updateById(InterfaceLog InterfaceLog) {
//		Criteria criteria = Criteria.where("id").in(InterfaceLog.getId());
//		Query query = new Query(criteria);
//		Update update = new Update();
//		update.set("bizCode", InterfaceLog.getBizCode());
//		mongoTemplate.updateMulti(query, update, InterfaceLog.class);
//	}
//	public InterfaceLog selectById(int id) {
//		Criteria criteria = Criteria.where("id").in(id);
//		Query query = new Query(criteria);
//		return mongoTemplate.findOne(query, InterfaceLog.class);
//	}
}
