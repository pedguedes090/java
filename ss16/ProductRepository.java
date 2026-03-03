import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IRepository<Product> {
    private final List<Product> list = new ArrayList<>();
    private final Map<String, Product> map = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null) return false;
        String id = item.getId();
        if (map.containsKey(id)) return false;
        list.add(item);
        map.put(id, item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null) return false;
        Product removed = map.remove(id);
        if (removed != null) {
            list.remove(removed);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        if (id == null) return null;
        return map.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(list);
    }
}
