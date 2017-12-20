package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;

import java.util.List;
import java.util.Set;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Set<Role> findById(Long id);
	
	// @NamedQuery(name = "findUserRoles", 
	
	@Query ( "select distinct a from Role a " + 
			"	                join a.users t " + 
			"	                where t.username = :username")

	
	Set<Role> findUserRoles(String username);
	
//		    + "FROM Player p, IN (p.teams) t " + "WHERE p.id =  :playerId")
//	
//	@Query(" select r from Order o left outer join o.renewedOrders r where o.id =:orderId  "
//			+ "  " )	
//	select r from Order o left outer join o.renewedOrders r where o.id =:orderId 
//	List<Role> findRolesForUser();
	
//	String[] tags = {"Java", "Hibernate"};
//	String hql = "select distinct a from Article a " +
//	                "join a.tags t " +
//	                "where t.name in (:tags)";
//	Query query = session.createQuery(hql);
//	query.setParameterList("tags", tags);
//	List<Article> articles = query.list();	
	
}
