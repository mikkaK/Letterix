package ch.letterix.letterix_backend.domain.storage_object;

import ch.letterix.letterix_backend.core.generic.AbstractRepository;
import ch.letterix.letterix_backend.core.generic.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StorageObjectServiceImpl extends AbstractServiceImpl<StorageObject> implements StorageObjectService {
    protected StorageObjectServiceImpl(AbstractRepository<StorageObject> repository) {
        super(repository);
    }
}
