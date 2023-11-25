package fit.iuh.edu.vn.lab06week06www.backend.responsitory;

import fit.iuh.edu.vn.lab06week06www.backend.modules.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostComponentResponsitory extends JpaRepository<PostComment,Long> {
}
