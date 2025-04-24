import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Document {
    private final int id;
    private final String name;
    private final List<Document> relatedDocs = new ArrayList<>();

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void addRelatedDocument(Document doc) {
        relatedDocs.add(doc);
    }
    public void edit(){
        List<Document> listForSort = new ArrayList<>(relatedDocs);
        listForSort.add(this);
        listForSort.sort(Comparator.comparing(Document::getId));
        lockByOrder(listForSort, 0);
    }

    public void lockByOrder(List<Document> document, int i) {
        if (i == document.size()){ // базовий случай (условие остановки)
            System.out.println(Thread.currentThread().getName() + " редактирует " + name);
            for (Document doc : relatedDocs) {
                System.out.println(Thread.currentThread().getName() + " редактирует связанный документ " + doc.name);
                // имитация редактирования
            }
        return;
        }

        synchronized (document.get(i)) {
            lockByOrder(document, i + 1);
        }
    }

    public String getName() {
        return name;
    }

    public List<Document> getRelatedDocs() {
        return relatedDocs;
    }
}



