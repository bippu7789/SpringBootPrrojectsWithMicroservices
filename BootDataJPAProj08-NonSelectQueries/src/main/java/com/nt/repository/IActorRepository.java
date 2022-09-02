package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	// @Query("from Actor where category=?1")
	// @Query("from com.nt.entity.Actor a where a.category=?1")
	// @Query("select a from com.nt.entity.Actor a where a.category=?1")
	@Query("from Actor where category=:role") // named parametre
	Iterable<Actor> searchActorByCategory(String role);
//	Iterable<Actor> searchActorByCategory(@Param("role") String category);

//	@Query("from Actor where mobileNo in(?1,?3,?2) order by aname")
//	Iterable<Actor> findActorsByMobileNumbers(long no1, long no2, long no3);

	@Query("from Actor where mobileNo in(?1,?3,?2) order by aname")
	Iterable<Actor> findActorsByMobileNumbers(long no1, long no2, long no3);

	@Query("select aid,aname,category from Actor where category in(:cat1,:cat2,:cat3)")
	public List<Object[]> findActorsDataByCategoties(String cat1, String cat2, String cat3);

	@Query("select aname from Actor where aname like :letters%")
	public List<String> findActorNameByStartLetters(String letters);

	// Entity Query giving single record
	@Query("from Actor where mobileNo=:no")
	public Actor getActorByMobileNo(@Param("no") long mobileNo);

	// Scaler query giving multiple specific column values of a single record
	@Query("select aid,aname,category from Actor where mobileNo=:mno")
	public Object getActorDataByMobileNo(long mno);

	// scaler query giving specific single column value of a records
	@Query("select aname from Actor where mobileNo=:mno ")
	public String getActorNameByMobileNo(long mno);

	@Query("select count(*),max(aid),min(aid),sum(aid),avg(aid) from Actor")
	public Object getActorsAggrigateData();

	@Query("from Actor where aid=(select max(aid) from Actor)")
	public Actor getActorDataByMaxActorId();

}
