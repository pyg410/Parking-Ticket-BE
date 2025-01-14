package com.jnu.ticketdomain.domains.registration.repository;


import com.jnu.ticketdomain.domains.registration.domain.Registration;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // 신청, 구간 한꺼번에 조회
    @Query("SELECT r FROM Registration r  join fetch r.sector WHERE r.user.id = :userId")
    Optional<Registration> findByUserId(@Param("userId") Long userId);

    Optional<Registration> findById(Long id);

    Optional<Registration> findByEmail(String email);

    @Query(
            "select r from Registration r where r.isDeleted = false and r.isSaved = true and r.sector.event.id = :eventId")
    List<Registration> findByIsDeletedFalseAndIsSavedTrue(@Param("eventId") Long eventId);

    @Query("DELETE FROM Registration r WHERE r.sector.id = :id")
    @Modifying
    void deleteBySectorId(Long id);

    Boolean existsByEmailAndIsSavedTrue(String email);

    Boolean existsByStudentNumAndIsSavedTrue(String studentNum);
}
