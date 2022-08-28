package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;
import com.nt.entity.ResultView;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	// Select *from data jpa actor where aname=?
	public List<Actor> findByAnameEquals(String name);

	// select *from data_jpa_actor where findByAname=?
	public Iterable<Actor> findByAnameIs(String name);

	// select *from data_jpa_actor where find by a name?
	public Iterable<Actor> findByAname(String name);

	// Select *from data_jpa_actor where aid between ? andd ?
	public Iterable<Actor> findByAidBetween(int start, int end);

	// Select *from data_jpa_actor where aname Like %?T
	public Iterable<Actor> findByAnameLike(String startChar);
	// Select *from data_jpa_actor where aname Like %?T

	public Iterable<Actor> findByAnameStartingWith(String startChar);
	// Select *from data_jpa_actor where aname Like %?%

	public Iterable<Actor> findByAnameContainingIgnoreCase(String chars);
	// Select *from data_jpa_actor where upper catagory in order by AnameAsc ???

	public Iterable<Actor> findByCategoryInIgnoreCaseOrderByAnameAsc(Iterable<String> categories);

	// Select *from data_jpa_actor where aid>start and aid<=end ?
	public Iterable<Actor> findByAidGreaterThanEqualAndAidLessThanEqual(int start, int end);

	// select *from data_jpa_actor where statusIsEqual=1 and category=?
	public Iterable<Actor> findByStatusTrueOrCategoryEquals(String ccategory);

	// select *from data_jpa_actor (aid>? and aid<?) or (uppercategories) not in ???
	public Iterable<Actor> findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(int start, int end,
			String... categories);

	// Select Aid,aname from data_jpa_actor
	public Iterable<ResultView> findByCategoryEqualsIgnoreCase(String category);

	public ResultView findByMobileNo(long mobileNumber);

	public Actor findByMobileNoIs(long mobileNumber);

}
