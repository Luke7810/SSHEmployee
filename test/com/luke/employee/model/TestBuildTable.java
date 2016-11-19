package com.luke.employee.model;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBuildTable {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
		public static void beforeClass() {
			new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		
	@AfterClass
		public static void afterClass() {
			sessionFactory.close();
		}
		
		
		public static void main(String[] args) {
			beforeClass();
		}
		
		@Test
		public void testSaveEmployee(){
			Employee user = new Employee();
			user.setLastname("TestUser1");
			Department d = new Department();
			d.setDepName("TestD");
			user.setDepartment(d);
			
			Session s = sessionFactory.getCurrentSession();
			s.beginTransaction();
			
			//s.save(g);
			s.save(user);
			
			s.getTransaction().commit();
		}
		
		
		/*
		@Test
		public void testSaveGroup(){
			Group g = new Group();
			g.setName("New Group 1");
			g.setDescm("New grup");
			
			User user1 = new User();
			user1.setName("TestUser1");
			user1.setAge(10);
			User user2 = new User();
			user2.setName("TestUser2");
			user2.setAge(20);
			User user3 = new User();
			user3.setName("TestUser3");
			user3.setAge(30);
			
			g.getUsers().add(user1);
			g.getUsers().add(user2);
			g.getUsers().add(user3);
			
			user1.setGroup(g);
			user2.setGroup(g);
			user3.setGroup(g);
			
			Session s = sessionFactory.getCurrentSession();
			s.beginTransaction();
			
			s.save(g);
			
			s.getTransaction().commit();
		}
		
		@Test
		public void testReadUser(){
			
			testSaveGroup();
			
			Session s = sessionFactory.getCurrentSession();
			s.beginTransaction();
			
			User u = (User)s.get(User.class, 1);
			System.out.println(u.getName());
			Group g = u.getGroup();
			System.out.println(g.getName());
			s.getTransaction().commit();
		}
		
		@Test
		public void testReadGroup(){
			testSaveGroup();
			Session s = sessionFactory.getCurrentSession();
			s.beginTransaction();
			
			Group g = (Group)s.get(Group.class, 1);
			System.out.println(g.getName());
			
			for(User u : g.getUsers()){
				
				System.out.println(u.getName());
			}
			
			s.getTransaction().commit();
		}
		
		@Test
		public void testDeleteUser(){
			testSaveGroup();
			
			Session s = sessionFactory.getCurrentSession();
			s.beginTransaction();
			s.createQuery("delete from User u where u.id=1").executeUpdate();
			s.getTransaction().commit();
		}
	*/
}
