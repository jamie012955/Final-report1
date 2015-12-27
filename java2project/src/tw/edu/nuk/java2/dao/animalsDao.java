package tw.edu.nuk.java2.dao;

import java.util.List;
import java.util.Map;

import tw.edu.nuk.java2.model.animals;

public interface animalsDao {
	animals get(long no);
	void saveOrUpdate(animals animals);
	void delete(animals animals);
	void delete(long no);
	List<animals> search(Map<String,String> conditions);
	
}
