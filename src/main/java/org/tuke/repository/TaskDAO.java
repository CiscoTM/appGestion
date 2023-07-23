package org.tuke.repository;

import java.util.List;
import org.tuke.entity.Task;

public interface TaskDAO {
	
	List<Task> findAll();

}
