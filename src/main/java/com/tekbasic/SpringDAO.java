package com.tekbasic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class SpringDAO {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void insert() {
		jt.execute("INSERT INTO employee (name, eid, account, address, designation, ename, esalary) VALUES ('mohamed', 1, 'debit', 'chicago', 'desig1', 'f', 1234)");
	}
	public void update() {
		jt.execute("UPDATE employee t SET t.name = 'mohamed2', t.account = 'credit' WHERE t.name LIKE 'mohamed' AND t.eid = 1 ");
	}
	public void delete() {
		jt.execute("DELETE FROM employee WHERE name LIKE 'mohamed2'");
	}
	
	public void select() {
		List<Map<String, Object>> li = jt.queryForList("select * from employee");
		
		Iterator<Map<String, Object>> i = li.iterator();
		
		while(i.hasNext()) {
			Map<String, Object> m = i.next();
			System.out.println(m.values());
		}
		
	}
	
	
}
