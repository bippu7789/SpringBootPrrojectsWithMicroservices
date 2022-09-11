package com.nt.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonMnmtService;

@Component
public class AssociationMappingTestRunner implements CommandLineRunner {
	@Autowired
	IPersonMnmtService service;

	@Override
	public void run(String... args) throws Exception {
		// save object operation(Parent to chield)
//		Person per = new Person();
//		per.setPname("BIPIN");
//		per.setPaddrs("Noida");
//
//		PhoneNumber ph = new PhoneNumber();
//		ph.setNumberType("Office");
//		ph.setPhone_number(9695573777L);
//		ph.setProvide("Airtel");
//
//		PhoneNumber ph2 = new PhoneNumber();
//		ph2.setNumberType("Recidance");
//		ph2.setPhone_number(9695573799L);
//		ph2.setProvide("JIO");
//		// Map the object(Parent to chield and chield to parent)
//		ph.setPerson(per); // parent to chield
//		ph2.setPerson(per);// chield to parent
//
//		List<PhoneNumber> phoSet =  Arrays.asList(ph, ph2);
//		try {
//			System.out.println(service.saveDataUsingPerson(per));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
		// saved object operation chield to parent
		Person per = new Person();
		per.setPname("Mahesh");
		per.setPaddrs("Delhi");

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumberType("Office");
		ph1.setPhone_number(9695573333L);
		ph1.setProvide("Vodafone");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumberType("residance");
		ph2.setPhone_number(9333333333L);
		ph2.setProvide("VI");
		// map the object (parent to chield (many to one))
		Set<PhoneNumber> phonSet = new HashSet<PhoneNumber>();
		phonSet.add(ph1);
		phonSet.add(ph2);
		per.setPhones(phonSet);
		try {
			System.out.println(service.savedataUsingPhoneNumber(phonSet));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}