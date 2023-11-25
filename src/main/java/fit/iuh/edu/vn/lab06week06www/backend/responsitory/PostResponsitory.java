package fit.iuh.edu.vn.lab06week06www.backend.responsitory;

import fit.iuh.edu.vn.lab06week06www.backend.modules.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostResponsitory extends JpaRepository<Post,Long> {
}
