package tw.edu.nuk.java2.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.nuk.java2.dao.animalsDao;
import tw.edu.nuk.java2.model.animals;

@Controller
public class ServiceFacade {
	

	@Autowired
	private animalsDao animalsDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	

    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public void sayHello() {
	}
	
   
    @RequestMapping(value="/insert", method=RequestMethod.GET)
	public String setupInsertion(Model model) {
    	
    	animals animals = new animals();
    	model.addAttribute("animals", animals);
    	return "Insert";
	}
    
    @RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional
	public String doInsertion(@ModelAttribute("animals") animals animlas, Model model) {
    //	animalsDao.saveOrUpdate(animals);  
		//model.addAttribute("no", animals.getno());
		//model.addAttribute("no", animals.getno());
	//	model.addAttribute("category", animals.getcategory());
    	
    	return "redirect:query";
	}
    
    @RequestMapping(value="/update")
    @Transactional
	public String setupUpdateForm(Model model, @RequestParam(value="custid", defaultValue="") String custid) {
    	
    //	animals animals = animalsDao.get(Long.parseLong(no));
    //	model.addAttribute("animals", animals);
    	return "Update";
	}
  
    @RequestMapping(value="/updateConfirm")
	@Transactional
	public String doUpdate(@ModelAttribute("animals") animals animals, Model model) {
    	animalsDao.saveOrUpdate(animals);  
		model.addAttribute("no", animals.getno());
		model.addAttribute("no", animals.getno());
		model.addAttribute("category", animals.getcategory());
    	
    	return "redirect:query";
	}
  /*  
    @RequestMapping(value="/updateConfirm")
	@Transactional
	public String doUpdate(@ModelAttribute("customer") Customer customer, Model model){
    	
    	//Transaction tx = null;
    	Session session = null;
    	try {
			session = sessionFactory.getCurrentSession();
			//tx = session.getTransaction();
			//tx.begin();
			session.saveOrUpdate(customer);			
			//customerDao.saveOrUpdate(customer);  
			model.addAttribute("companyName", customer.getCompanyName());
			model.addAttribute("contactName", customer.getContactName());
			model.addAttribute("contactTitle", customer.getContactTitle());
			//tx.commit();
		} catch (HibernateException e) {
			try {
				//if (tx!=null) {
				//	tx.rollback();
				//}
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (session != null) {
				//session.close();
			}
		}
    	
    	return "redirect:query";
    }
    */
    
	@RequestMapping(value="/query")
	@Transactional
	public String doQuery(@RequestParam(value="no", defaultValue="") String no,
			@RequestParam(value="category", defaultValue="") String category,
			@RequestParam(value="gender", defaultValue="") String gender,
			Model model) {
		Map<String, String> conditions = new HashMap<String,String>();
		conditions.put("no", no);
		conditions.put("category", category);
		conditions.put("gender", gender);
		model.addAttribute("animals", animalsDao.search(conditions));
		model.addAttribute("no", no);
		model.addAttribute("category", category);
		model.addAttribute("gender", gender);
		return "Browse";
	}
	
	@RequestMapping(value="/delete")
	@Transactional
	public String doDeletion(@RequestParam(value="no", defaultValue="") String no,
			@RequestParam(value="category", defaultValue="") String category,
			@RequestParam(value="gender", defaultValue="") String gender,
			@RequestParam(value="findregion", defaultValue="") String findregion,
			Model model, HttpServletResponse response) {
		
		animalsDao.delete(Long.parseLong(no));
		model.addAttribute("category", category);
		model.addAttribute("gender", gender);
		model.addAttribute("findregion", findregion);
				
		return "redirect:query";
	}
	

}
