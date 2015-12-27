package tw.edu.nuk.java2.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.nuk.java2.dao.animalsDao;
import tw.edu.nuk.java2.model.animals;

@Component
public class HBManimalsDao implements animalsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public animals get(long no) {
		return (animals) sessionFactory.getCurrentSession().get(animals.class, no);
	}

	@Override
	public void saveOrUpdate(animals animals) {
		sessionFactory.getCurrentSession().saveOrUpdate(animals);
	}

	@Override
	public void delete(animals animals) {
		sessionFactory.getCurrentSession().delete(animals);

	}

	@Override
	public void delete(long no) {
		animals animals = get(no);
        if (animals != null) {
            delete(animals);
        }
	}

	@Override
	public List<animals> search(Map<String,String> conditions) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(animals.class);
		for (Map.Entry<String, String> entry : conditions.entrySet()) {
			criteria.add(Restrictions.like(entry.getKey(), makeLikeString(entry.getValue())));
		}
		criteria.addOrder(Order.asc("no"));		
		
		return criteria.list();
	}
	
	private String makeLikeString(String str) {
		String retVal = str.replace("%", "");
		retVal = "%" + retVal + "%";
		
		return retVal;
	}

}
