package studentInformationSystem

import com.practice.studentInformationSystem.domain.StudentRequest

class DomainObjectGenerator {

    static def StudentRow(final Integer id, final String name, final String address, final Integer phone){
        return StudentRequest.builder()
            .id(id)
            .name(name)
            .address(address)
            .phone(phone)
            .build()
    }
}
