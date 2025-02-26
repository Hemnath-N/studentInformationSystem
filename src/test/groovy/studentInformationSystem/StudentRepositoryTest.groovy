package studentInformationSystem

import com.practice.studentInformationSystem.repository.StudentRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import spock.lang.Specification

class StudentRepositoryTest extends Specification {

    def namedParameterJdbcTemplate = Mock(NamedParameterJdbcTemplate)
    def studentRepository = new StudentRepository(namedParameterJdbcTemplate)

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