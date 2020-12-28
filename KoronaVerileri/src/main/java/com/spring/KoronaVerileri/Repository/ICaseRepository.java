package com.spring.KoronaVerileri.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.KoronaVerileri.Model.CaseModel;

public interface ICaseRepository extends MongoRepository<CaseModel, String>{
	
	//MongoRepository provides save(), findOne(), findById(), findAll(), count(), delete(), deleteById()
	CaseModel findBy_id(ObjectId id);
	
}



