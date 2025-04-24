import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

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

    public void edit() {
        List<Document> allDocsToLock = new ArrayList<>(relatedDocs);
        allDocsToLock.add(this);

        // Упорядочиваем блокировки по ID
        allDocsToLock.sort(Comparator.comparingInt(Document::getId));

        for (Document doc : allDocsToLock) {
            synchronized (doc) {
                System.out.println(Thread.currentThread().getName() + " редактирует " + doc.name);
                // имитация редактирования
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Document> getRelatedDocs() {
        return relatedDocs;
    }
}
