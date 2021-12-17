
package com.sw.developer.project.pullrequest.business.repository.interfaces;

import com.sw.developer.project.pullrequest.persistence.dto.implementations.PullRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPullRequestRepository extends JpaRepository<PullRequestDTO,Long> {
}


