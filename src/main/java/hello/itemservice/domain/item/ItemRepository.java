package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실무에서는 멀티 스레드이기 때문에 HashMap 대신 ConcurrentHashMap을 써야 한다.
    private static final Map<Long, Item> store = new HashMap<>();
    public static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        // 컬렉션으로 한 번 감싸서 반환하면 store 자체 값에는 영향을 미치지 않는다.
        return new ArrayList<>(store.values());
    }

    // 정석대로라면 id 없이 필요한 파라미터만 있는 객체를 따로 사용하는 게 좋다. 안쓰는 프로퍼티가 있으면 개발자가 헷갈릴 수 있다.
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
