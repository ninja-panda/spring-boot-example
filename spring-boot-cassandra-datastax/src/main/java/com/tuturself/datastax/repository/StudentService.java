package com.tuturself.datastax.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.tuturself.datastax.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.UUID;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;


@Service
public class StudentService {

    @Autowired
    private CassandraConnector cassandraConnector;

    @Value("${cassandra.keyspace.name}")
    private String keyspaceName;

    private Session session;
    private MappingManager manager;
    private Mapper<Student> mapper;

    @PostConstruct
    public void init() {
        try {
            session = cassandraConnector.getSession();
            manager = new MappingManager(session);
            mapper = manager.mapper(Student.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initiate StudentService", e);
        }
    }

    public Result<Student> getStudentById(UUID studentId) throws Exception {
        Result<Student> result = null;
        Statement statement = QueryBuilder
                .select()
                .from(keyspaceName, "student")
                .where(eq("student_id", studentId)).setFetchSize(10);
        statement.setConsistencyLevel(cassandraConnector.getConsistencyLevel());
        try {
            ResultSet resultSet = session.execute(statement);
            result = mapper.map(resultSet);

        } catch (Exception e) {
            throw new Exception("Failed to search Student for studentId :" + studentId.toString(), e);
        }
        return result;
    }

    public UUID createStudent(Integer deptId, String name, String address) throws Exception {
        Student student = new Student();
        student.setStudentId(UUID.randomUUID());
        student.setDepartmentId(deptId);
        student.setName(name);
        student.setAddress(address);
        mapper.save(student);
        return student.getStudentId();
    }

    public void delete(UUID studentId) throws Exception {
        Student student = getStudentById(studentId).one();
        mapper.delete(student);
    }
}
