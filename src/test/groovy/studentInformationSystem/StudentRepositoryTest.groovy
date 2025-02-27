package studentInformationSystem

import com.practice.studentInformationSystem.repository.StudentRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import spock.lang.Specification

class StudentRepositoryTest extends Specification {

    def namedParameterJdbcTemplate = Mock(NamedParameterJdbcTemplate)
    def studentRepository = new StudentRepository(namedParameterJdbcTemplate)

    def "should get student information by id"(){
        given:
            def id = 77
        and:
            1 * namedParameterJdbcTemplate.queryForObject(StudentRepository.FETCH_STUDENT, _ as MapSqlParameterSource, _)
        when:
            studentRepository.getStudentById(id)
        then:
            noExceptionThrown()
    }

    def "should update student record by id"() {
        given:
            def student = DomainObjectGenerator.StudentRow(77, "AAA", "BBB", 686)
        and:
            1 * namedParameterJdbcTemplate.update(StudentRepository.UPDATE_STUDENT, _ as MapSqlParameterSource) >> 1
        when:
            def result = studentRepository.updateStudent(student)
        then:
            result == true
            noExceptionThrown()
    }

    def "should add row in student table"() {
        given:
            def student = DomainObjectGenerator.StudentRow(77, "AAA", "BBB", 686)
        and:
            1 * namedParameterJdbcTemplate.update(StudentRepository.INSERT_STUDENT, _ as MapSqlParameterSource) >> 1
        when:
            def result = studentRepository.insertStudent(student)
        then:
            result == true
            noExceptionThrown()
    }


    def "should delete student record by id"() {
        given:
            def id = 77
        and:
            1 * namedParameterJdbcTemplate.update(StudentRepository.DELETE_STUDENT, _ as MapSqlParameterSource) >> 1
        when:
            def result = studentRepository.deleteStudent(id)
        then:
            result == true
            noExceptionThrown()
    }

}